package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class Voice {
    @JsonProperty("file_id") private final String fileId;
    @JsonProperty("file_unique_id") private final String fileUniqueId;
    @JsonProperty("duration") private final long duration;
    @JsonProperty("mime_type") @Nullable private final String mimeType;
    @JsonProperty("file_size") @Nullable private final Long fileSize;

    @JsonCreator
    public Voice(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("duration") long duration,
            @JsonProperty("mime_type") @Nullable String mimeType,
            @JsonProperty("file_size") @Nullable Long fileSize
    ) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.duration = duration;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
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

    public String mimeType() {
        return this.mimeType;
    }

    public Long fileSize() {
        return this.fileSize;
    }
}
