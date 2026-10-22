package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to move a sticker in a set created by the bot to a specific position. Returns
 * True on success.
 *
 * @param sticker File identifier of the sticker
 * @param position New sticker position in the set, zero-based
 * @see <a href="https://core.telegram.org/bots/api#setstickerpositioninset">setStickerPositionInSet in the Bot API</a>
 */
public record SetStickerPositionInSet(
    @JsonProperty("sticker") String sticker,
    @JsonProperty("position") long position
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerPositionInSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
