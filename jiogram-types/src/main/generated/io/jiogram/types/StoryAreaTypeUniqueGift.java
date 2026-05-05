package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;

public record StoryAreaTypeUniqueGift(
    @JsonProperty("type") StoryAreaTypeType type,
    @JsonProperty("name") String name
) implements StoryAreaType {}
