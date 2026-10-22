package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;

/**
 * Use this method to change the list of emoji assigned to a regular or custom emoji sticker. The
 * sticker must belong to a sticker set created by the bot. Returns True on success.
 *
 * @param sticker File identifier of the sticker
 * @param emojiList A JSON-serialized list of 1-20 emoji associated with the sticker
 * @see <a href="https://core.telegram.org/bots/api#setstickeremojilist">setStickerEmojiList in the Bot API</a>
 */
public record SetStickerEmojiList(
    @JsonProperty("sticker") String sticker,
    @JsonProperty("emoji_list") List<String> emojiList
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerEmojiList";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public SetStickerEmojiList withSticker(String sticker) {
        return new SetStickerEmojiList(sticker, emojiList);
    }

    public SetStickerEmojiList withEmojiList(List<String> emojiList) {
        return new SetStickerEmojiList(sticker, emojiList);
    }
}
