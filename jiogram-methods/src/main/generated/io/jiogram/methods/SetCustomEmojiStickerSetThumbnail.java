package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to set the thumbnail of a custom emoji sticker set. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#setcustomemojistickersetthumbnail">setCustomEmojiStickerSetThumbnail in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SetCustomEmojiStickerSetThumbnail implements TelegramMethod<Boolean> {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("custom_emoji_id")
    private final @Nullable String customEmojiId;

    /**
     * Creates a new {@code SetCustomEmojiStickerSetThumbnail} instance.
     *
     * @param name Sticker set name
     * @param customEmojiId Custom emoji identifier of a sticker from the sticker set; pass an empty
     *     string to drop the thumbnail and use the first sticker as the thumbnail.
     */
    @JsonCreator
    public SetCustomEmojiStickerSetThumbnail(
            @JsonProperty("name") String name,
            @JsonProperty("custom_emoji_id") @Nullable String customEmojiId) {
        this.name = name;
        this.customEmojiId = customEmojiId;
    }

    @Override
    public String apiMethod() {
        return "setCustomEmojiStickerSetThumbnail";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetCustomEmojiStickerSetThumbnail of(String name) {
        return new SetCustomEmojiStickerSetThumbnail(name, null);
    }

    /**
     * Sticker set name
     */
    public String name() {
        return name;
    }

    /**
     * Custom emoji identifier of a sticker from the sticker set; pass an empty string to drop the
     * thumbnail and use the first sticker as the thumbnail.
     */
    public @Nullable String customEmojiId() {
        return customEmojiId;
    }

    public SetCustomEmojiStickerSetThumbnail withName(String name) {
        return new SetCustomEmojiStickerSetThumbnail(name, customEmojiId);
    }

    public SetCustomEmojiStickerSetThumbnail withCustomEmojiId(@Nullable String customEmojiId) {
        return new SetCustomEmojiStickerSetThumbnail(name, customEmojiId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SetCustomEmojiStickerSetThumbnail)) {
            return false;
        }
        SetCustomEmojiStickerSetThumbnail that = (SetCustomEmojiStickerSetThumbnail) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.customEmojiId, that.customEmojiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.customEmojiId);
    }

    @Override
    public String toString() {
        return "SetCustomEmojiStickerSetThumbnail[name=" + this.name
                + ", customEmojiId=" + this.customEmojiId
                + "]";
    }
}
