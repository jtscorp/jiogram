package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatMember;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to get information about a member of a chat. The method is only guaranteed to
 * work for other users if the bot is an administrator in the chat. Returns a ChatMember object on
 * success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup or
 *     channel (in the format &#64;channelusername)
 * @param userId Unique identifier of the target user
 * @see <a href="https://core.telegram.org/bots/api#getchatmember">getChatMember in the Bot API</a>
 */
public record GetChatMember(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId
) implements TelegramMethod<ChatMember> {

    @Override
    public String apiMethod() {
        return "getChatMember";
    }

    @Override
    public String apiReturnType() {
        return "ChatMember";
    }
}
