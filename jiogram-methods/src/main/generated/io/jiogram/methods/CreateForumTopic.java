package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ForumTopic;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to create a topic in a forum supergroup chat or a private chat with a user. In
 * the case of a supergroup chat the bot must be an administrator in the chat for this to work and
 * must have the can_manage_topics administrator right. Returns information about the created topic
 * as a ForumTopic object.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @param name Topic name, 1-128 characters
 * @param iconColor Color of the topic icon in RGB format. Currently, must be one of 7322096
 *     (0x6FB9F0), 16766590 (0xFFD67E), 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490
 *     (0xFF93B2), or 16478047 (0xFB6F5F)
 * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon. Use
 *     getForumTopicIconStickers to get all allowed custom emoji identifiers.
 * @see <a href="https://core.telegram.org/bots/api#createforumtopic">createForumTopic in the Bot API</a>
 */
public record CreateForumTopic(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("name") String name,
    @JsonProperty("icon_color") @Nullable Long iconColor,
    @JsonProperty("icon_custom_emoji_id") @Nullable String iconCustomEmojiId
) implements TelegramMethod<ForumTopic> {

    @Override
    public String apiMethod() {
        return "createForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "ForumTopic";
    }

    public static CreateForumTopic of(ChatId chatId, String name) {
        return new CreateForumTopic(chatId, name, null, null);
    }
}
