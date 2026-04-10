package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.VideoQuality;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class Video {
    @JsonProperty("file_id") private final String fileId;
    @JsonProperty("file_unique_id") private final String fileUniqueId;
    @JsonProperty("width") private final long width;
    @JsonProperty("height") private final long height;
    @JsonProperty("duration") private final long duration;
    @JsonProperty("thumbnail") @Nullable private final PhotoSize thumbnail;
    @JsonProperty("cover") @Nullable private final List<PhotoSize> cover;
    @JsonProperty("start_timestamp") @Nullable private final Long startTimestamp;
    @JsonProperty("qualities") @Nullable private final List<VideoQuality> qualities;
    @JsonProperty("file_name") @Nullable private final String fileName;
    @JsonProperty("mime_type") @Nullable private final String mimeType;
    @JsonProperty("file_size") @Nullable private final Long fileSize;

    @JsonCreator
    public Video(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("width") long width,
            @JsonProperty("height") long height,
            @JsonProperty("duration") long duration,
            @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
            @JsonProperty("cover") @Nullable List<PhotoSize> cover,
            @JsonProperty("start_timestamp") @Nullable Long startTimestamp,
            @JsonProperty("qualities") @Nullable List<VideoQuality> qualities,
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
        this.cover = cover;
        this.startTimestamp = startTimestamp;
        this.qualities = qualities;
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

    public List<PhotoSize> cover() {
        return this.cover;
    }

    public Long startTimestamp() {
        return this.startTimestamp;
    }

    public List<VideoQuality> qualities() {
        return this.qualities;
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
