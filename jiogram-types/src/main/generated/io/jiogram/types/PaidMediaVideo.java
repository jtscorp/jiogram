package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import io.jiogram.types.Video;

public record PaidMediaVideo(
    @JsonProperty("type") PaidMediaType type,
    @JsonProperty("video") Video video
) implements PaidMedia {}
