package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Discriminator values for InlineQueryResult.
 */
public enum InlineQueryResultType {
    ARTICLE("article"),
    AUDIO("audio"),
    CONTACT("contact"),
    DOCUMENT("document"),
    GAME("game"),
    GIF("gif"),
    LOCATION("location"),
    MPEG4_GIF("mpeg4_gif"),
    PHOTO("photo"),
    STICKER("sticker"),
    VENUE("venue"),
    VIDEO("video"),
    VOICE("voice"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    InlineQueryResultType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static InlineQueryResultType fromValue(String value) {
        for (InlineQueryResultType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
