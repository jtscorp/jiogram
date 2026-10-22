package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to delete a sticker set that was created by the bot. Returns True on success.
 *
 * @param name Sticker set name
 * @see <a href="https://core.telegram.org/bots/api#deletestickerset">deleteStickerSet in the Bot API</a>
 */
public record DeleteStickerSet(
    @JsonProperty("name") String name
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public DeleteStickerSet withName(String name) {
        return new DeleteStickerSet(name);
    }
}
