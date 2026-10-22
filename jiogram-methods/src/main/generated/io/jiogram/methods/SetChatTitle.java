package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to change the title of a chat. Titles can't be changed for private chats. The bot
 * must be an administrator in the chat for this to work and must have the appropriate administrator
 * rights. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param title New chat title, 1-128 characters
 * @see <a href="https://core.telegram.org/bots/api#setchattitle">setChatTitle in the Bot API</a>
 */
public record SetChatTitle(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("title") String title
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
