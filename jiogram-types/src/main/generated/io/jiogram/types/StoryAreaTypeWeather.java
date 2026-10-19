package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;

public record StoryAreaTypeWeather(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
    @JsonProperty("temperature") double temperature,
    @JsonProperty("emoji") String emoji,
    @JsonProperty("background_color") long backgroundColor
) implements StoryAreaType {}
