package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageOriginType {
    CHANNEL("channel"),
    HIDDEN_USER("hidden_user"),
    CHAT("chat"),
    USER("user");

    private final String value;

    MessageOriginType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static MessageOriginType fromValue(String value) {
        for (MessageOriginType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown MessageOriginType: " + value);
    }
}
