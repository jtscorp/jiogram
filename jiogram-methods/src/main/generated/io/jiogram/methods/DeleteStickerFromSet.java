package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
 *
 * @param sticker File identifier of the sticker
 * @see <a href="https://core.telegram.org/bots/api#deletestickerfromset">deleteStickerFromSet in the Bot API</a>
 */
public record DeleteStickerFromSet(
    @JsonProperty("sticker") String sticker
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteStickerFromSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
