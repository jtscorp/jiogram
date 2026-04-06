package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatBoostSourceType {
    GIFT_CODE("gift_code"),
    PREMIUM("premium"),
    GIVEAWAY("giveaway");

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
