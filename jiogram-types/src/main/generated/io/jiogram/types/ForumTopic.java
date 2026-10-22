package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a forum topic.
 *
 * @param messageThreadId Unique identifier of the forum topic
 * @param name Name of the topic
 * @param iconColor Color of the topic icon in RGB format
 * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon
 * @param isNameImplicit True, if the name of the topic wasn't specified explicitly by its creator
 *     and likely needs to be changed by the bot
 * @see <a href="https://core.telegram.org/bots/api#forumtopic">ForumTopic in the Bot API</a>
 */
public record ForumTopic(
    @JsonProperty("message_thread_id") long messageThreadId,
    @JsonProperty("name") String name,
    @JsonProperty("icon_color") long iconColor,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId,
    @JsonProperty("is_name_implicit") @Nullable Boolean isNameImplicit
) {

    public static ForumTopic of(long messageThreadId, String name, long iconColor) {
        return new ForumTopic(messageThreadId, name, iconColor, null, null);
    }

    public ForumTopic withMessageThreadId(long messageThreadId) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopic withName(String name) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopic withIconColor(long iconColor) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopic withIconCustomEmojiId(@Nullable String iconCustomEmojiId) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }

    public ForumTopic withIsNameImplicit(@Nullable Boolean isNameImplicit) {
        return new ForumTopic(messageThreadId, name, iconColor, iconCustomEmojiId, isNameImplicit);
    }
}
