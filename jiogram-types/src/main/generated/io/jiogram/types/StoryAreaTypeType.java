package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StoryAreaTypeType {
    SUGGESTED_REACTION("suggested_reaction"),
    LOCATION("location"),
    UNIQUE_GIFT("unique_gift"),
    LINK("link"),
    WEATHER("weather");

    private final String value;

    StoryAreaTypeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static StoryAreaTypeType fromValue(String value) {
        for (StoryAreaTypeType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown StoryAreaTypeType: " + value);
    }
}
