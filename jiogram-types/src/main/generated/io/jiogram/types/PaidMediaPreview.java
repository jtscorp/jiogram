package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import org.jspecify.annotations.Nullable;

public record PaidMediaPreview(
    @JsonProperty("type") PaidMediaType type,
    @JsonProperty("width") @Nullable Long width,
    @JsonProperty("height") @Nullable Long height,
    @JsonProperty("duration") @Nullable Long duration
) implements PaidMedia {}
