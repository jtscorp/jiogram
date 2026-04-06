package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record DeleteStickerFromSet(
    @JsonProperty("sticker") String sticker
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteStickerFromSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
