package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to delete a group sticker set from a supergroup. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights. Use the field
 * can_set_sticker_set optionally returned in getChat requests to check if the bot can use this
 * method. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @see <a href="https://core.telegram.org/bots/api#deletechatstickerset">deleteChatStickerSet in the Bot API</a>
 */
public record DeleteChatStickerSet(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteChatStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
