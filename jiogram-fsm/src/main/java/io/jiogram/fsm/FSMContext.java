package io.jiogram.fsm;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.fsm.storage.StateStorage;
import org.jspecify.annotations.Nullable;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

/**
 * High-level API for interacting with FSM state and data.
 * Wraps a {@link StateStorage} with a specific {@link StorageKey} to provide
 * convenient methods for state transitions and data management.
 */
public class FSMContext {

    /** Converts JSON-shaped stored values back to the requested type (see {@link #getValue}). */
    private static final ObjectMapper VALUE_MAPPER = new ObjectMapper()
        .findAndRegisterModules()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final StateStorage storage;
    private final StorageKey key;

    public FSMContext(StateStorage storage, StorageKey key) {
        this.storage = storage;
        this.key = key;
    }

    /**
     * Sets the current state using any enum constant.
     * Stores a name in the format {@code EnumSimpleName.CONSTANT_NAME}.
     *
     * @param state the state to set
     * @return a Mono that completes when the state has been persisted
     */
    public Mono<Void> setState(Enum<?> state) {
        return storage.setState(key, state.getDeclaringClass().getSimpleName() + "." + state.name());
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
    public Mono<Void> updateData(String field, @Nullable Object value) {
        return storage.updateData(key, Collections.singletonMap(field, value));
    }

    /**
     * Merges several key-value pairs into the existing data in one atomic update.
     *
     * @param fields the fields to set
     * @return a Mono that completes when the data has been persisted
     */
    public Mono<Void> updateData(Map<String, Object> fields) {
        return storage.updateData(key, fields);
    }

    /**
     * Retrieves a single value from the stored data as the given type.
     * <p>
     * Storages that serialize data (e.g. Redis) return JSON-shaped values: a {@code long}
     * may come back as an {@code Integer} and a record as a {@code Map}. Such values are
     * converted to {@code type} with Jackson.
     *
     * @param field the data field name
     * @param type  the expected value type
     * @param <T>   the value type
     * @return a Mono emitting the value, or empty if the field does not exist; an
     *         {@link IllegalArgumentException} if the value cannot be converted
     */
    public <T> Mono<T> getValue(String field, Class<T> type) {
        return storage.getData(key)
            .defaultIfEmpty(Map.of())
            .flatMap(data -> {
                Object value = data.get(field);
                if (value == null) {
                    return Mono.empty();
                }
                if (type.isInstance(value)) {
                    return Mono.just(type.cast(value));
                }
                return Mono.fromCallable(() -> VALUE_MAPPER.convertValue(value, type));
            });
    }

    /**
     * Clears both the state and all data for this context.
     *
     * @return a Mono that completes when state and data have been cleared
     */
    public Mono<Void> clear() {
        return storage.clear(key);
    }

    /**
     * Returns the storage key associated with this context.
     */
    public StorageKey key() {
        return key;
    }
}
