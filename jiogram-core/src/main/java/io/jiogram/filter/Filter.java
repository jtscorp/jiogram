package io.jiogram.filter;

import io.jiogram.dispatcher.UpdateContext;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * A functional interface representing a filter that can accept or reject events,
 * optionally attaching data on pass.
 *
 * @param <E> the event type this filter processes
 */
@FunctionalInterface
public interface Filter<E> {

    /**
     * Applies this filter to the given event and context.
     *
     * @param event   the event to filter
     * @param context the update context
     * @return a Mono emitting a FilterResult
     */
    Mono<FilterResult> apply(E event, UpdateContext context);

    /**
     * Returns a filter that passes only if both this filter and the other filter pass.
     * When both pass, their data maps are merged (other's data overwrites on key collision).
     */
    default Filter<E> and(Filter<E> other) {
        return (event, context) -> this.apply(event, context)
                .flatMap(result -> {
                    // Java 11-compatible dispatch over FilterResult (Passed or Failed).
                    if (result instanceof FilterResult.Failed) {
                        return Mono.just(FilterResult.failed());
                    } else if (result instanceof FilterResult.Passed) {
                        FilterResult.Passed first = (FilterResult.Passed) result;
                        return other.apply(event, context)
                                .map(otherResult -> {
                                    if (otherResult instanceof FilterResult.Failed) {
                                        return FilterResult.failed();
                                    } else if (otherResult instanceof FilterResult.Passed) {
                                        FilterResult.Passed second = (FilterResult.Passed) otherResult;
                                        HashMap<String, Object> merged = new HashMap<>(first.data());
                                        merged.putAll(second.data());
                                        return FilterResult.passed(Map.copyOf(merged));
                                    } else {
                                        throw new IllegalStateException("Unknown FilterResult variant: " + otherResult);
                                    }
                                });
                    } else {
                        throw new IllegalStateException("Unknown FilterResult variant: " + result);
                    }
                });
    }

    /**
     * Returns a filter that passes if either this filter or the other filter passes.
     * The first passing result wins.
     */
    default Filter<E> or(Filter<E> other) {
        return (event, context) -> this.apply(event, context)
                .flatMap(result -> {
                    if (result instanceof FilterResult.Passed) {
                        return Mono.just(result);
                    } else if (result instanceof FilterResult.Failed) {
                        return other.apply(event, context);
                    } else {
                        throw new IllegalStateException("Unknown FilterResult variant: " + result);
                    }
                });
    }

    /**
     * Returns a filter that inverts this filter's result.
     * A pass becomes a fail, and a fail becomes a pass (with no data).
     */
    default Filter<E> negate() {
        return (event, context) -> this.apply(event, context)
                .map(result -> {
                    if (result instanceof FilterResult.Passed) {
                        return FilterResult.failed();
                    } else if (result instanceof FilterResult.Failed) {
                        return FilterResult.passed();
                    } else {
                        throw new IllegalStateException("Unknown FilterResult variant: " + result);
                    }
                });
    }
}
