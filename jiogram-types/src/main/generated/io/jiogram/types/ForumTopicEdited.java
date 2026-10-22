package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about an edited forum topic.
 *
 * @param name New name of the topic, if it was edited
 * @param iconCustomEmojiId New identifier of the custom emoji shown as the topic icon, if it was
 *     edited; an empty string if the icon was removed
 * @see <a href="https://core.telegram.org/bots/api#forumtopicedited">ForumTopicEdited in the Bot API</a>
 */
public record ForumTopicEdited(
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId
) {

    public ForumTopicEdited withName(@Nullable String name) {
        return new ForumTopicEdited(name, iconCustomEmojiId);
    }

    public ForumTopicEdited withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new ForumTopicEdited(name, iconCustomEmojiId);
    }
}
