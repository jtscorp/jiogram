package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BackgroundFillType {
    GRADIENT("gradient"),
    SOLID("solid"),
    FREEFORM_GRADIENT("freeform_gradient");

    private final String value;

    BackgroundFillType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static BackgroundFillType fromValue(String value) {
        for (BackgroundFillType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown BackgroundFillType: " + value);
    }
}
