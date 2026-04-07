package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InputProfilePhotoType {
    ANIMATED("animated"),
    STATIC("static");

    private final String value;

    InputProfilePhotoType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static InputProfilePhotoType fromValue(String value) {
        for (InputProfilePhotoType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown InputProfilePhotoType: " + value);
    }
}
