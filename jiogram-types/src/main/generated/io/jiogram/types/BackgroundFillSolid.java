package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BackgroundFillSolid(
    @JsonProperty("type") String type,
    @JsonProperty("color") long color
) implements BackgroundFill {}
