package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record SetStickerPositionInSet(
    @JsonProperty("sticker") String sticker,
    @JsonProperty("position") long position
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerPositionInSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
