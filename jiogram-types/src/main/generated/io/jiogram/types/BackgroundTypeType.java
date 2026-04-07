package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BackgroundTypeType {
    PATTERN("pattern"),
    CHAT_THEME("chat_theme"),
    FILL("fill"),
    WALLPAPER("wallpaper");

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
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown BackgroundTypeType: " + value);
    }
}
