package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StoryAreaTypeWeather implements StoryAreaType {
    @JsonProperty("type") private final String type;
    @JsonProperty("temperature") private final double temperature;
    @JsonProperty("emoji") private final String emoji;
    @JsonProperty("background_color") private final long backgroundColor;

    @JsonCreator
    public StoryAreaTypeWeather(
            @JsonProperty("type") String type,
            @JsonProperty("temperature") double temperature,
            @JsonProperty("emoji") String emoji,
            @JsonProperty("background_color") long backgroundColor
    ) {
        this.type = type;
        this.temperature = temperature;
        this.emoji = emoji;
        this.backgroundColor = backgroundColor;
    }

    public String type() {
        return this.type;
    }

    public double temperature() {
        return this.temperature;
    }

    public String emoji() {
        return this.emoji;
    }

    public long backgroundColor() {
        return this.backgroundColor;
    }
}
