package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFill;
import io.jiogram.types.BackgroundTypeType;

public record BackgroundTypeFill(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
    @JsonProperty("fill") BackgroundFill fill,
    @JsonProperty("dark_theme_dimming") long darkThemeDimming
) implements BackgroundType {}
