package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InputMediaType {
    ANIMATION("animation"),
    AUDIO("audio"),
    DOCUMENT("document"),
    PHOTO("photo"),
    VIDEO("video");

    private final String value;

    InputMediaType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static InputMediaType fromValue(String value) {
        for (InputMediaType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown InputMediaType: " + value);
    }
}
