package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MenuButtonType {
    DEFAULT("default"),
    WEB_APP("web_app"),
    COMMANDS("commands");

    private final String value;

    MenuButtonType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static MenuButtonType fromValue(String value) {
        for (MenuButtonType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown MenuButtonType: " + value);
    }
}
