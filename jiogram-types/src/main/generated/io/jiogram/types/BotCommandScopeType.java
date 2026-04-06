package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BotCommandScopeType {
    ALL_CHAT_ADMINISTRATORS("all_chat_administrators"),
    CHAT("chat"),
    CHAT_ADMINISTRATORS("chat_administrators"),
    CHAT_MEMBER("chat_member"),
    DEFAULT("default"),
    ALL_PRIVATE_CHATS("all_private_chats"),
    ALL_GROUP_CHATS("all_group_chats");

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
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown BotCommandScopeType: " + value);
    }
}
