package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaskPosition;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetStickerMaskPosition implements TelegramMethod<Boolean> {
    @JsonProperty("sticker") private final String sticker;
    @JsonProperty("mask_position") @Nullable private final MaskPosition maskPosition;

    @JsonCreator
    public SetStickerMaskPosition(
            @JsonProperty("sticker") String sticker,
            @JsonProperty("mask_position") @Nullable MaskPosition maskPosition
    ) {
        this.sticker = sticker;
        this.maskPosition = maskPosition;
    }

    public String sticker() {
        return this.sticker;
    }

    public MaskPosition maskPosition() {
        return this.maskPosition;
    }

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
