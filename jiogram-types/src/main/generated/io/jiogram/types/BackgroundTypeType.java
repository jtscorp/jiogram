package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Discriminator values for BackgroundType.
 */
public enum BackgroundTypeType {
    CHAT_THEME("chat_theme"),
    FILL("fill"),
    PATTERN("pattern"),
    WALLPAPER("wallpaper"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    BackgroundTypeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static BackgroundTypeType fromValue(String value) {
        for (BackgroundTypeType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
