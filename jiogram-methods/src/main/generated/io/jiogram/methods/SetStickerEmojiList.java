package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;

/**
 * Use this method to change the list of emoji assigned to a regular or custom emoji sticker. The
 * sticker must belong to a sticker set created by the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickeremojilist">setStickerEmojiList in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetStickerEmojiList implements TelegramMethod<Boolean> {

    @JsonProperty("sticker")
    private final String sticker;

    @JsonProperty("emoji_list")
    private final List<String> emojiList;

    /**
     * Creates a new {@code SetStickerEmojiList} instance.
     *
     * @param sticker File identifier of the sticker
     * @param emojiList A JSON-serialized list of 1-20 emoji associated with the sticker
     */
    @JsonCreator
    public SetStickerEmojiList(
            @JsonProperty("sticker") String sticker,
            @JsonProperty("emoji_list") List<String> emojiList) {
        this.sticker = sticker;
        this.emojiList = emojiList;
    }

    @Override
    public String apiMethod() {
        return "setStickerEmojiList";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * File identifier of the sticker
     */
    public String sticker() {
        return sticker;
    }

    /**
     * A JSON-serialized list of 1-20 emoji associated with the sticker
     */
    public List<String> emojiList() {
        return emojiList;
    }

    public SetStickerEmojiList withSticker(String sticker) {
        return new SetStickerEmojiList(sticker, emojiList);
    }

    public SetStickerEmojiList withEmojiList(List<String> emojiList) {
        return new SetStickerEmojiList(sticker, emojiList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetStickerEmojiList)) {
            return false;
        }
        SetStickerEmojiList that = (SetStickerEmojiList) o;
        return Objects.equals(this.sticker, that.sticker)
                && Objects.equals(this.emojiList, that.emojiList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sticker, this.emojiList);
    }

    @Override
    public String toString() {
        return "SetStickerEmojiList[sticker=" + this.sticker
                + ", emojiList=" + this.emojiList
                + "]";
    }
}
