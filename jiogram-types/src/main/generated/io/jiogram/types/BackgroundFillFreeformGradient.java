package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record BackgroundFillFreeformGradient(
    @JsonProperty("type") String type,
    @JsonProperty("colors") List<Long> colors
) implements BackgroundFill {}
