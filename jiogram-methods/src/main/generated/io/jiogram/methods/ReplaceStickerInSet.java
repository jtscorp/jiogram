package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to replace an existing sticker in a sticker set with a new one. The method is
 * equivalent to calling deleteStickerFromSet, then addStickerToSet, then setStickerPositionInSet.
 * Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#replacestickerinset">replaceStickerInSet in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReplaceStickerInSet implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("old_sticker")
    private final String oldSticker;

    @JsonProperty("sticker")
    private final InputSticker sticker;

    /**
     * Creates a new {@code ReplaceStickerInSet} instance.
     *
     * @param userId User identifier of the sticker set owner
     * @param name Sticker set name
     * @param oldSticker File identifier of the replaced sticker
     * @param sticker A JSON-serialized object with information about the added sticker. If exactly
     *     the same sticker had already been added to the set, then the set remains unchanged.
     */
    @JsonCreator
    public ReplaceStickerInSet(
            @JsonProperty("user_id") long userId,
            @JsonProperty("name") String name,
            @JsonProperty("old_sticker") String oldSticker,
            @JsonProperty("sticker") InputSticker sticker) {
        this.userId = userId;
        this.name = name;
        this.oldSticker = oldSticker;
        this.sticker = sticker;
    }

    @Override
    public String apiMethod() {
        return "replaceStickerInSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * User identifier of the sticker set owner
     */
    public long userId() {
        return userId;
    }

    /**
     * Sticker set name
     */
    public String name() {
        return name;
    }

    /**
     * File identifier of the replaced sticker
     */
    public String oldSticker() {
        return oldSticker;
    }

    /**
     * A JSON-serialized object with information about the added sticker. If exactly the same
     * sticker had already been added to the set, then the set remains unchanged.
     */
    public InputSticker sticker() {
        return sticker;
    }

    public ReplaceStickerInSet withUserId(long userId) {
        return new ReplaceStickerInSet(userId, name, oldSticker, sticker);
    }

    public ReplaceStickerInSet withName(String name) {
        return new ReplaceStickerInSet(userId, name, oldSticker, sticker);
    }

    public ReplaceStickerInSet withOldSticker(String oldSticker) {
        return new ReplaceStickerInSet(userId, name, oldSticker, sticker);
    }

    public ReplaceStickerInSet withSticker(InputSticker sticker) {
        return new ReplaceStickerInSet(userId, name, oldSticker, sticker);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReplaceStickerInSet)) {
            return false;
        }
        ReplaceStickerInSet that = (ReplaceStickerInSet) o;
        return this.userId == that.userId
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.oldSticker, that.oldSticker)
                && Objects.equals(this.sticker, that.sticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.name, this.oldSticker, this.sticker);
    }

    @Override
    public String toString() {
        return "ReplaceStickerInSet[userId=" + this.userId
                + ", name=" + this.name
                + ", oldSticker=" + this.oldSticker
                + ", sticker=" + this.sticker
                + "]";
    }
}
