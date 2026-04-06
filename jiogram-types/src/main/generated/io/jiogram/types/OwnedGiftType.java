package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OwnedGiftType {
    REGULAR("regular"),
    UNIQUE("unique");

    private final String value;

    OwnedGiftType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static OwnedGiftType fromValue(String value) {
        for (OwnedGiftType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown OwnedGiftType: " + value);
    }
}
