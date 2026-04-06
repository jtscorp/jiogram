package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StoryAreaPosition(
    @JsonProperty("x_percentage") double xPercentage,
    @JsonProperty("y_percentage") double yPercentage,
    @JsonProperty("width_percentage") double widthPercentage,
    @JsonProperty("height_percentage") double heightPercentage,
    @JsonProperty("rotation_angle") double rotationAngle,
    @JsonProperty("corner_radius_percentage") double cornerRadiusPercentage
) {}
