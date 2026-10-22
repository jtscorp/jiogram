package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the description of a group, a supergroup or a channel. The bot must be
 * an administrator in the chat for this to work and must have the appropriate administrator rights.
 * Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param description New chat description, 0-255 characters
 * @see <a href="https://core.telegram.org/bots/api#setchatdescription">setChatDescription in the Bot API</a>
 */
public record SetChatDescription(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("description") @Nullable String description
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetChatDescription of(ChatId chatId) {
        return new SetChatDescription(chatId, null);
    }

    public SetChatDescription withChatId(ChatId chatId) {
        return new SetChatDescription(chatId, description);
    }

    public SetChatDescription withDescription(@Nullable String description) {
        return new SetChatDescription(chatId, description);
    }
}
