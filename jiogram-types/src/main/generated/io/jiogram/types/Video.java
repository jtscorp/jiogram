package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.VideoQuality;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record Video(
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
) {}
