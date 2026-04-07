package io.jiogram.dispatcher;

import io.jiogram.filter.Filter;
import io.jiogram.filter.FilterResult;
import io.jiogram.handler.Handler;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Wraps a {@link Handler} with its associated {@link Filter}s.
 * Used internally by {@link EventObserver} to check filters before calling the handler.
 *
 * @param <E> the event type
 */
public class HandlerObject<E> {

    private final Handler<E> handler;
    private final List<Filter<E>> filters;

    public HandlerObject(Handler<E> handler, List<Filter<E>> filters) {
        this.handler = handler;
        this.filters = List.copyOf(filters);
    }

    /**
     * Checks all filters against the event and context.
     * Returns a Mono containing the merged data map if all filters pass,
     * or an empty Mono if any filter rejects.
     */
    public Mono<Map<String, Object>> check(E event, UpdateContext context) {
        if (filters.isEmpty()) {
            return Mono.just(Map.of());
        }

        Mono<Map<String, Object>> result = Mono.just(new HashMap<>());

        for (Filter<E> filter : filters) {
            result = result.flatMap(accumulated ->
                    filter.apply(event, context).flatMap(filterResult -> {
                        // Java 17-compatible exhaustive dispatch over the sealed
                        // FilterResult interface (no type pattern in switch).
                        if (filterResult instanceof FilterResult.Failed) {
                            return Mono.<Map<String, Object>>empty();
                        } else if (filterResult instanceof FilterResult.Passed) {
                            FilterResult.Passed passed = (FilterResult.Passed) filterResult;
                            HashMap<String, Object> merged = new HashMap<>(accumulated);
                            merged.putAll(passed.data());
                            return Mono.<Map<String, Object>>just(merged);
                        } else {
                            throw new IllegalStateException("Unknown FilterResult variant: " + filterResult);
                        }
                    })
            );
        }

        return result;
    }

    /**
     * Invokes the handler with the given event and context.
     */
    public Mono<Void> call(E event, UpdateContext context) {
        return handler.handle(event, context);
    }
}
