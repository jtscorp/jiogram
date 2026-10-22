package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to set the title of a created sticker set. Returns True on success.
 *
 * @param name Sticker set name
 * @param title Sticker set title, 1-64 characters
 * @see <a href="https://core.telegram.org/bots/api#setstickersettitle">setStickerSetTitle in the Bot API</a>
 */
public record SetStickerSetTitle(
    @JsonProperty("name") String name,
    @JsonProperty("title") String title
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerSetTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
