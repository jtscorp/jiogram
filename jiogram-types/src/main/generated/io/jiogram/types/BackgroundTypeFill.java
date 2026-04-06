package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFill;

public record BackgroundTypeFill(
    @JsonProperty("type") String type,
    @JsonProperty("fill") BackgroundFill fill,
    @JsonProperty("dark_theme_dimming") long darkThemeDimming
) implements BackgroundType {}
