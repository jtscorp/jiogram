package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaidMediaType {
    PHOTO("photo"),
    VIDEO("video"),
    PREVIEW("preview");

    private final String value;

    PaidMediaType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static PaidMediaType fromValue(String value) {
        for (PaidMediaType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown PaidMediaType: " + value);
    }
}
