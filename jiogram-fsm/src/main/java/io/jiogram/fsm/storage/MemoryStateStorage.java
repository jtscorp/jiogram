package io.jiogram.fsm.storage;

import io.jiogram.fsm.StorageKey;
import org.jspecify.annotations.Nullable;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory implementation of {@link StateStorage} backed by {@link ConcurrentHashMap}.
 * Suitable for single-instance deployments and testing. State is lost on JVM restart.
 */
public class MemoryStateStorage implements StateStorage {

    /** A key's state and data; immutable, replaced as a whole on every write. */
    private static final class StateRecord {

        private final @Nullable String state;
        private final Map<String, Object> data;

        StateRecord(@Nullable String state, Map<String, Object> data) {
            this.state = state;
            this.data = data;
        }

        @Nullable String state() {
            return state;
        }

        Map<String, Object> data() {
            return data;
        }
    }

    private final ConcurrentHashMap<StorageKey, StateRecord> store = new ConcurrentHashMap<>();

    @Override
    public Mono<Void> setState(StorageKey key, @Nullable String state) {
        return Mono.fromRunnable(() ->
            store.compute(key, (k, existing) -> {
                Map<String, Object> data = existing != null ? existing.data() : Map.of();
                return new StateRecord(state, data);
            })
        );
    }

    @Override
    public Mono<String> getState(StorageKey key) {
        return Mono.defer(() -> {
            StateRecord record = store.get(key);
            if (record != null && record.state() != null) {
                return Mono.just(record.state());
            }
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> setData(StorageKey key, Map<String, Object> data) {
        return Mono.fromRunnable(() ->
            store.compute(key, (k, existing) -> {
                String state = existing != null ? existing.state() : null;
                return new StateRecord(state, copyOf(data));
            })
        );
    }

    @Override
    public Mono<Void> updateData(StorageKey key, Map<String, Object> fields) {
        // compute() runs atomically per key, so concurrent updates cannot lose fields.
        return Mono.fromRunnable(() ->
            store.compute(key, (k, existing) -> {
                Map<String, Object> merged = new HashMap<>(existing != null ? existing.data() : Map.of());
                merged.putAll(fields);
                return new StateRecord(existing != null ? existing.state() : null, copyOf(merged));
            })
        );
    }

    @Override
    public Mono<Void> clear(StorageKey key) {
        // Remove the entry rather than storing an empty one, so the map does not grow per user.
        return Mono.fromRunnable(() -> store.remove(key));
    }

    /** Unmodifiable copy that, unlike Map.copyOf, allows null values. */
    private static Map<String, Object> copyOf(Map<String, Object> data) {
        return Collections.unmodifiableMap(new HashMap<>(data));
    }

    @Override
    public Mono<Map<String, Object>> getData(StorageKey key) {
        return Mono.defer(() -> {
            StateRecord record = store.get(key);
            if (record != null) {
                return Mono.just(record.data());
            }
            return Mono.just(Map.of());
        });
    }

    @Override
    public Mono<Void> close() {
        return Mono.fromRunnable(store::clear);
    }
}
