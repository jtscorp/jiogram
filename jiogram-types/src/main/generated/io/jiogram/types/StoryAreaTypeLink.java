package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StoryAreaTypeLink(
    @JsonProperty("type") String type,
    @JsonProperty("url") String url
) implements StoryAreaType {}
