package io.jiogram.fsm.storage;

import io.jiogram.fsm.StorageKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MemoryStateStorageTest {

    private MemoryStateStorage storage;
    private StorageKey key1;
    private StorageKey key2;

    @BeforeEach
    void setUp() {
        storage = new MemoryStateStorage();
        key1 = new StorageKey(100L, 200L, 300L);
        key2 = new StorageKey(100L, 200L, 400L);
    }

    @Test
    void setState_andGetState_returnsSavedState() {
        StepVerifier.create(
            storage.setState(key1, "OrderState.WAITING_FOR_NAME")
                .then(storage.getState(key1))
        ).expectNext("OrderState.WAITING_FOR_NAME")
         .verifyComplete();
    }

    @Test
    void getState_whenNoStateSet_returnsEmpty() {
        StepVerifier.create(storage.getState(key1))
            .verifyComplete();
    }

    @Test
    void setState_withNull_clearsState() {
        StepVerifier.create(
            storage.setState(key1, "SomeState")
                .then(storage.setState(key1, null))
                .then(storage.getState(key1))
        ).verifyComplete();
    }

    @Test
    void setData_andGetData_returnsSavedData() {
        Map<String, Object> data = Map.of("name", "Alice", "age", 30);

        StepVerifier.create(
            storage.setData(key1, data)
                .then(storage.getData(key1))
        ).assertNext(result -> {
            assertEquals("Alice", result.get("name"));
            assertEquals(30, result.get("age"));
        }).verifyComplete();
    }

    @Test
    void getData_whenNoDataSet_returnsEmptyMap() {
        StepVerifier.create(storage.getData(key1))
            .assertNext(result -> assertTrue(result.isEmpty()))
            .verifyComplete();
    }

    @Test
    void setState_preservesExistingData() {
        Map<String, Object> data = Map.of("key", "value");

        StepVerifier.create(
            storage.setData(key1, data)
                .then(storage.setState(key1, "NewState"))
                .then(storage.getData(key1))
        ).assertNext(result -> assertEquals("value", result.get("key")))
         .verifyComplete();
    }

    @Test
    void setData_preservesExistingState() {
        StepVerifier.create(
            storage.setState(key1, "MyState")
                .then(storage.setData(key1, Map.of("foo", "bar")))
                .then(storage.getState(key1))
        ).expectNext("MyState")
         .verifyComplete();
    }

    @Test
    void differentKeys_areIsolated() {
        StepVerifier.create(
            storage.setState(key1, "State1")
                .then(storage.setState(key2, "State2"))
                .then(storage.getState(key1))
        ).expectNext("State1")
         .verifyComplete();

        StepVerifier.create(storage.getState(key2))
            .expectNext("State2")
            .verifyComplete();
    }

    @Test
    void differentKeys_haveIsolatedData() {
        StepVerifier.create(
            storage.setData(key1, Map.of("a", 1))
                .then(storage.setData(key2, Map.of("b", 2)))
                .then(storage.getData(key1))
        ).assertNext(result -> {
            assertEquals(1, result.get("a"));
            assertNull(result.get("b"));
        }).verifyComplete();
    }

    @Test
    void close_clearsAllData() {
        StepVerifier.create(
            storage.setState(key1, "SomeState")
                .then(storage.setData(key1, Map.of("x", "y")))
                .then(storage.close())
                .then(storage.getState(key1))
        ).verifyComplete();

        StepVerifier.create(storage.getData(key1))
            .assertNext(result -> assertTrue(result.isEmpty()))
            .verifyComplete();
    }
}
