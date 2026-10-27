package io.jiogram.middleware;

import io.jiogram.dispatcher.UpdateContext;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMiddlewareTest {

    private static final UpdateContext DUMMY_CONTEXT = new UpdateContext(null, null);

    @Test
    void swallowsExceptionFromChain() {
        var errorMiddleware = new ErrorMiddleware();

        // Create a chain that throws an error
        var chain = new MiddlewareChain(
                List.of(),
                Mono.error(new RuntimeException("Something went wrong"))
        );

        // The error should be caught and swallowed
        StepVerifier.create(errorMiddleware.process("event", DUMMY_CONTEXT, chain))
                .verifyComplete();
    }

    @Test
    void swallowsCheckedExceptionFromChain() {
        var errorMiddleware = new ErrorMiddleware();

        var chain = new MiddlewareChain(
                List.of(),
                Mono.error(new Exception("Checked exception"))
        );

        StepVerifier.create(errorMiddleware.process("event", DUMMY_CONTEXT, chain))
                .verifyComplete();
    }

    @Test
    void passesSuccessfulChainThrough() {
        var errorMiddleware = new ErrorMiddleware();
        var processed = new ArrayList<String>();

        Middleware recorder = (event, context, ch) -> {
            processed.add("recorder");
            return ch.next(event, context);
        };

        var chain = new MiddlewareChain(
                List.of(recorder),
                Mono.empty()
        );

        StepVerifier.create(errorMiddleware.process("event", DUMMY_CONTEXT, chain))
                .verifyComplete();

        assertEquals(List.of("recorder"), processed);
    }

    @Test
    void swallowsErrorFromDownstreamMiddleware() {
        var errorMiddleware = new ErrorMiddleware();

        Middleware failingMiddleware = (event, context, ch) ->
                Mono.error(new IllegalStateException("Downstream failure"));

        var chain = new MiddlewareChain(
                List.of(failingMiddleware),
                Mono.empty()
        );

        StepVerifier.create(errorMiddleware.process("event", DUMMY_CONTEXT, chain))
                .verifyComplete();
    }

    @Test
    void swallowsExceptionThrownByDownstreamMiddleware() {
        var errorMiddleware = new ErrorMiddleware();

        // Throws instead of returning Mono.error.
        Middleware throwingMiddleware = (event, context, ch) -> {
            throw new IllegalStateException("Thrown, not signalled");
        };

        var chain = new MiddlewareChain(
                List.of(throwingMiddleware),
                Mono.empty()
        );

        StepVerifier.create(errorMiddleware.process("event", DUMMY_CONTEXT, chain))
                .verifyComplete();
    }

    @Test
    void doesNotPropagateError() {
        var errorMiddleware = new ErrorMiddleware();

        var chain = new MiddlewareChain(
                List.of(),
                Mono.error(new RuntimeException("Should not propagate"))
        );

        // Verify the error is fully contained and does not propagate
        StepVerifier.create(errorMiddleware.process("event", DUMMY_CONTEXT, chain))
                .expectComplete()
                .verify();
    }

    @Test
    void multipleErrorsAreEachSwallowed() {
        var errorMiddleware = new ErrorMiddleware();

        // First call with error
        var chain1 = new MiddlewareChain(
                List.of(),
                Mono.error(new RuntimeException("Error 1"))
        );

        StepVerifier.create(errorMiddleware.process("event1", DUMMY_CONTEXT, chain1))
                .verifyComplete();

        // Second call with error
        var chain2 = new MiddlewareChain(
                List.of(),
                Mono.error(new RuntimeException("Error 2"))
        );

        StepVerifier.create(errorMiddleware.process("event2", DUMMY_CONTEXT, chain2))
                .verifyComplete();
    }
}
