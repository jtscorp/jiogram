package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Discriminator values for ChatMember.
 */
public enum ChatMemberType {
    ADMINISTRATOR("administrator"),
    CREATOR("creator"),
    KICKED("kicked"),
    LEFT("left"),
    MEMBER("member"),
    RESTRICTED("restricted"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    ChatMemberType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ChatMemberType fromValue(String value) {
        for (ChatMemberType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
