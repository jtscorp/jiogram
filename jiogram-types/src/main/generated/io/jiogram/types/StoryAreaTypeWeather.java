package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;

public record StoryAreaTypeWeather(
    @JsonProperty("type") StoryAreaTypeType type,
    @JsonProperty("temperature") double temperature,
    @JsonProperty("emoji") String emoji,
    @JsonProperty("background_color") long backgroundColor
) implements StoryAreaType {}
