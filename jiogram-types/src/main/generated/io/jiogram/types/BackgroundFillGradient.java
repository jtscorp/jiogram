package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BackgroundFillGradient implements BackgroundFill {
    @JsonProperty("type") private final String type;
    @JsonProperty("top_color") private final long topColor;
    @JsonProperty("bottom_color") private final long bottomColor;
    @JsonProperty("rotation_angle") private final long rotationAngle;

    @JsonCreator
    public BackgroundFillGradient(
            @JsonProperty("type") String type,
            @JsonProperty("top_color") long topColor,
            @JsonProperty("bottom_color") long bottomColor,
            @JsonProperty("rotation_angle") long rotationAngle
    ) {
        this.type = type;
        this.topColor = topColor;
        this.bottomColor = bottomColor;
        this.rotationAngle = rotationAngle;
    }

    public String type() {
        return this.type;
    }

    public long topColor() {
        return this.topColor;
    }

    public long bottomColor() {
        return this.bottomColor;
    }

    public long rotationAngle() {
        return this.rotationAngle;
    }
}
