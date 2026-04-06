package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import io.jiogram.types.TelegramMethod;
import java.util.List;

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
}
