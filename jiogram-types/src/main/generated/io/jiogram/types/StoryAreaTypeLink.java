package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;

/**
 * Describes a story area pointing to an HTTP or tg:// link. Currently, a story can have up to 3
 * link areas.
 *
 * @param type Type of the area, always 'link'
 * @param url HTTP or tg:// URL to be opened when the area is clicked
 * @see <a href="https://core.telegram.org/bots/api#storyareatypelink">StoryAreaTypeLink in the Bot API</a>
 */
public record StoryAreaTypeLink(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
    @JsonProperty("url") String url
) implements StoryAreaType {

    public StoryAreaTypeLink withUrl(String url) {
        return new StoryAreaTypeLink(type, url);
    }
}
