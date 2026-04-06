package io.jiogram.middleware;

import io.jiogram.dispatcher.UpdateContext;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Executes a chain of middlewares, followed by a final handler.
 * Each call to {@link #next(Object, UpdateContext)} advances to the next middleware,
 * or invokes the final handler if all middlewares have been called.
 */
public class MiddlewareChain {

    private final List<Middleware> middlewares;
    private final Mono<Void> finalHandler;
    private int index;

    /**
     * Creates a new middleware chain.
     *
     * @param middlewares  the ordered list of middlewares to execute
     * @param finalHandler the final handler to invoke after all middlewares
     */
    public MiddlewareChain(List<Middleware> middlewares, Mono<Void> finalHandler) {
        this.middlewares = List.copyOf(middlewares);
        this.finalHandler = finalHandler;
        this.index = 0;
    }

    /**
     * Calls the next middleware in the chain, or the final handler if no more middlewares remain.
     *
     * @param event   the event being processed
     * @param context the update context
     * @return a Mono that completes when the rest of the chain is done
     */
    public Mono<Void> next(Object event, UpdateContext context) {
        if (index < middlewares.size()) {
            Middleware middleware = middlewares.get(index);
            index++;
            return middleware.process(event, context, this);
        }
        return finalHandler;
    }
}
