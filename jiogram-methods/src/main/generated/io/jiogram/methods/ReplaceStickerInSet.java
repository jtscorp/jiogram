package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to replace an existing sticker in a sticker set with a new one. The method is
 * equivalent to calling deleteStickerFromSet, then addStickerToSet, then setStickerPositionInSet.
 * Returns True on success.
 *
 * @param userId User identifier of the sticker set owner
 * @param name Sticker set name
 * @param oldSticker File identifier of the replaced sticker
 * @param sticker A JSON-serialized object with information about the added sticker. If exactly the
 *     same sticker had already been added to the set, then the set remains unchanged.
 * @see <a href="https://core.telegram.org/bots/api#replacestickerinset">replaceStickerInSet in the Bot API</a>
 */
public record ReplaceStickerInSet(
    @JsonProperty("user_id") long userId,
    @JsonProperty("name") String name,
    @JsonProperty("old_sticker") String oldSticker,
    @JsonProperty("sticker") InputSticker sticker
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "replaceStickerInSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
