package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundFillType;
import java.util.List;

public record BackgroundFillFreeformGradient(
    @JsonProperty("type") BackgroundFillType type,
    @JsonProperty("colors") List<Long> colors
) implements BackgroundFill {}
