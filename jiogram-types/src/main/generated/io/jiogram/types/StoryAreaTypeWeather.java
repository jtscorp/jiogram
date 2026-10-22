package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;

/**
 * Describes a story area containing weather information. Currently, a story can have up to 3
 * weather areas.
 *
 * @param type Type of the area, always 'weather'
 * @param temperature Temperature, in degree Celsius
 * @param emoji Emoji representing the weather
 * @param backgroundColor A color of the area background in the ARGB format
 * @see <a href="https://core.telegram.org/bots/api#storyareatypeweather">StoryAreaTypeWeather in the Bot API</a>
 */
public record StoryAreaTypeWeather(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
    @JsonProperty("temperature") double temperature,
    @JsonProperty("emoji") String emoji,
    @JsonProperty("background_color") long backgroundColor
) implements StoryAreaType {

    public StoryAreaTypeWeather withTemperature(double temperature) {
        return new StoryAreaTypeWeather(type, temperature, emoji, backgroundColor);
    }

    public StoryAreaTypeWeather withEmoji(String emoji) {
        return new StoryAreaTypeWeather(type, temperature, emoji, backgroundColor);
    }

    public StoryAreaTypeWeather withBackgroundColor(long backgroundColor) {
        return new StoryAreaTypeWeather(type, temperature, emoji, backgroundColor);
    }
}
