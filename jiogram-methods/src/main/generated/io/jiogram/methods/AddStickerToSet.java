package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.TelegramMethod;

public record AddStickerToSet(
    @JsonProperty("user_id") long userId,
    @JsonProperty("name") String name,
    @JsonProperty("sticker") InputSticker sticker
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "addStickerToSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
