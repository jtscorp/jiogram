package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;

/**
 * Use this method to get information about custom emoji stickers by their identifiers. Returns an
 * Array of Sticker objects.
 *
 * @see <a href="https://core.telegram.org/bots/api#getcustomemojistickers">getCustomEmojiStickers in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GetCustomEmojiStickers implements TelegramMethod<List<Sticker>> {

    @JsonProperty("custom_emoji_ids")
    private final List<String> customEmojiIds;

    /**
     * Creates a new {@code GetCustomEmojiStickers} instance.
     *
     * @param customEmojiIds A JSON-serialized list of custom emoji identifiers. At most 200 custom
     *     emoji identifiers can be specified.
     */
    @JsonCreator
    public GetCustomEmojiStickers(
            @JsonProperty("custom_emoji_ids") List<String> customEmojiIds) {
        this.customEmojiIds = customEmojiIds;
    }

    @Override
    public String apiMethod() {
        return "getCustomEmojiStickers";
    }

    @Override
    public String apiReturnType() {
        return "Array of Sticker";
    }

    /**
     * A JSON-serialized list of custom emoji identifiers. At most 200 custom emoji identifiers can
     * be specified.
     */
    public List<String> customEmojiIds() {
        return customEmojiIds;
    }

    public GetCustomEmojiStickers withCustomEmojiIds(List<String> customEmojiIds) {
        return new GetCustomEmojiStickers(customEmojiIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetCustomEmojiStickers)) {
            return false;
        }
        GetCustomEmojiStickers that = (GetCustomEmojiStickers) o;
        return Objects.equals(this.customEmojiIds, that.customEmojiIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.customEmojiIds);
    }

    @Override
    public String toString() {
        return "GetCustomEmojiStickers[customEmojiIds=" + this.customEmojiIds
                + "]";
    }
}
