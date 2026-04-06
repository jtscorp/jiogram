package io.jiogram.fsm.storage;

import io.jiogram.fsm.StorageKey;
import org.jspecify.annotations.Nullable;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory implementation of {@link StateStorage} backed by {@link ConcurrentHashMap}.
 * Suitable for single-instance deployments and testing. State is lost on JVM restart.
 */
public class MemoryStateStorage implements StateStorage {

    private record StateRecord(@Nullable String state, Map<String, Object> data) {}

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
                return new StateRecord(state, Map.copyOf(data));
            })
        );
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
