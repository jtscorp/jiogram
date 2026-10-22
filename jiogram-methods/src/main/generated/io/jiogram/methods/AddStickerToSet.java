package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputSticker;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Use this method to add a new sticker to a set created by the bot. Emoji sticker sets can have up
 * to 200 stickers. Other sticker sets can have up to 120 stickers. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#addstickertoset">addStickerToSet in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class AddStickerToSet implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("sticker")
    private final InputSticker sticker;

    /**
     * Creates a new {@code AddStickerToSet} instance.
     *
     * @param userId User identifier of sticker set owner
     * @param name Sticker set name
     * @param sticker A JSON-serialized object with information about the added sticker. If exactly
     *     the same sticker had already been added to the set, then the set isn't changed.
     */
    @JsonCreator
    public AddStickerToSet(
            @JsonProperty("user_id") long userId,
            @JsonProperty("name") String name,
            @JsonProperty("sticker") InputSticker sticker) {
        this.userId = userId;
        this.name = name;
        this.sticker = sticker;
    }

    @Override
    public String apiMethod() {
        return "addStickerToSet";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * User identifier of sticker set owner
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
     * A JSON-serialized object with information about the added sticker. If exactly the same
     * sticker had already been added to the set, then the set isn't changed.
     */
    public InputSticker sticker() {
        return sticker;
    }

    public AddStickerToSet withUserId(long userId) {
        return new AddStickerToSet(userId, name, sticker);
    }

    public AddStickerToSet withName(String name) {
        return new AddStickerToSet(userId, name, sticker);
    }

    public AddStickerToSet withSticker(InputSticker sticker) {
        return new AddStickerToSet(userId, name, sticker);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AddStickerToSet)) {
            return false;
        }
        AddStickerToSet that = (AddStickerToSet) o;
        return this.userId == that.userId
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.sticker, that.sticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.name, this.sticker);
    }

    @Override
    public String toString() {
        return "AddStickerToSet[userId=" + this.userId
                + ", name=" + this.name
                + ", sticker=" + this.sticker
                + "]";
    }
}
