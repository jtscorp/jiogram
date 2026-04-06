package io.jiogram.dispatcher;

import io.jiogram.filter.Filter;
import io.jiogram.handler.Handler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Manages handlers for a single event type.
 * When triggered, iterates through registered handlers and invokes the first one whose filters all pass.
 *
 * @param <E> the event type
 */
public class EventObserver<E> {

    private final String eventType;
    private final List<HandlerObject<E>> handlers;

    public EventObserver(String eventType) {
        this.eventType = eventType;
        this.handlers = new CopyOnWriteArrayList<>();
    }

    /**
     * Registers a handler with optional filters.
     */
    @SafeVarargs
    public final void register(Handler<E> handler, Filter<E>... filters) {
        handlers.add(new HandlerObject<>(handler, List.of(filters)));
    }

    /**
     * Registers a handler with a list of filters.
     */
    public void register(Handler<E> handler, List<Filter<E>> filters) {
        handlers.add(new HandlerObject<>(handler, filters));
    }

    /**
     * Triggers the event by checking each registered handler's filters in order.
     * The first handler whose filters all pass is invoked.
     *
     * @param event   the event
     * @param context the update context
     * @return a Mono emitting true if a handler was found and invoked, false otherwise
     */
    public Mono<Boolean> trigger(E event, UpdateContext context) {
        return Flux.fromIterable(handlers)
                .concatMap(handlerObject ->
                        handlerObject.check(event, context)
                                .flatMap(data -> {
                                    context.merge(data);
                                    return handlerObject.call(event, context)
                                            .thenReturn(true);
                                })
                )
                .next()
                .defaultIfEmpty(false);
    }

    /**
     * Returns true if at least one handler is registered.
     */
    public boolean hasHandlers() {
        return !handlers.isEmpty();
    }

    public String eventType() {
        return eventType;
    }
}
