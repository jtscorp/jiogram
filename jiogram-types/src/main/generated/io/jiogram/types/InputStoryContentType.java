package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InputStoryContentType {
    VIDEO("video"),
    PHOTO("photo");

    private final String value;

    InputStoryContentType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static InputStoryContentType fromValue(String value) {
        for (InputStoryContentType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown InputStoryContentType: " + value);
    }
}
