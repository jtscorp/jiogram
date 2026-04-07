package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BackgroundTypeType {
    CHAT_THEME("chat_theme"),
    FILL("fill"),
    PATTERN("pattern"),
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
