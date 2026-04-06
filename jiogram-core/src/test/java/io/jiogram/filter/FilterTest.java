package io.jiogram.filter;

import io.jiogram.dispatcher.UpdateContext;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    private static final UpdateContext DUMMY_CONTEXT = new UpdateContext(null, null);

    // -- and() --

    @Test
    void andPassesWhenBothPass() {
        Filter<String> f1 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("a", 1)));
        Filter<String> f2 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("b", 2)));

        var combined = f1.and(f2);

        StepVerifier.create(combined.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals(1, passed.data().get("a"));
                    assertEquals(2, passed.data().get("b"));
                })
                .verifyComplete();
    }

    @Test
    void andMergesDataWithSecondOverwriting() {
        Filter<String> f1 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("key", "first")));
        Filter<String> f2 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("key", "second")));

        var combined = f1.and(f2);

        StepVerifier.create(combined.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals("second", passed.data().get("key"));
                })
                .verifyComplete();
    }

    @Test
    void andFailsWhenFirstFails() {
        Filter<String> f1 = (event, ctx) -> Mono.just(FilterResult.failed());
        Filter<String> f2 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("b", 2)));

        var combined = f1.and(f2);

        StepVerifier.create(combined.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void andFailsWhenSecondFails() {
        Filter<String> f1 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("a", 1)));
        Filter<String> f2 = (event, ctx) -> Mono.just(FilterResult.failed());

        var combined = f1.and(f2);

        StepVerifier.create(combined.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void andFailsWhenBothFail() {
        Filter<String> f1 = (event, ctx) -> Mono.just(FilterResult.failed());
        Filter<String> f2 = (event, ctx) -> Mono.just(FilterResult.failed());

        var combined = f1.and(f2);

        StepVerifier.create(combined.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    // -- or() --

    @Test
    void orPassesWhenFirstPasses() {
        Filter<String> f1 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("a", 1)));
        Filter<String> f2 = (event, ctx) -> Mono.just(FilterResult.failed());

        var combined = f1.or(f2);

        StepVerifier.create(combined.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals(1, passed.data().get("a"));
                })
                .verifyComplete();
    }

    @Test
    void orPassesWhenSecondPasses() {
        Filter<String> f1 = (event, ctx) -> Mono.just(FilterResult.failed());
        Filter<String> f2 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("b", 2)));

        var combined = f1.or(f2);

        StepVerifier.create(combined.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals(2, passed.data().get("b"));
                })
                .verifyComplete();
    }

    @Test
    void orFailsWhenBothFail() {
        Filter<String> f1 = (event, ctx) -> Mono.just(FilterResult.failed());
        Filter<String> f2 = (event, ctx) -> Mono.just(FilterResult.failed());

        var combined = f1.or(f2);

        StepVerifier.create(combined.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void orFirstPassWins() {
        Filter<String> f1 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("source", "first")));
        Filter<String> f2 = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("source", "second")));

        var combined = f1.or(f2);

        StepVerifier.create(combined.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertEquals("first", passed.data().get("source"));
                })
                .verifyComplete();
    }

    // -- negate() --

    @Test
    void negatePassedBecomesFailed() {
        Filter<String> f = (event, ctx) -> Mono.just(FilterResult.passed(Map.of("key", "val")));

        var negated = f.negate();

        StepVerifier.create(negated.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Failed.class, result))
                .verifyComplete();
    }

    @Test
    void negateFailedBecomesPassed() {
        Filter<String> f = (event, ctx) -> Mono.just(FilterResult.failed());

        var negated = f.negate();

        StepVerifier.create(negated.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> {
                    assertInstanceOf(FilterResult.Passed.class, result);
                    var passed = (FilterResult.Passed) result;
                    assertTrue(passed.data().isEmpty());
                })
                .verifyComplete();
    }

    @Test
    void doubleNegateRestoresOriginal() {
        Filter<String> f = (event, ctx) -> Mono.just(FilterResult.passed());

        var doubleNegated = f.negate().negate();

        StepVerifier.create(doubleNegated.apply("test", DUMMY_CONTEXT))
                .assertNext(result -> assertInstanceOf(FilterResult.Passed.class, result))
                .verifyComplete();
    }
}
