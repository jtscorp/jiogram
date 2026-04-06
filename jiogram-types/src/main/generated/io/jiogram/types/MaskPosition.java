package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MaskPosition(
    @JsonProperty("point") String point,
    @JsonProperty("x_shift") double xShift,
    @JsonProperty("y_shift") double yShift,
    @JsonProperty("scale") double scale
) {}
