package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundType;

public record ChatBackground(
    @JsonProperty("type") BackgroundType type
) {}
