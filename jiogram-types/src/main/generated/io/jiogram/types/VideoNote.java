package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import org.jspecify.annotations.Nullable;

public class VideoNote {
    @JsonProperty("file_id") private final String fileId;
    @JsonProperty("file_unique_id") private final String fileUniqueId;
    @JsonProperty("length") private final long length;
    @JsonProperty("duration") private final long duration;
    @JsonProperty("thumbnail") @Nullable private final PhotoSize thumbnail;
    @JsonProperty("file_size") @Nullable private final Long fileSize;

    @JsonCreator
    public VideoNote(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("length") long length,
            @JsonProperty("duration") long duration,
            @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
            @JsonProperty("file_size") @Nullable Long fileSize
    ) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.length = length;
        this.duration = duration;
        this.thumbnail = thumbnail;
        this.fileSize = fileSize;
    }

    public String fileId() {
        return this.fileId;
    }

    public String fileUniqueId() {
        return this.fileUniqueId;
    }

    public long length() {
        return this.length;
    }

    public long duration() {
        return this.duration;
    }

    public PhotoSize thumbnail() {
        return this.thumbnail;
    }

    public Long fileSize() {
        return this.fileSize;
    }
}
