package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaskPosition;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change the mask position of a mask sticker. The sticker must belong to a
 * sticker set that was created by the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickermaskposition">setStickerMaskPosition in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetStickerMaskPosition implements TelegramMethod<Boolean> {

    @JsonProperty("sticker")
    private final String sticker;

    @JsonProperty("mask_position")
    private final @Nullable MaskPosition maskPosition;

    /**
     * Creates a new {@code SetStickerMaskPosition} instance.
     *
     * @param sticker File identifier of the sticker
     * @param maskPosition A JSON-serialized object with the position where the mask should be
     *     placed on faces. Omit the parameter to remove the mask position.
     */
    @JsonCreator
    public SetStickerMaskPosition(
            @JsonProperty("sticker") String sticker,
            @JsonProperty("mask_position") @Nullable MaskPosition maskPosition) {
        this.sticker = sticker;
        this.maskPosition = maskPosition;
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

    /**
     * File identifier of the sticker
     */
    public String sticker() {
        return sticker;
    }

    /**
     * A JSON-serialized object with the position where the mask should be placed on faces. Omit the
     * parameter to remove the mask position.
     */
    public @Nullable MaskPosition maskPosition() {
        return maskPosition;
    }

    public SetStickerMaskPosition withSticker(String sticker) {
        return new SetStickerMaskPosition(sticker, maskPosition);
    }

    public SetStickerMaskPosition withMaskPosition(@Nullable MaskPosition maskPosition) {
        return new SetStickerMaskPosition(sticker, maskPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetStickerMaskPosition)) {
            return false;
        }
        SetStickerMaskPosition that = (SetStickerMaskPosition) o;
        return Objects.equals(this.sticker, that.sticker)
                && Objects.equals(this.maskPosition, that.maskPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sticker, this.maskPosition);
    }

    @Override
    public String toString() {
        return "SetStickerMaskPosition[sticker=" + this.sticker
                + ", maskPosition=" + this.maskPosition
                + "]";
    }
}
