package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InlineQueryResultType {
    ARTICLE("article"),
    AUDIO("audio"),
    CACHED_AUDIO("cached_audio"),
    CACHED_DOCUMENT("cached_document"),
    CACHED_GIF("cached_gif"),
    CACHED_MPEG4_GIF("cached_mpeg4_gif"),
    CACHED_PHOTO("cached_photo"),
    CACHED_VIDEO("cached_video"),
    CACHED_VOICE("cached_voice"),
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
    VOICE("voice");

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
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown InlineQueryResultType: " + value);
    }
}
