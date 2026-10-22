package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to add a new sticker to a set created by the bot. Emoji sticker sets can have up
 * to 200 stickers. Other sticker sets can have up to 120 stickers. Returns True on success.
 *
 * @param userId User identifier of sticker set owner
 * @param name Sticker set name
 * @param sticker A JSON-serialized object with information about the added sticker. If exactly the
 *     same sticker had already been added to the set, then the set isn't changed.
 * @see <a href="https://core.telegram.org/bots/api#addstickertoset">addStickerToSet in the Bot API</a>
 */
public record AddStickerToSet(
    @JsonProperty("user_id") long userId,
    @JsonProperty("name") String name,
    @JsonProperty("sticker") InputSticker sticker
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "addStickerToSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
