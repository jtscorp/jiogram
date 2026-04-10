package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MaskPosition {
    @JsonProperty("point") private final String point;
    @JsonProperty("x_shift") private final double xShift;
    @JsonProperty("y_shift") private final double yShift;
    @JsonProperty("scale") private final double scale;

    @JsonCreator
    public MaskPosition(
            @JsonProperty("point") String point,
            @JsonProperty("x_shift") double xShift,
            @JsonProperty("y_shift") double yShift,
            @JsonProperty("scale") double scale
    ) {
        this.point = point;
        this.xShift = xShift;
        this.yShift = yShift;
        this.scale = scale;
    }

    public String point() {
        return this.point;
    }

    public double xShift() {
        return this.xShift;
    }

    public double yShift() {
        return this.yShift;
    }

    public double scale() {
        return this.scale;
    }
}
