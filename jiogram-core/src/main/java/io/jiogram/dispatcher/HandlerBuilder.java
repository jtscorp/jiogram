package io.jiogram.dispatcher;

import io.jiogram.filter.Filter;
import io.jiogram.handler.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Fluent API for building and registering handlers with filters.
 *
 * @param <E> the event type
 */
public class HandlerBuilder<E> {

    private final EventObserver<E> observer;
    private final List<Filter<E>> filters;

    public HandlerBuilder(EventObserver<E> observer) {
        this.observer = observer;
        this.filters = new ArrayList<>();
    }

    /**
     * Adds a filter to apply before the handler.
     *
     * @param filter the filter to add
     * @return this builder for chaining
     */
    public HandlerBuilder<E> filter(Filter<E> filter) {
        this.filters.add(filter);
        return this;
    }

    /**
     * Registers the handler with all accumulated filters on the underlying observer.
     *
     * @param handler the handler to register
     */
    public void handle(Handler<E> handler) {
        observer.register(handler, List.copyOf(filters));
        filters.clear();
    }
}
