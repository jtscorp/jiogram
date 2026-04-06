package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BackgroundFillGradient(
    @JsonProperty("type") String type,
    @JsonProperty("top_color") long topColor,
    @JsonProperty("bottom_color") long bottomColor,
    @JsonProperty("rotation_angle") long rotationAngle
) implements BackgroundFill {}
