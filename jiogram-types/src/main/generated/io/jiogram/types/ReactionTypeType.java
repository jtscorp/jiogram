package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReactionTypeType {
    PAID("paid"),
    CUSTOM_EMOJI("custom_emoji"),
    EMOJI("emoji");

    private final String value;

    ReactionTypeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ReactionTypeType fromValue(String value) {
        for (ReactionTypeType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ReactionTypeType: " + value);
    }
}
