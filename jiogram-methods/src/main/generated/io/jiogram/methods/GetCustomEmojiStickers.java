package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public class GetCustomEmojiStickers implements TelegramMethod<List<Sticker>> {
    @JsonProperty("custom_emoji_ids") private final List<String> customEmojiIds;

    @JsonCreator
    public GetCustomEmojiStickers(
            @JsonProperty("custom_emoji_ids") List<String> customEmojiIds
    ) {
        this.customEmojiIds = customEmojiIds;
    }

    public List<String> customEmojiIds() {
        return this.customEmojiIds;
    }

    @Override
    public String apiMethod() {
        return "getCustomEmojiStickers";
    }

    @Override
    public String apiReturnType() {
        return "Array of Sticker";
    }
}
