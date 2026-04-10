package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFill;

public class BackgroundTypeFill implements BackgroundType {
    @JsonProperty("type") private final String type;
    @JsonProperty("fill") private final BackgroundFill fill;
    @JsonProperty("dark_theme_dimming") private final long darkThemeDimming;

    @JsonCreator
    public BackgroundTypeFill(
            @JsonProperty("type") String type,
            @JsonProperty("fill") BackgroundFill fill,
            @JsonProperty("dark_theme_dimming") long darkThemeDimming
    ) {
        this.type = type;
        this.fill = fill;
        this.darkThemeDimming = darkThemeDimming;
    }

    public String type() {
        return this.type;
    }

    public BackgroundFill fill() {
        return this.fill;
    }

    public long darkThemeDimming() {
        return this.darkThemeDimming;
    }
}
