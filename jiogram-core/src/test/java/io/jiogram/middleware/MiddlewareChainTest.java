package io.jiogram.middleware;

import io.jiogram.dispatcher.UpdateContext;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MiddlewareChainTest {

    private static final UpdateContext DUMMY_CONTEXT = new UpdateContext(null, null);

    @Test
    void emptyChainCallsFinalHandler() {
        var executed = new ArrayList<String>();

        var chain = new MiddlewareChain(
                List.of(),
                Mono.fromRunnable(() -> executed.add("final"))
        );

        StepVerifier.create(chain.next("event", DUMMY_CONTEXT))
                .verifyComplete();

        assertEquals(List.of("final"), executed);
    }

    @Test
    void singleMiddlewareCallsFinalHandler() {
        var executed = new ArrayList<String>();

        Middleware m1 = (event, ctx, chain) -> {
            executed.add("m1-before");
            return chain.next(event, ctx)
                    .doOnTerminate(() -> executed.add("m1-after"));
        };

        var chain = new MiddlewareChain(
                List.of(m1),
                Mono.fromRunnable(() -> executed.add("final"))
        );

        StepVerifier.create(chain.next("event", DUMMY_CONTEXT))
                .verifyComplete();

        assertEquals(List.of("m1-before", "final", "m1-after"), executed);
    }

    @Test
    void multipleMiddlewaresExecuteInOrder() {
        var executed = new ArrayList<String>();

        Middleware m1 = (event, ctx, chain) -> {
            executed.add("m1-before");
            return chain.next(event, ctx)
                    .doOnTerminate(() -> executed.add("m1-after"));
        };

        Middleware m2 = (event, ctx, chain) -> {
            executed.add("m2-before");
            return chain.next(event, ctx)
                    .doOnTerminate(() -> executed.add("m2-after"));
        };

        Middleware m3 = (event, ctx, chain) -> {
            executed.add("m3-before");
            return chain.next(event, ctx)
                    .doOnTerminate(() -> executed.add("m3-after"));
        };

        var chain = new MiddlewareChain(
                List.of(m1, m2, m3),
                Mono.fromRunnable(() -> executed.add("final"))
        );

        StepVerifier.create(chain.next("event", DUMMY_CONTEXT))
                .verifyComplete();

        assertEquals(List.of("m1-before", "m2-before", "m3-before", "final", "m3-after", "m2-after", "m1-after"), executed);
    }

    @Test
    void middlewareCanShortCircuit() {
        var executed = new ArrayList<String>();

        Middleware m1 = (event, ctx, chain) -> {
            executed.add("m1");
            // Does not call chain.next() — short-circuits
            return Mono.empty();
        };

        Middleware m2 = (event, ctx, chain) -> {
            executed.add("m2");
            return chain.next(event, ctx);
        };

        var chain = new MiddlewareChain(
                List.of(m1, m2),
                Mono.fromRunnable(() -> executed.add("final"))
        );

        StepVerifier.create(chain.next("event", DUMMY_CONTEXT))
                .verifyComplete();

        assertEquals(List.of("m1"), executed);
    }

    @Test
    void middlewareCanModifyContext() {
        var context = new UpdateContext(null, null);

        Middleware m1 = (event, ctx, chain) -> {
            ctx.put("modified", true);
            return chain.next(event, ctx);
        };

        var chain = new MiddlewareChain(
                List.of(m1),
                Mono.fromRunnable(() -> {
                    assertTrue((Boolean) context.get("modified"));
                })
        );

        StepVerifier.create(chain.next("event", context))
                .verifyComplete();

        assertTrue((Boolean) context.get("modified"));
    }
}
