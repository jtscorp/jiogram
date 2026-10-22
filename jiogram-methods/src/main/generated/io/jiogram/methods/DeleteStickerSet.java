package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to delete a sticker set that was created by the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#deletestickerset">deleteStickerSet in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class DeleteStickerSet implements TelegramMethod<Boolean> {

    @JsonProperty("name")
    private final String name;

    /**
     * Creates a new {@code DeleteStickerSet} instance.
     *
     * @param name Sticker set name
     */
    @JsonCreator
    public DeleteStickerSet(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    @Override
    public String apiMethod() {
        return "deleteStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Sticker set name
     */
    public String name() {
        return name;
    }

    public DeleteStickerSet withName(String name) {
        return new DeleteStickerSet(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeleteStickerSet)) {
            return false;
        }
        DeleteStickerSet that = (DeleteStickerSet) o;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return "DeleteStickerSet[name=" + this.name
                + "]";
    }
}
