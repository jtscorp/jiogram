package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaPosition;
import io.jiogram.types.StoryAreaType;

/**
 * Describes a clickable area on a story media.
 *
 * @param position Position of the area
 * @param type Type of the area
 * @see <a href="https://core.telegram.org/bots/api#storyarea">StoryArea in the Bot API</a>
 */
public record StoryArea(
    @JsonProperty("position") StoryAreaPosition position,
    @JsonProperty("type") StoryAreaType type
) {

    public StoryArea withPosition(StoryAreaPosition position) {
        return new StoryArea(position, type);
    }

    public StoryArea withType(StoryAreaType type) {
        return new StoryArea(position, type);
    }
}
