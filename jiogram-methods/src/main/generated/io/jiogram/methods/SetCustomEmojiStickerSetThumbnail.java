package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to set the thumbnail of a custom emoji sticker set. Returns True on success.
 *
 * @param name Sticker set name
 * @param customEmojiId Custom emoji identifier of a sticker from the sticker set; pass an empty
 *     string to drop the thumbnail and use the first sticker as the thumbnail.
 * @see <a href="https://core.telegram.org/bots/api#setcustomemojistickersetthumbnail">setCustomEmojiStickerSetThumbnail in the Bot API</a>
 */
public record SetCustomEmojiStickerSetThumbnail(
    @JsonProperty("name") String name,
    @JsonProperty("custom_emoji_id") @Nullable String customEmojiId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setCustomEmojiStickerSetThumbnail";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetCustomEmojiStickerSetThumbnail of(String name) {
        return new SetCustomEmojiStickerSetThumbnail(name, null);
    }
}
