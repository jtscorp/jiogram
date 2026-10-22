package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to get the number of members in a chat. Returns Int on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup or
 *     channel (in the format &#64;channelusername)
 * @see <a href="https://core.telegram.org/bots/api#getchatmembercount">getChatMemberCount in the Bot API</a>
 */
public record GetChatMemberCount(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Long> {

    @Override
    public String apiMethod() {
        return "getChatMemberCount";
    }

    @Override
    public String apiReturnType() {
        return "Int";
    }
}
