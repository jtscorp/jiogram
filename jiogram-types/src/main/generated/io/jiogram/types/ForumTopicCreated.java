package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about a new forum topic created in the chat.
 *
 * @param name Name of the topic
 * @param iconColor Color of the topic icon in RGB format
 * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon
 * @param isNameImplicit True, if the name of the topic wasn't specified explicitly by its creator
 *     and likely needs to be changed by the bot
 * @see <a href="https://core.telegram.org/bots/api#forumtopiccreated">ForumTopicCreated in the Bot API</a>
 */
public record ForumTopicCreated(
    @JsonProperty("name") String name,
    @JsonProperty("icon_color") long iconColor,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId,
    @JsonProperty("is_name_implicit") @Nullable Boolean isNameImplicit
) {

    public static ForumTopicCreated of(String name, long iconColor) {
        return new ForumTopicCreated(name, iconColor, null, null);
    }

    public ForumTopicCreated withName(String name) {
        return new ForumTopicCreated(name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopicCreated withIconColor(long iconColor) {
        return new ForumTopicCreated(name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopicCreated withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new ForumTopicCreated(name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopicCreated withIsNameImplicit(@Nullable Boolean isNameImplicit) {
        return new ForumTopicCreated(name, iconColor, iconCustomEmojiId, isNameImplicit);
    }
}
