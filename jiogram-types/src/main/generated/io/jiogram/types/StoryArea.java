package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaPosition;
import io.jiogram.types.StoryAreaType;

public record StoryArea(
    @JsonProperty("position") StoryAreaPosition position,
    @JsonProperty("type") StoryAreaType type
) {}
