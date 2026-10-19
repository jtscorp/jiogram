package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputPaidMediaType;
import org.jspecify.annotations.Nullable;

public record InputPaidMediaVideo(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputPaidMediaType type,
    @JsonProperty("media") InputFileOrString media,
    @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
    @JsonProperty("cover") @Nullable InputFileOrString cover,
    @JsonProperty("start_timestamp") @Nullable Long startTimestamp,
    @JsonProperty("width") @Nullable Long width,
    @JsonProperty("height") @Nullable Long height,
    @JsonProperty("duration") @Nullable Long duration,
    @JsonProperty("supports_streaming") @Nullable Boolean supportsStreaming
) implements InputPaidMedia {}
