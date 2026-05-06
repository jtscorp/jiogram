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
                .flatMap(result -> switch (result) {
                    case FilterResult.Failed() -> Mono.just(FilterResult.failed());
                    case FilterResult.Passed(var firstData) -> other.apply(event, context)
                            .map(otherResult -> switch (otherResult) {
                                case FilterResult.Failed() -> FilterResult.failed();
                                case FilterResult.Passed(var secondData) -> {
                                    HashMap<String, Object> merged = new HashMap<>(firstData);
                                    merged.putAll(secondData);
                                    yield FilterResult.passed(Map.copyOf(merged));
                                }
                            });
                });
    }

    /**
     * Returns a filter that passes if either this filter or the other filter passes.
     * The first passing result wins.
     */
    default Filter<E> or(Filter<E> other) {
        return (event, context) -> this.apply(event, context)
                .flatMap(result -> switch (result) {
                    case FilterResult.Passed(var _) -> Mono.just(result);
                    case FilterResult.Failed() -> other.apply(event, context);
                });
    }

    /**
     * Returns a filter that inverts this filter's result.
     * A pass becomes a fail, and a fail becomes a pass (with no data).
     */
    default Filter<E> negate() {
        return (event, context) -> this.apply(event, context)
                .map(result -> switch (result) {
                    case FilterResult.Passed(var _) -> FilterResult.failed();
                    case FilterResult.Failed() -> FilterResult.passed();
                });
    }
}
