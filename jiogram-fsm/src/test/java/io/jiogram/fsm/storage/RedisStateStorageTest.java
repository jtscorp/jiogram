package io.jiogram.fsm.storage;

import io.jiogram.fsm.FSMContext;
import io.jiogram.fsm.StorageKey;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers(disabledWithoutDocker = true)
class RedisStateStorageTest {

    @Container
    private static final GenericContainer<?> REDIS = new GenericContainer<>("redis:7-alpine").withExposedPorts(6379);

    private static LettuceConnectionFactory connectionFactory;
    private static ReactiveStringRedisTemplate redis;

    private final RedisStateStorage storage = new RedisStateStorage(redis);
    private final StorageKey key = new StorageKey(1L, -1001234567890L, 7000000000L);

    @BeforeAll
    static void connect() {
        connectionFactory = new LettuceConnectionFactory(REDIS.getHost(), REDIS.getMappedPort(6379));
        connectionFactory.afterPropertiesSet();
        redis = new ReactiveStringRedisTemplate(connectionFactory);
    }

    @AfterAll
    static void disconnect() {
        connectionFactory.destroy();
    }

    @BeforeEach
    void flush() {
        redis.execute(connection -> connection.serverCommands().flushAll()).blockLast();
    }

    @Test
    void concurrentUpdatesOfOneKey_loseNoFields() {
        List<Mono<Void>> updates = IntStream.range(0, 50)
            .mapToObj(i -> storage.updateData(key, Map.of("field" + i, i)).subscribeOn(Schedulers.parallel()))
            .toList();

        StepVerifier.create(Mono.when(updates).then(storage.getData(key)))
            .assertNext(data -> assertEquals(50, data.size()))
            .verifyComplete();
    }

    @Test
    void largeNumbersAndTypesSurviveTheRoundTrip() {
        FSMContext fsm = new FSMContext(storage, key);

        StepVerifier.create(fsm.updateData("chatId", -1001234567890123L)
                .then(fsm.updateData("small", 5L))
                .then(fsm.getValue("chatId", Long.class).zipWith(fsm.getValue("small", Long.class))))
            .assertNext(values -> {
                assertEquals(-1001234567890123L, values.getT1());
                assertEquals(5L, values.getT2());
            })
            .verifyComplete();
    }

    @Test
    void clearRemovesStateAndDataKeys() {
        StepVerifier.create(storage.setState(key, "Form.NAME")
                .then(storage.updateData(key, Map.of("a", 1)))
                .then(storage.clear(key))
                .then(redis.hasKey(storage.buildKey(key, "state")).zipWith(redis.hasKey(storage.buildKey(key, "data")))))
            .assertNext(exists -> {
                assertFalse(exists.getT1());
                assertFalse(exists.getT2());
            })
            .verifyComplete();
    }

    @Test
    void withoutTtl_keysDoNotExpire() {
        StepVerifier.create(storage.setState(key, "Form.NAME")
                .then(storage.updateData(key, Map.of("a", 1)))
                .then(pttl(storage.buildKey(key, "state")).zipWith(pttl(storage.buildKey(key, "data")))))
            .assertNext(expiries -> {
                assertEquals(NO_EXPIRY, expiries.getT1());
                assertEquals(NO_EXPIRY, expiries.getT2());
            })
            .verifyComplete();
    }

