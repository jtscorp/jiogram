package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to set a new group sticker set for a supergroup. The bot must be an administrator
 * in the chat for this to work and must have the appropriate administrator rights. Use the field
 * can_set_sticker_set optionally returned in getChat requests to check if the bot can use this
 * method. Returns True on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the
 *     format &#64;supergroupusername)
 * @param stickerSetName Name of the sticker set to be set as the group sticker set
 * @see <a href="https://core.telegram.org/bots/api#setchatstickerset">setChatStickerSet in the Bot API</a>
 */
public record SetChatStickerSet(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("sticker_set_name") String stickerSetName
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
