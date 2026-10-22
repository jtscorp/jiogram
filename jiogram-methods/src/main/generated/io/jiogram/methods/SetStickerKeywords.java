package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change search keywords assigned to a regular or custom emoji sticker. The
 * sticker must belong to a sticker set created by the bot. Returns True on success.
 *
 * @param sticker File identifier of the sticker
 * @param keywords A JSON-serialized list of 0-20 search keywords for the sticker with total length
 *     of up to 64 characters
 * @see <a href="https://core.telegram.org/bots/api#setstickerkeywords">setStickerKeywords in the Bot API</a>
 */
public record SetStickerKeywords(
    @JsonProperty("sticker") String sticker,
    @JsonProperty("keywords") @Nullable List<String> keywords
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerKeywords";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetStickerKeywords of(String sticker) {
        return new SetStickerKeywords(sticker, null);
    }
}
