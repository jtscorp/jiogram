package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;
import java.util.List;

public class BackgroundFillFreeformGradient implements BackgroundFill {
    @JsonProperty("type") private final BackgroundFillType type;
    @JsonProperty("colors") private final List<Long> colors;

    @JsonCreator
    public BackgroundFillFreeformGradient(
            @JsonProperty("type") BackgroundFillType type,
            @JsonProperty("colors") List<Long> colors
    ) {
        this.type = type;
        this.colors = colors;
    }

    public BackgroundFillType type() {
        return this.type;
    }

    public List<Long> colors() {
        return this.colors;
    }
}
