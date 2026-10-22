package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of sticker.
 */
public enum StickerType {
    REGULAR("regular"),
    MASK("mask"),
    CUSTOM_EMOJI("custom_emoji"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

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
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
