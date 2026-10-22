package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to move a sticker in a set created by the bot to a specific position. Returns
 * True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickerpositioninset">setStickerPositionInSet in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetStickerPositionInSet implements TelegramMethod<Boolean> {

    @JsonProperty("sticker")
    private final String sticker;

    @JsonProperty("position")
    private final long position;

    /**
     * Creates a new {@code SetStickerPositionInSet} instance.
     *
     * @param sticker File identifier of the sticker
     * @param position New sticker position in the set, zero-based
     */
    @JsonCreator
    public SetStickerPositionInSet(
            @JsonProperty("sticker") String sticker,
            @JsonProperty("position") long position) {
        this.sticker = sticker;
        this.position = position;
    }

    @Override
    public String apiMethod() {
        return "setStickerPositionInSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * File identifier of the sticker
     */
    public String sticker() {
        return sticker;
    }

    /**
     * New sticker position in the set, zero-based
     */
    public long position() {
        return position;
    }

    public SetStickerPositionInSet withSticker(String sticker) {
        return new SetStickerPositionInSet(sticker, position);
    }

    public SetStickerPositionInSet withPosition(long position) {
        return new SetStickerPositionInSet(sticker, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetStickerPositionInSet)) {
            return false;
        }
        SetStickerPositionInSet that = (SetStickerPositionInSet) o;
        return Objects.equals(this.sticker, that.sticker)
                && this.position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sticker, this.position);
    }

    @Override
    public String toString() {
        return "SetStickerPositionInSet[sticker=" + this.sticker
                + ", position=" + this.position
                + "]";
    }
}
