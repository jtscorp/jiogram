package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatMemberType {
    ADMINISTRATOR("administrator"),
    CREATOR("creator"),
    KICKED("kicked"),
    LEFT("left"),
    MEMBER("member"),
    RESTRICTED("restricted");

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
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ChatMemberType: " + value);
    }
}
