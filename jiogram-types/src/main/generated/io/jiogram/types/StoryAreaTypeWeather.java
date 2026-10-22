package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;
import java.util.Objects;

/**
 * Describes a story area containing weather information. Currently, a story can have up to 3
 * weather areas.
 *
 * @see <a href="https://core.telegram.org/bots/api#storyareatypeweather">StoryAreaTypeWeather in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StoryAreaTypeWeather implements StoryAreaType {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final StoryAreaTypeType type;

    @JsonProperty("temperature")
    private final double temperature;

    @JsonProperty("emoji")
    private final String emoji;

    @JsonProperty("background_color")
    private final long backgroundColor;

    /**
     * Creates a new {@code StoryAreaTypeWeather} instance.
     *
     * @param type Type of the area, always 'weather'
     * @param temperature Temperature, in degree Celsius
     * @param emoji Emoji representing the weather
     * @param backgroundColor A color of the area background in the ARGB format
     */
    @JsonCreator
    public StoryAreaTypeWeather(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
            @JsonProperty("temperature") double temperature,
            @JsonProperty("emoji") String emoji,
            @JsonProperty("background_color") long backgroundColor) {
        this.type = type;
        this.temperature = temperature;
        this.emoji = emoji;
        this.backgroundColor = backgroundColor;
    }

    public static StoryAreaTypeWeather of(double temperature, String emoji, long backgroundColor) {
        return new StoryAreaTypeWeather(StoryAreaTypeType.WEATHER, temperature, emoji, backgroundColor);
    }

    /**
     * Type of the area, always 'weather'
     */
    public StoryAreaTypeType type() {
        return type;
    }

    /**
     * Temperature, in degree Celsius
     */
    public double temperature() {
        return temperature;
    }

    /**
     * Emoji representing the weather
     */
    public String emoji() {
        return emoji;
    }

    /**
     * A color of the area background in the ARGB format
     */
    public long backgroundColor() {
        return backgroundColor;
    }

    public StoryAreaTypeWeather withTemperature(double temperature) {
        return new StoryAreaTypeWeather(type, temperature, emoji, backgroundColor);
    }

    public StoryAreaTypeWeather withEmoji(String emoji) {
        return new StoryAreaTypeWeather(type, temperature, emoji, backgroundColor);
    }

    public StoryAreaTypeWeather withBackgroundColor(long backgroundColor) {
        return new StoryAreaTypeWeather(type, temperature, emoji, backgroundColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoryAreaTypeWeather)) {
            return false;
        }
        StoryAreaTypeWeather that = (StoryAreaTypeWeather) o;
        return Objects.equals(this.type, that.type)
                && Double.compare(this.temperature, that.temperature) == 0
                && Objects.equals(this.emoji, that.emoji)
                && this.backgroundColor == that.backgroundColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.temperature, this.emoji, this.backgroundColor);
    }

    @Override
    public String toString() {
        return "StoryAreaTypeWeather[type=" + this.type
                + ", temperature=" + this.temperature
                + ", emoji=" + this.emoji
                + ", backgroundColor=" + this.backgroundColor
                + "]";
    }
}
