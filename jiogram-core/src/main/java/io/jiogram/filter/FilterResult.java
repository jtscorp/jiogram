package io.jiogram.filter;

import java.util.Map;

/**
 * Represents the result of applying a filter: either passed (with optional data) or failed.
 */
public sealed interface FilterResult {

    record Passed(Map<String, Object> data) implements FilterResult {
        public Passed() {
            this(Map.of());
        }
    }

    record Failed() implements FilterResult {
    }

    static FilterResult passed() {
        return new Passed();
    }

    static FilterResult passed(Map<String, Object> data) {
        return new Passed(data);
    }

    static FilterResult failed() {
        return new Failed();
    }
}
