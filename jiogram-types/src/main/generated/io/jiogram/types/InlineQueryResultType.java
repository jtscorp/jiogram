package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InlineQueryResultType {
    ARTICLE("article"),
    PHOTO("photo"),
    GIF("gif"),
    MPEG4_GIF("mpeg4_gif"),
    VIDEO("video"),
    AUDIO("audio"),
    VOICE("voice"),
    DOCUMENT("document"),
    LOCATION("location"),
    VENUE("venue"),
    CONTACT("contact"),
    GAME("game"),
    STICKER("sticker"),
    CACHED_PHOTO("cached_photo"),
    CACHED_GIF("cached_gif"),
    CACHED_MPEG4_GIF("cached_mpeg4_gif"),
    CACHED_VIDEO("cached_video"),
    CACHED_AUDIO("cached_audio"),
    CACHED_VOICE("cached_voice"),
    CACHED_DOCUMENT("cached_document");

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
