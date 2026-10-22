package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaskPosition;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the mask position of a mask sticker. The sticker must belong to a
 * sticker set that was created by the bot. Returns True on success.
 *
 * @param sticker File identifier of the sticker
 * @param maskPosition A JSON-serialized object with the position where the mask should be placed on
 *     faces. Omit the parameter to remove the mask position.
 * @see <a href="https://core.telegram.org/bots/api#setstickermaskposition">setStickerMaskPosition in the Bot API</a>
 */
public record SetStickerMaskPosition(
    @JsonProperty("sticker") String sticker,
    @JsonProperty("mask_position") @Nullable MaskPosition maskPosition
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerMaskPosition";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetStickerMaskPosition of(String sticker) {
        return new SetStickerMaskPosition(sticker, null);
    }
}
