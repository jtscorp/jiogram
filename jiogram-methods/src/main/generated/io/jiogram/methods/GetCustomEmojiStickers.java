package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import io.jiogram.types.TelegramMethod;
import java.util.List;

/**
 * Use this method to get information about custom emoji stickers by their identifiers. Returns an
 * Array of Sticker objects.
 *
 * @param customEmojiIds A JSON-serialized list of custom emoji identifiers. At most 200 custom
 *     emoji identifiers can be specified.
 * @see <a href="https://core.telegram.org/bots/api#getcustomemojistickers">getCustomEmojiStickers in the Bot API</a>
 */
public record GetCustomEmojiStickers(
    @JsonProperty("custom_emoji_ids") List<String> customEmojiIds
) implements TelegramMethod<List<Sticker>> {

    @Override
    public String apiMethod() {
        return "getCustomEmojiStickers";
    }

    @Override
    public String apiReturnType() {
        return "Array of Sticker";
    }

    public GetCustomEmojiStickers withCustomEmojiIds(List<String> customEmojiIds) {
        return new GetCustomEmojiStickers(customEmojiIds);
    }
}
