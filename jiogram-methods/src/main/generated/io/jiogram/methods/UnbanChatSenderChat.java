package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to unban a previously banned channel chat in a supergroup or channel. The bot
 * must be an administrator for this to work and must have the appropriate administrator rights.
 * Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param senderChatId Unique identifier of the target sender chat
 * @see <a href="https://core.telegram.org/bots/api#unbanchatsenderchat">unbanChatSenderChat in the Bot API</a>
 */
public record UnbanChatSenderChat(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("sender_chat_id") long senderChatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unbanChatSenderChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
