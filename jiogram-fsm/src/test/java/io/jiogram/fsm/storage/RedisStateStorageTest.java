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

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
