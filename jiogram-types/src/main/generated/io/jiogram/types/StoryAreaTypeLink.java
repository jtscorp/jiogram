package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;

public record StoryAreaTypeLink(
    @JsonProperty("type") StoryAreaTypeType type,
    @JsonProperty("url") String url
) implements StoryAreaType {}
