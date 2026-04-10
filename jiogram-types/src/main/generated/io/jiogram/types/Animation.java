package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import org.jspecify.annotations.Nullable;

public class Animation {
    @JsonProperty("file_id") private final String fileId;
    @JsonProperty("file_unique_id") private final String fileUniqueId;
    @JsonProperty("width") private final long width;
    @JsonProperty("height") private final long height;
    @JsonProperty("duration") private final long duration;
    @JsonProperty("thumbnail") @Nullable private final PhotoSize thumbnail;
    @JsonProperty("file_name") @Nullable private final String fileName;
    @JsonProperty("mime_type") @Nullable private final String mimeType;
    @JsonProperty("file_size") @Nullable private final Long fileSize;

    @JsonCreator
    public Animation(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("width") long width,
            @JsonProperty("height") long height,
            @JsonProperty("duration") long duration,
            @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
            @JsonProperty("file_name") @Nullable String fileName,
            @JsonProperty("mime_type") @Nullable String mimeType,
            @JsonProperty("file_size") @Nullable Long fileSize
    ) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.thumbnail = thumbnail;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    public String fileId() {
        return this.fileId;
    }

    public String fileUniqueId() {
        return this.fileUniqueId;
    }

    public long width() {
        return this.width;
    }

    public long height() {
        return this.height;
    }

    public long duration() {
        return this.duration;
    }

    public PhotoSize thumbnail() {
        return this.thumbnail;
    }

    public String fileName() {
        return this.fileName;
    }

    public String mimeType() {
        return this.mimeType;
    }

    public Long fileSize() {
        return this.fileSize;
    }
}
