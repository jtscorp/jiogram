package io.jiogram.filter;

import java.util.Map;
import java.util.Objects;

/**
 * Represents the result of applying a filter: either passed (with optional data) or failed.
 * The only implementations are {@link Passed} and {@link Failed}.
 */
public interface FilterResult {

    /**
     * A passed filter, with the data it contributes to the handler.
     */
    final class Passed implements FilterResult {

        private final Map<String, Object> data;

        /**
         * Creates a passed result carrying data.
         *
         * @param data the data the filter contributes
         */
        public Passed(Map<String, Object> data) {
            this.data = data;
        }

        /**
         * Creates a passed result without data.
         */
        public Passed() {
            this(Map.of());
        }

        /**
         * Returns the data the filter contributes.
         */
        public Map<String, Object> data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Passed)) {
                return false;
            }
            return Objects.equals(data, ((Passed) o).data);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(data);
        }

        @Override
        public String toString() {
            return "Passed[data=" + data + "]";
        }
    }

    /**
     * A failed filter.
     */
    final class Failed implements FilterResult {

        /**
         * Creates a failed result.
         */
        public Failed() {
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Failed;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return "Failed[]";
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
