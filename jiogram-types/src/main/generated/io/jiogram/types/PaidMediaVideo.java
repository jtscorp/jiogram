package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Video;

public record PaidMediaVideo(
    @JsonProperty("type") String type,
    @JsonProperty("video") Video video
) implements PaidMedia {}
