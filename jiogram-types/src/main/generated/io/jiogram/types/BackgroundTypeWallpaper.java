package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundTypeType;
import io.jiogram.types.Document;
import org.jspecify.annotations.Nullable;

public record BackgroundTypeWallpaper(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) BackgroundTypeType type,
    @JsonProperty("document") Document document,
    @JsonProperty("dark_theme_dimming") long darkThemeDimming,
    @JsonProperty("is_blurred") @Nullable Boolean isBlurred,
    @JsonProperty("is_moving") @Nullable Boolean isMoving
) implements BackgroundType {}
