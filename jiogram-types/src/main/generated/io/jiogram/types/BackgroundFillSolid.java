package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;

public class BackgroundFillSolid implements BackgroundFill {
    @JsonProperty("type") private final BackgroundFillType type;
    @JsonProperty("color") private final long color;

    @JsonCreator
    public BackgroundFillSolid(
            @JsonProperty("type") BackgroundFillType type,
            @JsonProperty("color") long color
    ) {
        this.type = type;
        this.color = color;
    }

    public BackgroundFillType type() {
        return this.type;
    }

    public long color() {
        return this.color;
    }
}
