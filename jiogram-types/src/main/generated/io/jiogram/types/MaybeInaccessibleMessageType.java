package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MaybeInaccessibleMessageType {
    _0("0"),
    NONZERO("nonzero");

    private final String value;

    MaybeInaccessibleMessageType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static MaybeInaccessibleMessageType fromValue(String value) {
        for (MaybeInaccessibleMessageType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown MaybeInaccessibleMessageType: " + value);
    }
}
