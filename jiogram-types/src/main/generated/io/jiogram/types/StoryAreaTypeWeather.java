package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StoryAreaTypeWeather(
    @JsonProperty("type") String type,
    @JsonProperty("temperature") double temperature,
    @JsonProperty("emoji") String emoji,
    @JsonProperty("background_color") long backgroundColor
) implements StoryAreaType {}
