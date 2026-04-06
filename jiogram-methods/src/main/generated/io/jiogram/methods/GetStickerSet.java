package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StickerSet;
import io.jiogram.types.TelegramMethod;

public record GetStickerSet(
    @JsonProperty("name") String name
) implements TelegramMethod<StickerSet> {

    @Override
    public String apiMethod() {
        return "getStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "StickerSet";
    }
}
