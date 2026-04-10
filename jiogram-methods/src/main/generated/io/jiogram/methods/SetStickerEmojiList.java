package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public class SetStickerEmojiList implements TelegramMethod<Boolean> {
    @JsonProperty("sticker") private final String sticker;
    @JsonProperty("emoji_list") private final List<String> emojiList;

    @JsonCreator
    public SetStickerEmojiList(
            @JsonProperty("sticker") String sticker,
            @JsonProperty("emoji_list") List<String> emojiList
    ) {
        this.sticker = sticker;
        this.emojiList = emojiList;
    }

    public String sticker() {
        return this.sticker;
    }

    public List<String> emojiList() {
        return this.emojiList;
    }

    @Override
    public String apiMethod() {
        return "setStickerEmojiList";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
