package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit name and icon of a topic in a forum supergroup chat or a private chat
 * with a user. In the case of a supergroup chat the bot must be an administrator in the chat for
 * this to work and must have the can_manage_topics administrator rights, unless it is the creator
 * of the topic. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @param messageThreadId Unique identifier for the target message thread of the forum topic
 * @param name New topic name, 0-128 characters. If not specified or empty, the current name of the
 *     topic will be kept
 * @param iconCustomEmojiId New unique identifier of the custom emoji shown as the topic icon. Use
 *     getForumTopicIconStickers to get all allowed custom emoji identifiers. Pass an empty string
 *     to remove the icon. If not specified, the current icon will be kept
 * @see <a href="https://core.telegram.org/bots/api#editforumtopic">editForumTopic in the Bot API</a>
 */
public record EditForumTopic(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") long messageThreadId,
    @JsonProperty("name") @Nullable String name,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "editForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static EditForumTopic of(ChatId chatId, long messageThreadId) {
        return new EditForumTopic(chatId, messageThreadId, null, null);
    }
}
