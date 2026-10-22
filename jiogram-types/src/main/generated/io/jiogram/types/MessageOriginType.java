package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Discriminator values for MessageOrigin.
 */
public enum MessageOriginType {
    CHANNEL("channel"),
    CHAT("chat"),
    HIDDEN_USER("hidden_user"),
    USER("user"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

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
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
