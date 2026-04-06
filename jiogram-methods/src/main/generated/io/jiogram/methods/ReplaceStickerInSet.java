package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.TelegramMethod;

public record ReplaceStickerInSet(
    @JsonProperty("user_id") long userId,
    @JsonProperty("name") String name,
    @JsonProperty("old_sticker") String oldSticker,
    @JsonProperty("sticker") InputSticker sticker
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "replaceStickerInSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
