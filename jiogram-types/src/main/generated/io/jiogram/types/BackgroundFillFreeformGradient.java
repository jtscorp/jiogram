package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BackgroundFillFreeformGradient implements BackgroundFill {
    @JsonProperty("type") private final String type;
    @JsonProperty("colors") private final List<Long> colors;

    @JsonCreator
    public BackgroundFillFreeformGradient(
            @JsonProperty("type") String type,
            @JsonProperty("colors") List<Long> colors
    ) {
        this.type = type;
        this.colors = colors;
    }

    public String type() {
        return this.type;
    }

    public List<Long> colors() {
        return this.colors;
    }
}
