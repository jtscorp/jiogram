package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StoryAreaTypeType {
    LINK("link"),
    UNIQUE_GIFT("unique_gift"),
    LOCATION("location"),
    SUGGESTED_REACTION("suggested_reaction"),
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
