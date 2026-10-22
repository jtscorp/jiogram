package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of poll.
 */
public enum PollType {
    REGULAR("regular"),
    QUIZ("quiz"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    PollType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PollType fromValue(String value) {
        for (PollType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
