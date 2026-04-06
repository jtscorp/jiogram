package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InputPaidMediaType {
    PHOTO("photo"),
    VIDEO("video");

    private final String value;

    InputPaidMediaType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static InputPaidMediaType fromValue(String value) {
        for (InputPaidMediaType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown InputPaidMediaType: " + value);
    }
}
