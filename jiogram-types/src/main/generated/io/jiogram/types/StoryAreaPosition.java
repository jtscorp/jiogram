package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StoryAreaPosition {
    @JsonProperty("x_percentage") private final double xPercentage;
    @JsonProperty("y_percentage") private final double yPercentage;
    @JsonProperty("width_percentage") private final double widthPercentage;
    @JsonProperty("height_percentage") private final double heightPercentage;
    @JsonProperty("rotation_angle") private final double rotationAngle;
    @JsonProperty("corner_radius_percentage") private final double cornerRadiusPercentage;

    @JsonCreator
    public StoryAreaPosition(
            @JsonProperty("x_percentage") double xPercentage,
            @JsonProperty("y_percentage") double yPercentage,
            @JsonProperty("width_percentage") double widthPercentage,
            @JsonProperty("height_percentage") double heightPercentage,
            @JsonProperty("rotation_angle") double rotationAngle,
            @JsonProperty("corner_radius_percentage") double cornerRadiusPercentage
    ) {
        this.xPercentage = xPercentage;
        this.yPercentage = yPercentage;
        this.widthPercentage = widthPercentage;
        this.heightPercentage = heightPercentage;
        this.rotationAngle = rotationAngle;
        this.cornerRadiusPercentage = cornerRadiusPercentage;
    }

    public double xPercentage() {
        return this.xPercentage;
    }

    public double yPercentage() {
        return this.yPercentage;
    }

    public double widthPercentage() {
        return this.widthPercentage;
    }

    public double heightPercentage() {
        return this.heightPercentage;
    }

    public double rotationAngle() {
        return this.rotationAngle;
    }

    public double cornerRadiusPercentage() {
        return this.cornerRadiusPercentage;
    }
}
