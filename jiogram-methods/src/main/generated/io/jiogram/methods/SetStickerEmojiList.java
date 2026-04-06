package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;

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
}
