package io.jiogram.fsm.storage;

import io.jiogram.fsm.StorageKey;
import org.jspecify.annotations.Nullable;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * Reactive interface for FSM state persistence.
 * Implementations store state names and arbitrary key-value data
 * associated with a {@link StorageKey}.
 */
public interface StateStorage {

    /**
     * Sets the current state for the given key.
     * Pass {@code null} to clear the state.
     *
     * @param key   the storage key
     * @param state the state name, or null to clear
     * @return a Mono that completes when the state has been persisted
     */
    Mono<Void> setState(StorageKey key, @Nullable String state);

    /**
     * Gets the current state for the given key.
     *
     * @param key the storage key
     * @return a Mono emitting the state name, or empty if no state is set
     */
    Mono<String> getState(StorageKey key);

    /**
     * Replaces all data for the given key with the provided map.
     *
     * @param key  the storage key
     * @param data the data map to store
     * @return a Mono that completes when the data has been persisted
     */
    Mono<Void> setData(StorageKey key, Map<String, Object> data);

    /**
     * Gets all data for the given key.
     *
     * @param key the storage key
     * @return a Mono emitting the data map, or an empty map if no data exists
     */
    Mono<Map<String, Object>> getData(StorageKey key);

    /**
     * Merges the given fields into the stored data, keeping all other fields.
     * <p>
     * The built-in storages do this atomically, so concurrent updates of the same key (e.g. the
     * photos of one media group) do not lose fields. This default is a plain read-modify-write
     * for custom storages and is <strong>not</strong> atomic; override it where it matters.
     *
     * @param key    the storage key
     * @param fields the fields to set (null values are stored as null)
     * @return a Mono that completes when the data has been persisted
     */
    default Mono<Void> updateData(StorageKey key, Map<String, Object> fields) {
        return getData(key)
            .defaultIfEmpty(Map.of())
            .flatMap(existing -> {
                Map<String, Object> merged = new HashMap<>(existing);
                merged.putAll(fields);
                return setData(key, merged);
            });
    }

    /**
     * Removes both the state and the data of the given key.
     * The default issues two separate writes; the built-in storages override it.
     *
     * @param key the storage key
     * @return a Mono that completes when the key has been cleared
     */
    default Mono<Void> clear(StorageKey key) {
        return setState(key, null).then(setData(key, Map.of()));
    }

    /**
     * Closes the storage and releases any resources.
     *
     * @return a Mono that completes when the storage has been closed
     */
    Mono<Void> close();
}
