package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must
 * be an administrator in the chat for this to work and must have the can_manage_topics
 * administrator rights. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @param name New topic name, 1-128 characters
 * @see <a href="https://core.telegram.org/bots/api#editgeneralforumtopic">editGeneralForumTopic in the Bot API</a>
 */
public record EditGeneralForumTopic(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("name") String name
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "editGeneralForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public EditGeneralForumTopic withChatId(ChatId chatId) {
        return new EditGeneralForumTopic(chatId, name);
    }

    public EditGeneralForumTopic withName(String name) {
        return new EditGeneralForumTopic(chatId, name);
    }
}
