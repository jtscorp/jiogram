package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StoryAreaTypeUniqueGift(
    @JsonProperty("type") String type,
    @JsonProperty("name") String name
) implements StoryAreaType {}
