package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;

/**
 * Describes a story area pointing to a unique gift. Currently, a story can have at most 1 unique
 * gift area.
 *
 * @param type Type of the area, always 'unique_gift'
 * @param name Unique name of the gift
 * @see <a href="https://core.telegram.org/bots/api#storyareatypeuniquegift">StoryAreaTypeUniqueGift in the Bot API</a>
 */
public record StoryAreaTypeUniqueGift(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
    @JsonProperty("name") String name
) implements StoryAreaType {

    public StoryAreaTypeUniqueGift withName(String name) {
        return new StoryAreaTypeUniqueGift(type, name);
    }
}
