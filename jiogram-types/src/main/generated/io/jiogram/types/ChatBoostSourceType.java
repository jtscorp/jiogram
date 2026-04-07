package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatBoostSourceType {
    GIVEAWAY("giveaway"),
    PREMIUM("premium"),
    GIFT_CODE("gift_code");

    private final String value;

    ChatBoostSourceType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ChatBoostSourceType fromValue(String value) {
        for (ChatBoostSourceType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ChatBoostSourceType: " + value);
    }
}
