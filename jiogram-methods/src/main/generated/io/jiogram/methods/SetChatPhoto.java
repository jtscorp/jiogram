package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to set a new profile photo for the chat. Photos can't be changed for private
 * chats. The bot must be an administrator in the chat for this to work and must have the
 * appropriate administrator rights. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param photo New chat photo, uploaded using multipart/form-data
 * @see <a href="https://core.telegram.org/bots/api#setchatphoto">setChatPhoto in the Bot API</a>
 */
public record SetChatPhoto(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("photo") InputFile photo
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatPhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public SetChatPhoto withChatId(ChatId chatId) {
        return new SetChatPhoto(chatId, photo);
    }

    public SetChatPhoto withPhoto(InputFile photo) {
        return new SetChatPhoto(chatId, photo);
    }
}
