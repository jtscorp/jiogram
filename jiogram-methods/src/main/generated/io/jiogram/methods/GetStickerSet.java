package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StickerSet;
import io.jiogram.types.TelegramMethod;

/**
 * Use this method to get a sticker set. On success, a StickerSet object is returned.
 *
 * @param name Name of the sticker set
 * @see <a href="https://core.telegram.org/bots/api#getstickerset">getStickerSet in the Bot API</a>
 */
public record GetStickerSet(
    @JsonProperty("name") String name
) implements TelegramMethod<StickerSet> {

    @Override
    public String apiMethod() {
        return "getStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "StickerSet";
    }

    public GetStickerSet withName(String name) {
        return new GetStickerSet(name);
    }
}
