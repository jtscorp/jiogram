package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Discriminator values for StoryAreaType.
 */
public enum StoryAreaTypeType {
    LINK("link"),
    LOCATION("location"),
    SUGGESTED_REACTION("suggested_reaction"),
    UNIQUE_GIFT("unique_gift"),
    WEATHER("weather"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

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
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
