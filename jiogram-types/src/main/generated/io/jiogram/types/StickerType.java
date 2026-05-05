package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StickerType {
    REGULAR("regular"),
    MASK("mask"),
    CUSTOM_EMOJI("custom_emoji");

    private final String value;

    StickerType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static StickerType fromValue(String value) {
        for (StickerType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown StickerType: " + value);
    }
}
