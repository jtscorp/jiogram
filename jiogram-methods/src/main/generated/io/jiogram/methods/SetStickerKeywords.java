package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to change search keywords assigned to a regular or custom emoji sticker. The
 * sticker must belong to a sticker set created by the bot. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setstickerkeywords">setStickerKeywords in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetStickerKeywords implements TelegramMethod<Boolean> {

    @JsonProperty("sticker")
    private final String sticker;

    @JsonProperty("keywords")
    private final @Nullable List<String> keywords;

    /**
     * Creates a new {@code SetStickerKeywords} instance.
     *
     * @param sticker File identifier of the sticker
     * @param keywords A JSON-serialized list of 0-20 search keywords for the sticker with total
     *     length of up to 64 characters
     */
    @JsonCreator
    public SetStickerKeywords(
            @JsonProperty("sticker") String sticker,
            @JsonProperty("keywords") @Nullable List<String> keywords) {
        this.sticker = sticker;
        this.keywords = keywords;
    }

    @Override
    public String apiMethod() {
        return "setStickerKeywords";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetStickerKeywords of(String sticker) {
        return new SetStickerKeywords(sticker, null);
    }

    /**
     * File identifier of the sticker
     */
    public String sticker() {
        return sticker;
    }

    /**
     * A JSON-serialized list of 0-20 search keywords for the sticker with total length of up to 64
     * characters
     */
    public @Nullable List<String> keywords() {
        return keywords;
    }

    public SetStickerKeywords withSticker(String sticker) {
        return new SetStickerKeywords(sticker, keywords);
    }

    public SetStickerKeywords withKeywords(@Nullable List<String> keywords) {
        return new SetStickerKeywords(sticker, keywords);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetStickerKeywords)) {
            return false;
        }
        SetStickerKeywords that = (SetStickerKeywords) o;
        return Objects.equals(this.sticker, that.sticker)
                && Objects.equals(this.keywords, that.keywords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sticker, this.keywords);
    }

    @Override
    public String toString() {
        return "SetStickerKeywords[sticker=" + this.sticker
                + ", keywords=" + this.keywords
                + "]";
    }
}
