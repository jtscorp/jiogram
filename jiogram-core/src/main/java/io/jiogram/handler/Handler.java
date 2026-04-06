package io.jiogram.handler;

import io.jiogram.dispatcher.UpdateContext;
import reactor.core.publisher.Mono;

/**
 * A functional interface representing a handler for a specific event type.
 *
 * @param <E> the event type this handler processes
 */
@FunctionalInterface
public interface Handler<E> {

    /**
     * Handles the given event within the provided context.
     *
     * @param event   the event to handle
     * @param context the update context
     * @return a Mono that completes when handling is done
     */
    Mono<Void> handle(E event, UpdateContext context);
}
