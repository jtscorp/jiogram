package io.jiogram.fsm;

import io.jiogram.fsm.storage.MemoryStateStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FSMContextTest {

    private MemoryStateStorage storage;
    private StorageKey key;
    private FSMContext fsmContext;

    enum TestState implements BotState {
        WAITING_FOR_NAME,
        WAITING_FOR_ADDRESS,
        CONFIRM
    }

    enum PlainState {
        WAITING_FOR_NAME,
        WAITING_FOR_ADDRESS,
        CONFIRM
    }

    @BeforeEach
    void setUp() {
        storage = new MemoryStateStorage();
        key = new StorageKey(1L, 100L, 200L);
        fsmContext = new FSMContext(storage, key);
    }

    @Test
    void setState_withPlainEnum_storesFullName() {
        StepVerifier.create(
            fsmContext.setState(PlainState.WAITING_FOR_NAME)
                .then(fsmContext.getState())
        ).expectNext("PlainState.WAITING_FOR_NAME")
         .verifyComplete();
    }

    @Test
    void setBotState_withBotState_storesFullName() {
        StepVerifier.create(
            fsmContext.setBotState(TestState.WAITING_FOR_NAME)
                .then(fsmContext.getState())
        ).expectNext("TestState.WAITING_FOR_NAME")
         .verifyComplete();
    }

    @Test
    void setState_withString_storesDirectly() {
        StepVerifier.create(
            fsmContext.setState("custom_state")
                .then(fsmContext.getState())
        ).expectNext("custom_state")
         .verifyComplete();
    }

    @Test
    void getState_whenEmpty_returnsEmpty() {
        StepVerifier.create(fsmContext.getState())
            .verifyComplete();
    }

    @Test
    void setData_andGetData_roundTrips() {
        Map<String, Object> data = Map.of("name", "Bob", "score", 42);

        StepVerifier.create(
            fsmContext.setData(data)
                .then(fsmContext.getData())
        ).assertNext(result -> {
            assertEquals("Bob", result.get("name"));
            assertEquals(42, result.get("score"));
        }).verifyComplete();
    }

    @Test
    void updateData_mergesIntoExisting() {
        StepVerifier.create(
            fsmContext.setData(Map.of("name", "Alice"))
                .then(fsmContext.updateData("age", 25))
                .then(fsmContext.getData())
        ).assertNext(result -> {
            assertEquals("Alice", result.get("name"));
            assertEquals(25, result.get("age"));
        }).verifyComplete();
    }

    @Test
    void updateData_overwritesExistingField() {
        StepVerifier.create(
            fsmContext.setData(Map.of("name", "Alice"))
                .then(fsmContext.updateData("name", "Bob"))
                .then(fsmContext.getData())
        ).assertNext(result -> assertEquals("Bob", result.get("name")))
         .verifyComplete();
    }

    @Test
    void getValue_returnsTypedValue() {
        StepVerifier.create(
            fsmContext.setData(Map.of("name", "Charlie"))
                .then(fsmContext.getValue("name", String.class))
        ).expectNext("Charlie")
         .verifyComplete();
    }

    @Test
    void getValue_whenFieldMissing_returnsEmpty() {
        StepVerifier.create(
            fsmContext.setData(Map.of("name", "Alice"))
                .then(fsmContext.getValue("missing", String.class))
        ).verifyComplete();
    }

    @Test
    void clear_removesBothStateAndData() {
        StepVerifier.create(
            fsmContext.setState(TestState.CONFIRM)
                .then(fsmContext.setData(Map.of("key", "val")))
                .then(fsmContext.clear())
                .then(fsmContext.getState())
        ).verifyComplete();

        StepVerifier.create(fsmContext.getData())
            .assertNext(result -> assertTrue(result.isEmpty()))
            .verifyComplete();
    }

    @Test
    void key_returnsStorageKey() {
        assertEquals(key, fsmContext.key());
    }
}
