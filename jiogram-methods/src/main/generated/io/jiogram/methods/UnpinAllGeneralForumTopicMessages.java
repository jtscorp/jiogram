package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to clear the list of pinned messages in a General forum topic. The bot must be an
 * administrator in the chat for this to work and must have the can_pin_messages administrator right
 * in the supergroup. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @see <a href="https://core.telegram.org/bots/api#unpinallgeneralforumtopicmessages">unpinAllGeneralForumTopicMessages in the Bot API</a>
 */
public record UnpinAllGeneralForumTopicMessages(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unpinAllGeneralForumTopicMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public UnpinAllGeneralForumTopicMessages withChatId(ChatId chatId) {
        return new UnpinAllGeneralForumTopicMessages(chatId);
    }
}
