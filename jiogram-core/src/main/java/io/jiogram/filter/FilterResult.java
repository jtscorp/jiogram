package io.jiogram.filter;

import java.util.Map;
import java.util.Objects;

/**
 * Represents the result of applying a filter: either passed (with optional data) or failed.
 */
public interface FilterResult {

    final class Passed implements FilterResult {
        private final Map<String, Object> data;

        public Passed(Map<String, Object> data) {
            this.data = data;
        }

        public Passed() {
            this(Map.of());
        }

        public Map<String, Object> data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Passed)) return false;
            Passed other = (Passed) o;
            return Objects.equals(data, other.data);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(data);
        }

        @Override
        public String toString() {
            return "FilterResult.Passed[data=" + data + "]";
        }
    }

    final class Failed implements FilterResult {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            return o instanceof Failed;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return "FilterResult.Failed[]";
        }
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
