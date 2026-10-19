package io.jiogram.fsm.storage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.fsm.StorageKey;
import org.jspecify.annotations.Nullable;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Redis-backed implementation of {@link StateStorage} using Spring's
 * {@link ReactiveStringRedisTemplate}. State and data are stored as separate
 * Redis keys with JSON serialization for the data map.
 *
 * <p>Key format: {@code jiogram:fsm:{botId}:{chatId}:{userId}:{threadId}:{destiny}:{part}}
 * where {@code part} is either "state" or "data". Updates that came through a business
 * connection get an extra {@code bc=<businessConnectionId>} segment before {@code part}.
 *
 * <p>{@link #updateData} is atomic: the merge happens in Java and is written back with a
 * compare-and-set script, retried if another writer changed the data in between. (Merging
 * inside Lua would go through cjson, which loses precision on large numbers such as chat ids.)
 * {@link #clear} deletes both keys with one {@code DEL}; on Redis Cluster the two keys may live
 * in different slots, in which case the client deletes them separately.
 */
public class RedisStateStorage implements StateStorage {

    private static final TypeReference<Map<String, Object>> MAP_TYPE = new TypeReference<>() {};

    /** Sets KEYS[1] to ARGV[2] only if it still holds ARGV[1] ("" meaning absent). */
    private static final RedisScript<Long> COMPARE_AND_SET = RedisScript.of("""
        local current = redis.call('GET', KEYS[1])
        if (current or '') ~= ARGV[1] then
          return 0
        end
        redis.call('SET', KEYS[1], ARGV[2])
        return 1
        """, Long.class);

    private static final int MAX_UPDATE_ATTEMPTS = 32;

    private final ReactiveStringRedisTemplate redis;
    private final ObjectMapper objectMapper;

    public RedisStateStorage(ReactiveStringRedisTemplate redis) {
        ReactiveStringRedisTemplate checkedRedis = Objects.requireNonNull(redis, "redis must not be null");
        // Registers modules found on the classpath (e.g. java.time support).
        this(checkedRedis, new ObjectMapper().findAndRegisterModules());
    }

    public RedisStateStorage(ReactiveStringRedisTemplate redis, ObjectMapper objectMapper) {
        this.redis = Objects.requireNonNull(redis, "redis must not be null");
        this.objectMapper = Objects.requireNonNull(objectMapper, "objectMapper must not be null");
    }

    @Override
    public Mono<Void> setState(StorageKey key, @Nullable String state) {
        String redisKey = buildKey(key, "state");
        if (state == null) {
            return redis.delete(redisKey).then();
        }
        return redis.opsForValue().set(redisKey, state).then();
    }

    @Override
    public Mono<String> getState(StorageKey key) {
        String redisKey = buildKey(key, "state");
        return redis.opsForValue().get(redisKey);
    }

    @Override
    public Mono<Void> setData(StorageKey key, Map<String, Object> data) {
        String redisKey = buildKey(key, "data");
        if (data == null || data.isEmpty()) {
            return redis.delete(redisKey).then();
        }
        return toJson(data).flatMap(json -> redis.opsForValue().set(redisKey, json)).then();
    }

    @Override
    public Mono<Map<String, Object>> getData(StorageKey key) {
        String redisKey = buildKey(key, "data");
        return redis.opsForValue().get(redisKey)
            .flatMap(this::fromJson)
            .defaultIfEmpty(Map.of());
    }

    @Override
    public Mono<Void> updateData(StorageKey key, Map<String, Object> fields) {
        String redisKey = buildKey(key, "data");
        return Mono.defer(() -> redis.opsForValue().get(redisKey)
                .defaultIfEmpty("")
                .flatMap(currentJson -> (currentJson.isEmpty() ? Mono.just(Map.<String, Object>of()) : fromJson(currentJson))
                    .flatMap(current -> {
                        Map<String, Object> merged = new HashMap<>(current);
                        merged.putAll(fields);
                        return toJson(merged);
                    })
                    .flatMap(mergedJson -> redis.execute(COMPARE_AND_SET, List.of(redisKey), List.of(currentJson, mergedJson))
                        .next())))
            .flatMap(applied -> applied == 1L ? Mono.<Void>empty() : Mono.error(new ConcurrentUpdateException()))
            // Jittered backoff so writers that collided do not retry in lockstep.
            .retryWhen(Retry.backoff(MAX_UPDATE_ATTEMPTS - 1, Duration.ofMillis(2))
                .maxBackoff(Duration.ofMillis(100))
                .jitter(0.75)
                .filter(ConcurrentUpdateException.class::isInstance)
                .onRetryExhaustedThrow((spec, signal) -> new IllegalStateException(
                    "FSM data at " + redisKey + " kept changing; gave up after " + MAX_UPDATE_ATTEMPTS + " attempts")));
    }

    @Override
    public Mono<Void> clear(StorageKey key) {
        return redis.delete(buildKey(key, "state"), buildKey(key, "data")).then();
    }

    @Override
    public Mono<Void> close() {
        return Mono.empty();
    }

    private Mono<String> toJson(Map<String, Object> data) {
        try {
            return Mono.just(objectMapper.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            return Mono.error(e);
        }
    }

    private Mono<Map<String, Object>> fromJson(String json) {
        try {
            return Mono.just(objectMapper.readValue(json, MAP_TYPE));
        } catch (JsonProcessingException e) {
            return Mono.error(e);
        }
    }

    /**
     * Builds a Redis key from the storage key components.
     *
     * @param key  the storage key
     * @param part "state" or "data"
     * @return the Redis key string
     */
    String buildKey(StorageKey key, String part) {
        String threadId = key.threadId() != null ? key.threadId().toString() : "-";
        String business = key.businessConnectionId() != null ? ":bc=" + key.businessConnectionId() : "";
        return "jiogram:fsm:" + key.botId()
            + ":" + key.chatId()
            + ":" + key.userId()
            + ":" + threadId
            + ":" + key.destiny()
            + business
            + ":" + part;
    }

    /** Signals that the data changed between read and compare-and-set; triggers a retry. */
    private static final class ConcurrentUpdateException extends RuntimeException {
        ConcurrentUpdateException() {
            super(null, null, false, false);
        }
    }
}
