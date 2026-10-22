package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to ban a channel chat in a supergroup or a channel. Until the chat is unbanned,
 * the owner of the banned chat won't be able to send messages on behalf of any of their channels.
 * The bot must be an administrator in the supergroup or channel for this to work and must have the
 * appropriate administrator rights. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param senderChatId Unique identifier of the target sender chat
 * @see <a href="https://core.telegram.org/bots/api#banchatsenderchat">banChatSenderChat in the Bot API</a>
 */
public record BanChatSenderChat(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("sender_chat_id") long senderChatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "banChatSenderChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
