package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import org.jspecify.annotations.Nullable;

public class Audio {
    @JsonProperty("file_id") private final String fileId;
    @JsonProperty("file_unique_id") private final String fileUniqueId;
    @JsonProperty("duration") private final long duration;
    @JsonProperty("performer") @Nullable private final String performer;
    @JsonProperty("title") @Nullable private final String title;
    @JsonProperty("file_name") @Nullable private final String fileName;
    @JsonProperty("mime_type") @Nullable private final String mimeType;
    @JsonProperty("file_size") @Nullable private final Long fileSize;
    @JsonProperty("thumbnail") @Nullable private final PhotoSize thumbnail;

    @JsonCreator
    public Audio(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("duration") long duration,
            @JsonProperty("performer") @Nullable String performer,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("file_name") @Nullable String fileName,
            @JsonProperty("mime_type") @Nullable String mimeType,
            @JsonProperty("file_size") @Nullable Long fileSize,
            @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail
    ) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
        this.thumbnail = thumbnail;
    }

    public String fileId() {
        return this.fileId;
    }

    public String fileUniqueId() {
        return this.fileUniqueId;
    }

    public long duration() {
        return this.duration;
    }

    public String performer() {
        return this.performer;
    }

    public String title() {
        return this.title;
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

    public PhotoSize thumbnail() {
        return this.thumbnail;
    }
}
