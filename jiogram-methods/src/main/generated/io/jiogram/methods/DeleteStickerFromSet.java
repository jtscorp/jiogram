package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class DeleteStickerFromSet implements TelegramMethod<Boolean> {
    @JsonProperty("sticker") private final String sticker;

    @JsonCreator
    public DeleteStickerFromSet(
            @JsonProperty("sticker") String sticker
    ) {
        this.sticker = sticker;
    }

    public String sticker() {
        return this.sticker;
    }

    @Override
    public String apiMethod() {
        return "deleteStickerFromSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
