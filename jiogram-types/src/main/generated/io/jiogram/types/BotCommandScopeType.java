package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Discriminator values for BotCommandScope.
 */
public enum BotCommandScopeType {
    ALL_CHAT_ADMINISTRATORS("all_chat_administrators"),
    ALL_GROUP_CHATS("all_group_chats"),
    ALL_PRIVATE_CHATS("all_private_chats"),
    CHAT("chat"),
    CHAT_ADMINISTRATORS("chat_administrators"),
    CHAT_MEMBER("chat_member"),
    DEFAULT("default"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    BotCommandScopeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static BotCommandScopeType fromValue(String value) {
        for (BotCommandScopeType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
