package io.jiogram.filter;

import io.jiogram.types.CallbackQuery;
import io.jiogram.types.Message;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;

/**
 * Static factory for all built-in filters.
 * Provides convenient methods to create commonly-used filters for messages,
 * callback queries, and FSM state checks.
 */
public final class Filters {

    private Filters() {
        // utility class
    }

    /**
     * Creates a filter matching bot commands.
     * Commands should be provided without the leading slash, e.g., "start", "help".
     * If no commands are specified, any command will match.
     *
     * @param commands the command names to match
     * @return a filter for matching commands
     */
    public static Filter<Message> command(String... commands) {
        return new CommandFilter(commands);
    }

    /**
     * Creates a filter matching messages with exact text content.
     *
     * @param exact the exact text to match
     * @return a filter for exact text matching
     */
    public static Filter<Message> text(String exact) {
        return (event, context) -> {
            String text = event.text();
            if (text != null && text.equals(exact)) {
                return Mono.just(FilterResult.passed());
            }
            return Mono.just(FilterResult.failed());
        };
    }

    /**
     * Creates a filter matching messages whose text starts with the given prefix.
     *
     * @param prefix the prefix to match
     * @return a filter for prefix matching
     */
    public static Filter<Message> textStartsWith(String prefix) {
        return (event, context) -> {
            String text = event.text();
            if (text != null && text.startsWith(prefix)) {
                return Mono.just(FilterResult.passed());
            }
            return Mono.just(FilterResult.failed());
        };
    }

    /**
     * Creates a filter matching messages whose text matches the given regex pattern.
     *
     * @param pattern the regex pattern string
     * @return a filter for regex matching
     */
    public static Filter<Message> regex(String pattern) {
        Pattern compiled = Pattern.compile(pattern);
        return (event, context) -> {
            String text = event.text();
            if (text != null && compiled.matcher(text).find()) {
                return Mono.just(FilterResult.passed());
            }
            return Mono.just(FilterResult.failed());
        };
    }

    /**
     * Creates a filter matching callback queries with exact data content.
     *
     * @param data the exact callback data to match
     * @return a filter for exact callback data matching
     */
    public static Filter<CallbackQuery> callbackData(String data) {
        return (event, context) -> {
            String eventData = event.data();
            if (eventData != null && eventData.equals(data)) {
                return Mono.just(FilterResult.passed());
            }
            return Mono.just(FilterResult.failed());
        };
    }

    /**
     * Creates a filter matching callback queries whose data starts with the given prefix.
     *
     * @param prefix the prefix to match against callback data
     * @return a filter for callback data prefix matching
     */
    public static Filter<CallbackQuery> callbackDataPrefix(String prefix) {
        return (event, context) -> {
            String data = event.data();
            if (data != null && data.startsWith(prefix)) {
                return Mono.just(FilterResult.passed());
            }
            return Mono.just(FilterResult.failed());
        };
    }

    /**
     * Creates a filter that checks the current FSM state.
     * Checks the "raw_state" key in the update context against the given state name.
     *
     * @param stateName the state name to match
     * @param <E>       the event type
     * @return a filter for FSM state matching
     */
    public static <E> Filter<E> state(String stateName) {
        return (event, context) -> {
            Object rawState = context.get("raw_state");
            if (stateName.equals(rawState)) {
                return Mono.just(FilterResult.passed());
            }
            return Mono.just(FilterResult.failed());
        };
    }
}
