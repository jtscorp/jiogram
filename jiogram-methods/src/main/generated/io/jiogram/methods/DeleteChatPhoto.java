package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must
 * be an administrator in the chat for this to work and must have the appropriate administrator
 * rights. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @see <a href="https://core.telegram.org/bots/api#deletechatphoto">deleteChatPhoto in the Bot API</a>
 */
public record DeleteChatPhoto(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteChatPhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public DeleteChatPhoto withChatId(ChatId chatId) {
        return new DeleteChatPhoto(chatId);
    }
}
