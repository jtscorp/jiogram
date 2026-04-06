package io.jiogram.middleware;

import io.jiogram.dispatcher.UpdateContext;
import reactor.core.publisher.Mono;

/**
 * A functional interface representing middleware in the processing pipeline.
 * Middleware can inspect/modify the event and context, and must call the chain to proceed.
 */
@FunctionalInterface
public interface Middleware {

    /**
     * Processes the event, optionally modifying it or the context, then calls the chain to proceed.
     *
     * @param event   the event being processed
     * @param context the update context
     * @param chain   the chain to call to continue processing
     * @return a Mono that completes when processing is done
     */
    Mono<Void> process(Object event, UpdateContext context, MiddlewareChain chain);
}
