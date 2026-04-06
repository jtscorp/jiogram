package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record InputPaidMediaVideo(
    @JsonProperty("type") String type,
    @JsonProperty("media") String media,
    @JsonProperty("thumbnail") @Nullable String thumbnail,
    @JsonProperty("cover") @Nullable String cover,
    @JsonProperty("start_timestamp") @Nullable Long startTimestamp,
    @JsonProperty("width") @Nullable Long width,
    @JsonProperty("height") @Nullable Long height,
    @JsonProperty("duration") @Nullable Long duration,
    @JsonProperty("supports_streaming") @Nullable Boolean supportsStreaming
) implements InputPaidMedia {}
