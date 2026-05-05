package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum VideoMimeType {
    TEXT_HTML("text/html"),
    VIDEO_MP4("video/mp4");

    private final String value;

    VideoMimeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static VideoMimeType fromValue(String value) {
        for (VideoMimeType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown VideoMimeType: " + value);
    }
}