    @Test
    void ttl_isSetByEveryWrite_andTheKeysExpire() {
        var expiring = new RedisStateStorage(redis,
            new RedisStateStorage.Settings("jiogram:fsm", Duration.ofMinutes(5), Duration.ofSeconds(2)));

        StepVerifier.create(expiring.setState(key, "Form.NAME")
                .then(expiring.setData(key, Map.of("a", 1)))
                .then(expiring.updateData(key, Map.of("b", 2)))
                .then(redis.getExpire(expiring.buildKey(key, "state")).zipWith(redis.getExpire(expiring.buildKey(key, "data")))))
            .assertNext(expiries -> {
                assertTrue(expiries.getT1().compareTo(Duration.ofMinutes(4)) > 0, expiries.getT1().toString());
                assertTrue(expiries.getT1().compareTo(Duration.ofMinutes(5)) <= 0, expiries.getT1().toString());
                assertTrue(expiries.getT2().compareTo(Duration.ZERO) > 0, expiries.getT2().toString());
                assertTrue(expiries.getT2().compareTo(Duration.ofSeconds(2)) <= 0, expiries.getT2().toString());
            })
            .verifyComplete();

        // updateData (the compare-and-set script) kept the TTL, so the data is gone after it.
        await().atMost(Duration.ofSeconds(5))
            .until(() -> Boolean.FALSE.equals(redis.hasKey(expiring.buildKey(key, "data")).block()));
        StepVerifier.create(expiring.getData(key))
            .assertNext(data -> assertTrue(data.isEmpty()))
            .verifyComplete();
        StepVerifier.create(expiring.getState(key))
            .assertNext(state -> assertEquals("Form.NAME", state))
            .verifyComplete();
    }

    @Test
    void updateData_withoutTtl_removesAnExpiryLeftByAnEarlierTtlSetting() {
        var expiring = new RedisStateStorage(redis,
            new RedisStateStorage.Settings("jiogram:fsm", null, Duration.ofMinutes(5)));

        StepVerifier.create(expiring.updateData(key, Map.of("a", 1))
                .then(storage.updateData(key, Map.of("b", 2)))
                .then(pttl(storage.buildKey(key, "data"))))
            .assertNext(expiry -> assertEquals(NO_EXPIRY, expiry))
            .verifyComplete();
    }

    @Test
    void customKeyPrefix_isUsedForEveryKey() {
        var prefixed = new RedisStateStorage(redis, new RedisStateStorage.Settings("shop-bot:fsm", null, null));

        assertEquals("shop-bot:fsm:1:-1001234567890:7000000000:-:default:state", prefixed.buildKey(key, "state"));
        StepVerifier.create(prefixed.setState(key, "Form.NAME")
                .then(prefixed.updateData(key, Map.of("a", 1)))
                .thenMany(redis.keys("*").sort()))
            .expectNext("shop-bot:fsm:1:-1001234567890:7000000000:-:default:data")
            .expectNext("shop-bot:fsm:1:-1001234567890:7000000000:-:default:state")
            .verifyComplete();
    }

    /** Redis PTTL: -1 for a key without expiry (-2 would mean the key does not exist). */
    private static final long NO_EXPIRY = -1;

    private static Mono<Long> pttl(String redisKey) {
        return redis.execute(connection -> connection.keyCommands()
                .pTtl(ByteBuffer.wrap(redisKey.getBytes(StandardCharsets.UTF_8))))
            .next();
    }

    @Test
    void invalidSettings_areRejected() {
        assertThrows(IllegalArgumentException.class, () -> new RedisStateStorage.Settings(" ", null, null));
        assertThrows(IllegalArgumentException.class,
            () -> new RedisStateStorage.Settings("jiogram:fsm", Duration.ZERO, null));
        assertThrows(IllegalArgumentException.class,
            () -> new RedisStateStorage.Settings("jiogram:fsm", null, Duration.ofNanos(10)));
    }

    @Test
    void businessConnectionGetsItsOwnKey_otherKeysKeepTheirFormat() {
        StorageKey plain = new StorageKey(1L, 2L, 3L);
        StorageKey business = new StorageKey(1L, 2L, 3L, null, "default", "bc123");

        assertEquals("jiogram:fsm:1:2:3:-:default:state", storage.buildKey(plain, "state"));
        assertEquals("jiogram:fsm:1:2:3:-:default:bc=bc123:state", storage.buildKey(business, "state"));

        StepVerifier.create(storage.setState(business, "Form.NAME").then(storage.getState(plain)))
            .verifyComplete();
        StepVerifier.create(storage.getState(business))
            .assertNext(state -> assertTrue(state.endsWith("NAME")))
            .verifyComplete();
    }
}
