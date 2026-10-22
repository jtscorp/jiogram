package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an
 * administrator in the chat for this to work and must have the can_manage_topics administrator
 * rights. The topic will be automatically unhidden if it was hidden. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @see <a href="https://core.telegram.org/bots/api#reopengeneralforumtopic">reopenGeneralForumTopic in the Bot API</a>
 */
public record ReopenGeneralForumTopic(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "reopenGeneralForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
