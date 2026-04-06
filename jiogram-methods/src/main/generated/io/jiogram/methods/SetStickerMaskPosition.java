package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaskPosition;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetStickerMaskPosition(
    @JsonProperty("sticker") String sticker,
    @JsonProperty("mask_position") @Nullable MaskPosition maskPosition
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setStickerMaskPosition";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetStickerMaskPosition of(String sticker) {
        return new SetStickerMaskPosition(sticker, null);
    }
}
