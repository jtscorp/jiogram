package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import org.jspecify.annotations.Nullable;

public record VideoNote(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("length") long length,
    @JsonProperty("duration") long duration,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
    @JsonProperty("file_size") @Nullable Long fileSize
) {}
