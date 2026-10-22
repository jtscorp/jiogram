package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletestickerfromset">deleteStickerFromSet in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteStickerFromSet implements TelegramMethod<Boolean> {

    @JsonProperty("sticker")
    private final String sticker;

    /**
     * Creates a new {@code DeleteStickerFromSet} instance.
     *
     * @param sticker File identifier of the sticker
     */
    @JsonCreator
    public DeleteStickerFromSet(
            @JsonProperty("sticker") String sticker) {
        this.sticker = sticker;
    }

    @Override
    public String apiMethod() {
        return "deleteStickerFromSet";
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

    public DeleteStickerFromSet withSticker(String sticker) {
        return new DeleteStickerFromSet(sticker);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteStickerFromSet)) {
            return false;
        }
        DeleteStickerFromSet that = (DeleteStickerFromSet) o;
        return Objects.equals(this.sticker, that.sticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sticker);
    }

    @Override
    public String toString() {
        return "DeleteStickerFromSet[sticker=" + this.sticker
                + "]";
    }
}
