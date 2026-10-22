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
 * <p>Key format: {@code {prefix}:{botId}:{chatId}:{userId}:{threadId}:{destiny}:{part}}
 * where {@code prefix} defaults to {@code jiogram:fsm} and {@code part} is either "state" or
 * "data". Updates that came through a business connection get an extra
 * {@code bc=<businessConnectionId>} segment before {@code part}.
 *
 * <p>Like aiogram's {@code state_ttl}/{@code data_ttl}, the state and data keys can expire: every
 * write sets the key's time to live again, so a conversation expires that long after it last
 * changed. Without a TTL (the default) keys live until cleared.
 *
 * <p>{@link #updateData} is atomic: the merge happens in Java and is written back with a
 * compare-and-set script, retried if another writer changed the data in between. (Merging
 * inside Lua would go through cjson, which loses precision on large numbers such as chat ids.)
 * {@link #clear} deletes both keys with one {@code DEL}; on Redis Cluster the two keys may live
 * in different slots, in which case the client deletes them separately.
 */
public class RedisStateStorage implements StateStorage {

    private static final TypeReference<Map<String, Object>> MAP_TYPE = new TypeReference<>() {};

    /**
     * Sets KEYS[1] to ARGV[2] only if it still holds ARGV[1] ("" meaning absent), expiring it after
     * ARGV[3] milliseconds unless that is "0".
     */
    private static final RedisScript<Long> COMPARE_AND_SET = RedisScript.of(
        "local current = redis.call('GET', KEYS[1])\n"
            + "if (current or '') ~= ARGV[1] then\n"
            + "  return 0\n"
            + "end\n"
            + "if ARGV[3] == '0' then\n"
            + "  redis.call('SET', KEYS[1], ARGV[2])\n"
            + "else\n"
            + "  redis.call('SET', KEYS[1], ARGV[2], 'PX', ARGV[3])\n"
            + "end\n"
            + "return 1\n", Long.class);

    private static final int MAX_UPDATE_ATTEMPTS = 32;

    private final ReactiveStringRedisTemplate redis;
    private final ObjectMapper objectMapper;
    private final Settings settings;

    /**
     * Key layout and expiry. An immutable value with record-style accessors, equality and
     * {@link #toString()} ({@code Settings[keyPrefix=..., stateTtl=..., dataTtl=...]}).
     */
    public static final class Settings {

        public static final String DEFAULT_KEY_PREFIX = "jiogram:fsm";

        public static final Settings DEFAULT = new Settings(DEFAULT_KEY_PREFIX, null, null);

        private final String keyPrefix;
        private final @Nullable Duration stateTtl;
        private final @Nullable Duration dataTtl;

        /**
         * Creates the settings.
         *
         * @param keyPrefix first segment(s) of every key
         * @param stateTtl  how long a state key lives after its last write; {@code null} for no expiry
         * @param dataTtl   how long a data key lives after its last write; {@code null} for no expiry
         * @throws NullPointerException     if {@code keyPrefix} is null
         * @throws IllegalArgumentException if {@code keyPrefix} is blank or a TTL is under 1ms
         */
        public Settings(String keyPrefix, @Nullable Duration stateTtl, @Nullable Duration dataTtl) {
            Objects.requireNonNull(keyPrefix, "keyPrefix must not be null");
            if (keyPrefix.isBlank()) {
                throw new IllegalArgumentException("keyPrefix must not be blank");
            }
            requirePositive(stateTtl, "stateTtl");
            requirePositive(dataTtl, "dataTtl");
            this.keyPrefix = keyPrefix;
            this.stateTtl = stateTtl;
            this.dataTtl = dataTtl;
        }

        private static void requirePositive(@Nullable Duration ttl, String name) {
            // Redis expiries have millisecond resolution.
            if (ttl != null && ttl.toMillis() <= 0) {
                throw new IllegalArgumentException(name + " must be at least 1ms, got " + ttl);
            }
        }

        /** @return first segment(s) of every key */
        public String keyPrefix() {
            return keyPrefix;
        }

        /** @return how long a state key lives after its last write; {@code null} for no expiry */
        public @Nullable Duration stateTtl() {
            return stateTtl;
        }

        /** @return how long a data key lives after its last write; {@code null} for no expiry */
        public @Nullable Duration dataTtl() {
            return dataTtl;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Settings)) {
                return false;
            }
            Settings that = (Settings) o;
            return keyPrefix.equals(that.keyPrefix)
                && Objects.equals(stateTtl, that.stateTtl)
                && Objects.equals(dataTtl, that.dataTtl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(keyPrefix, stateTtl, dataTtl);
        }

        @Override
        public String toString() {
            return "Settings[keyPrefix=" + keyPrefix + ", stateTtl=" + stateTtl + ", dataTtl=" + dataTtl + "]";
        }
    }

    public RedisStateStorage(ReactiveStringRedisTemplate redis) {
        this(redis, Settings.DEFAULT);
    }

    public RedisStateStorage(ReactiveStringRedisTemplate redis, Settings settings) {
        // Registers modules found on the classpath (e.g. java.time support).
        this(redis, new ObjectMapper().findAndRegisterModules(), settings);
    }

    public RedisStateStorage(ReactiveStringRedisTemplate redis, ObjectMapper objectMapper) {
        this(redis, objectMapper, Settings.DEFAULT);
    }

    public RedisStateStorage(ReactiveStringRedisTemplate redis, ObjectMapper objectMapper, Settings settings) {
        this.redis = Objects.requireNonNull(redis, "redis must not be null");
        this.objectMapper = Objects.requireNonNull(objectMapper, "objectMapper must not be null");
        this.settings = Objects.requireNonNull(settings, "settings must not be null");
    }

    @Override
    public Mono<Void> setState(StorageKey key, @Nullable String state) {
        String redisKey = buildKey(key, "state");
        if (state == null) {
            return redis.delete(redisKey).then();
        }
        return write(redisKey, state, settings.stateTtl());
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
        return toJson(data).flatMap(json -> write(redisKey, json, settings.dataTtl()));
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
                    .flatMap(mergedJson -> redis.execute(COMPARE_AND_SET, List.of(redisKey),
                            List.of(currentJson, mergedJson, String.valueOf(ttlMillis(settings.dataTtl()))))
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

    private Mono<Void> write(String redisKey, String value, @Nullable Duration ttl) {
        return (ttl == null
                ? redis.opsForValue().set(redisKey, value)
                : redis.opsForValue().set(redisKey, value, ttl))
            .then();
    }

    private static long ttlMillis(@Nullable Duration ttl) {
        return ttl == null ? 0 : ttl.toMillis();
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
        return settings.keyPrefix() + ":" + key.botId()
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
