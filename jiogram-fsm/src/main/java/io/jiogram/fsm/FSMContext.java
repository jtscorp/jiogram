package io.jiogram.fsm;

import io.jiogram.fsm.storage.StateStorage;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * High-level API for interacting with FSM state and data.
 * Wraps a {@link StateStorage} with a specific {@link StorageKey} to provide
 * convenient methods for state transitions and data management.
 */
public class FSMContext {

    private final StateStorage storage;
    private final StorageKey key;

    public FSMContext(StateStorage storage, StorageKey key) {
        this.storage = storage;
        this.key = key;
    }

    /**
     * Sets the current state using a {@link BotState} enum constant.
     * Stores the {@link BotState#fullName()} as the state string.
     *
     * @param state the state to set
     * @return a Mono that completes when the state has been persisted
     */
    public Mono<Void> setState(BotState state) {
        return storage.setState(key, state.fullName());
    }

    /**
     * Sets the current state using a raw string.
     *
     * @param state the state name to set, or null to clear
     * @return a Mono that completes when the state has been persisted
     */
    public Mono<Void> setState(String state) {
        return storage.setState(key, state);
    }

    /**
     * Gets the current state name.
     *
     * @return a Mono emitting the current state string, or empty if no state is set
     */
    public Mono<String> getState() {
        return storage.getState(key);
    }

    /**
     * Gets all stored data for this context.
     *
     * @return a Mono emitting the data map
     */
    public Mono<Map<String, Object>> getData() {
        return storage.getData(key);
    }

    /**
     * Replaces all stored data with the provided map.
     *
     * @param data the new data map
     * @return a Mono that completes when the data has been persisted
     */
    public Mono<Void> setData(Map<String, Object> data) {
        return storage.setData(key, data);
    }

    /**
     * Merges a single key-value pair into the existing data.
     * If the key already exists, its value is overwritten.
     *
     * @param field the data field name
     * @param value the value to store
     * @return a Mono that completes when the data has been persisted
     */
    public Mono<Void> updateData(String field, Object value) {
        return storage.getData(key)
            .defaultIfEmpty(Map.of())
            .flatMap(existing -> {
                var updated = new HashMap<>(existing);
                updated.put(field, value);
                return storage.setData(key, updated);
            });
    }

    /**
     * Retrieves a single value from the stored data, casting it to the specified type.
     *
     * @param field the data field name
     * @param type  the expected value type
     * @param <T>   the value type
     * @return a Mono emitting the value, or empty if the field does not exist
     */
    public <T> Mono<T> getValue(String field, Class<T> type) {
        return storage.getData(key)
            .defaultIfEmpty(Map.of())
            .flatMap(data -> {
                Object value = data.get(field);
                if (value == null) {
                    return Mono.empty();
                }
                return Mono.just(type.cast(value));
            });
    }

    /**
     * Clears both the state and all data for this context.
     *
     * @return a Mono that completes when state and data have been cleared
     */
    public Mono<Void> clear() {
        return storage.setState(key, null)
            .then(storage.setData(key, Map.of()));
    }

    /**
     * Returns the storage key associated with this context.
     */
    public StorageKey key() {
        return key;
    }
}
