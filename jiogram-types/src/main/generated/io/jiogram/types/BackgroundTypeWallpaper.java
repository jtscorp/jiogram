package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundTypeType;
import io.jiogram.types.Document;
import org.jspecify.annotations.Nullable;

public class BackgroundTypeWallpaper implements BackgroundType {
    @JsonProperty("type") private final BackgroundTypeType type;
    @JsonProperty("document") private final Document document;
    @JsonProperty("dark_theme_dimming") private final long darkThemeDimming;
    @JsonProperty("is_blurred") @Nullable private final Boolean isBlurred;
    @JsonProperty("is_moving") @Nullable private final Boolean isMoving;

    @JsonCreator
    public BackgroundTypeWallpaper(
            @JsonProperty("type") BackgroundTypeType type,
            @JsonProperty("document") Document document,
            @JsonProperty("dark_theme_dimming") long darkThemeDimming,
            @JsonProperty("is_blurred") @Nullable Boolean isBlurred,
            @JsonProperty("is_moving") @Nullable Boolean isMoving
    ) {
        this.type = type;
        this.document = document;
        this.darkThemeDimming = darkThemeDimming;
        this.isBlurred = isBlurred;
        this.isMoving = isMoving;
    }

    public BackgroundTypeType type() {
        return this.type;
    }

    public Document document() {
        return this.document;
    }

    public long darkThemeDimming() {
        return this.darkThemeDimming;
    }

    public Boolean isBlurred() {
        return this.isBlurred;
    }

    public Boolean isMoving() {
        return this.isMoving;
    }
}
