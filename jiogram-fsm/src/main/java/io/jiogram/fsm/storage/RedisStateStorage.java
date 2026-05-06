package io.jiogram.fsm.storage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.fsm.StorageKey;
import org.jspecify.annotations.Nullable;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

/**
 * Redis-backed implementation of {@link StateStorage} using Spring's
 * {@link ReactiveStringRedisTemplate}. State and data are stored as separate
 * Redis keys with JSON serialization for the data map.
 *
 * <p>Key format: {@code jiogram:fsm:{botId}:{chatId}:{userId}:{threadId}:{destiny}:{part}}
 * where {@code part} is either "state" or "data".
 */
public class RedisStateStorage implements StateStorage {

    private static final TypeReference<Map<String, Object>> MAP_TYPE = new TypeReference<>() {};

    private final ReactiveStringRedisTemplate redis;
    private final ObjectMapper objectMapper;

    public RedisStateStorage(ReactiveStringRedisTemplate redis) {
        ReactiveStringRedisTemplate checkedRedis = Objects.requireNonNull(redis, "redis must not be null");
        this(checkedRedis, new ObjectMapper());
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
        try {
            String json = objectMapper.writeValueAsString(data);
            return redis.opsForValue().set(redisKey, json).then();
        } catch (JsonProcessingException e) {
            return Mono.error(e);
        }
    }

    @Override
    public Mono<Map<String, Object>> getData(StorageKey key) {
        String redisKey = buildKey(key, "data");
        return redis.opsForValue().get(redisKey)
            .flatMap(json -> {
                try {
                    Map<String, Object> data = objectMapper.readValue(json, MAP_TYPE);
                    return Mono.just(data);
                } catch (JsonProcessingException e) {
                    return Mono.error(e);
                }
            })
            .defaultIfEmpty(Map.of());
    }

    @Override
    public Mono<Void> close() {
        return Mono.empty();
    }

    /**
     * Builds a Redis key from the storage key components.
     *
     * @param key  the storage key
     * @param part "state" or "data"
     * @return the Redis key string
     */
    private String buildKey(StorageKey key, String part) {
        String threadId = key.threadId() != null ? key.threadId().toString() : "-";
        return "jiogram:fsm:" + key.botId()
            + ":" + key.chatId()
            + ":" + key.userId()
            + ":" + threadId
            + ":" + key.destiny()
            + ":" + part;
    }
}
