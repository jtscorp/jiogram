package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BackgroundFillSolid implements BackgroundFill {
    @JsonProperty("type") private final String type;
    @JsonProperty("color") private final long color;

    @JsonCreator
    public BackgroundFillSolid(
            @JsonProperty("type") String type,
            @JsonProperty("color") long color
    ) {
        this.type = type;
        this.color = color;
    }

    public String type() {
        return this.type;
    }

    public long color() {
        return this.color;
    }
}
