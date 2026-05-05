package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;

public record BackgroundFillGradient(
    @JsonProperty("type") BackgroundFillType type,
    @JsonProperty("top_color") long topColor,
    @JsonProperty("bottom_color") long bottomColor,
    @JsonProperty("rotation_angle") long rotationAngle
) implements BackgroundFill {}
