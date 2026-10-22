package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Supported thumbnail MIME type.
 */
public enum ThumbnailMimeType {
    IMAGE_JPEG("image/jpeg"),
    IMAGE_GIF("image/gif"),
    VIDEO_MP4("video/mp4"),
    /** A value unknown to this library version; {@link #value()} returns {@code null}. */
    UNKNOWN(null);

    private final String value;

    ThumbnailMimeType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ThumbnailMimeType fromValue(String value) {
        for (ThumbnailMimeType e : values()) {
            if (e.value != null && e.value.equals(value)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
