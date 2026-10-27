package io.jiogram.middleware;

import io.jiogram.dispatcher.UpdateContext;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Executes a chain of middlewares, followed by a final handler.
 * Each call to {@link #next(Object, UpdateContext)} advances to the next middleware,
 * or invokes the final handler if all middlewares have been called.
 * <p>
 * The chain is immutable: every middleware receives a chain positioned after itself, so
 * calling {@code next} again (e.g. from a retry, or lazily inside {@code Mono.defer}) runs
 * the rest of the pipeline again instead of skipping middlewares.
 */
public class MiddlewareChain {

    private final List<Middleware> middlewares;
    private final Mono<Void> finalHandler;
    private final int position;

    /**
     * Creates a new middleware chain.
     *
     * @param middlewares  the ordered list of middlewares to execute
     * @param finalHandler the final handler to invoke after all middlewares
     */
    public MiddlewareChain(List<Middleware> middlewares, Mono<Void> finalHandler) {
        this(List.copyOf(middlewares), finalHandler, 0);
    }

    private MiddlewareChain(List<Middleware> middlewares, Mono<Void> finalHandler, int position) {
        this.middlewares = middlewares;
        this.finalHandler = finalHandler;
        this.position = position;
    }

    /**
     * Calls the next middleware in the chain, or the final handler if no more middlewares remain.
     *
     * @param event   the event being processed
     * @param context the update context
     * @return a Mono that completes when the rest of the chain is done
     */
    public Mono<Void> next(Object event, UpdateContext context) {
        if (position < middlewares.size()) {
            Middleware middleware = middlewares.get(position);
            MiddlewareChain rest = new MiddlewareChain(middlewares, finalHandler, position + 1);
            // Deferred, so a middleware that throws instead of returning Mono.error still becomes
            // an error signal, which the middlewares before it (e.g. ErrorMiddleware) can handle.
            return Mono.defer(() -> middleware.process(event, context, rest));
        }
        return finalHandler;
    }
}
