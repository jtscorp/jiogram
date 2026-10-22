package io.jiogram.fsm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.fsm.storage.MemoryStateStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        WAITING_FOR_NAME
    }

    @BeforeEach
    void setUp() {
        storage = new MemoryStateStorage();
        key = new StorageKey(1L, 100L, 200L);
        fsmContext = new FSMContext(storage, key);
    }

    @Test
    void setState_withEnumImplementingBotState_storesDeclaringClassAndConstantName() {
        StepVerifier.create(
            fsmContext.setState(TestState.WAITING_FOR_NAME)
                .then(fsmContext.getState())
        ).expectNext("FSMContextTest.TestState.WAITING_FOR_NAME")
         .verifyComplete();
    }

    @Test
    void setState_withPlainEnum_storesDeclaringClassAndConstantName() {
        StepVerifier.create(
            fsmContext.setState(PlainState.WAITING_FOR_NAME)
                .then(fsmContext.getState())
        ).expectNext("FSMContextTest.PlainState.WAITING_FOR_NAME")
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

    /** A value class standing in for a record; Jackson 2.13 needs the creator spelled out. */
    static final class Address {
        private final String city;
        private final long zip;

        @JsonCreator
        Address(@JsonProperty("city") String city, @JsonProperty("zip") long zip) {
            this.city = city;
            this.zip = zip;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Address)) {
                return false;
            }
            Address that = (Address) o;
            return zip == that.zip && Objects.equals(city, that.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, zip);
        }

        @Override
        public String toString() {
            return "Address[city=" + city + ", zip=" + zip + "]";
        }
    }

    @Test
    void getValue_convertsJsonShapedValues() {
        // What a serializing storage hands back: an Integer for a long, a Map for an object.
        StepVerifier.create(
            fsmContext.setData(Map.of("messageId", 42, "address", Map.of("city", "Tashkent", "zip", 100000)))
                .then(fsmContext.getValue("messageId", Long.class)
                    .zipWith(fsmContext.getValue("address", Address.class)))
        ).assertNext(values -> {
            assertEquals(42L, values.getT1());
            assertEquals(new Address("Tashkent", 100000), values.getT2());
        }).verifyComplete();
    }

    @Test
    void updateData_acceptsNullValue() {
        StepVerifier.create(
            fsmContext.updateData("optional", null).then(fsmContext.getData())
        ).assertNext(data -> {
            assertTrue(data.containsKey("optional"));
            assertNull(data.get("optional"));
        }).verifyComplete();
    }

    @Test
    void updateData_concurrentUpdatesOfOneKey_loseNoFields() {
        List<Mono<Void>> updates = IntStream.range(0, 200)
            .mapToObj(i -> fsmContext.updateData("field" + i, i).subscribeOn(Schedulers.parallel()))
            .collect(Collectors.toList());

        StepVerifier.create(Mono.when(updates).then(fsmContext.getData()))
            .assertNext(data -> assertEquals(200, data.size()))
            .verifyComplete();
    }

    static class OrderFlow {
        enum State { CONFIRM }
    }

    static class PaymentFlow {
        enum State { CONFIRM }
    }

    @Test
    void nestedEnumsWithTheSameName_getDistinctStateNames() {
        StepVerifier.create(
            fsmContext.setState(OrderFlow.State.CONFIRM).then(fsmContext.getState())
                .zipWith(new FSMContext(storage, new StorageKey(1L, 2L, 3L))
                    .setState(PaymentFlow.State.CONFIRM)
                    .then(storage.getState(new StorageKey(1L, 2L, 3L))))
        ).assertNext(names -> {
            assertEquals("FSMContextTest.OrderFlow.State.CONFIRM", names.getT1());
            assertEquals("FSMContextTest.PaymentFlow.State.CONFIRM", names.getT2());
        }).verifyComplete();
    }

    enum CustomNamedState implements BotState {
        STEP;

        @Override
        public String fullName() {
            return "wizard:" + name();
        }
    }

    @Test
    void setState_honoursOverriddenFullName() {
        StepVerifier.create(fsmContext.setState(CustomNamedState.STEP).then(fsmContext.getState()))
            .expectNext("wizard:STEP")
            .verifyComplete();
    }
}
