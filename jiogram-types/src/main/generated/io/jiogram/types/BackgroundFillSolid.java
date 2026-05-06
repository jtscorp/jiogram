package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;

public record BackgroundFillSolid(
    @JsonProperty("type") BackgroundFillType type,
    @JsonProperty("color") long color
) implements BackgroundFill {}
