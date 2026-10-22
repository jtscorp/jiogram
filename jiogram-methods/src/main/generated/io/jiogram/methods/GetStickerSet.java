package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StickerSet;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to get a sticker set. On success, a StickerSet object is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#getstickerset">getStickerSet in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetStickerSet implements TelegramMethod<StickerSet> {

    @JsonProperty("name")
    private final String name;

    /**
     * Creates a new {@code GetStickerSet} instance.
     *
     * @param name Name of the sticker set
     */
    @JsonCreator
    public GetStickerSet(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    @Override
    public String apiMethod() {
        return "getStickerSet";
    }

    @Override
    public String apiReturnType() {
        return "StickerSet";
    }

    /**
     * Name of the sticker set
     */
    public String name() {
        return name;
    }

    public GetStickerSet withName(String name) {
        return new GetStickerSet(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetStickerSet)) {
            return false;
        }
        GetStickerSet that = (GetStickerSet) o;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return "GetStickerSet[name=" + this.name
                + "]";
    }
}
