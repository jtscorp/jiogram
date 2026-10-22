package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.Sticker;
import io.jiogram.types.StickerType;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a sticker set.
 *
 * @see <a href="https://core.telegram.org/bots/api#stickerset">StickerSet in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StickerSet {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("sticker_type")
    private final StickerType stickerType;

    @JsonProperty("stickers")
    private final List<Sticker> stickers;

    @JsonProperty("thumbnail")
    private final @Nullable PhotoSize thumbnail;

    /**
     * Creates a new {@code StickerSet} instance.
     *
     * @param name Sticker set name
     * @param title Sticker set title
     * @param stickerType Type of stickers in the set, currently one of 'regular', 'mask',
     *     'custom_emoji'
     * @param stickers List of all set stickers
     * @param thumbnail Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
     */
    @JsonCreator
    public StickerSet(
            @JsonProperty("name") String name,
            @JsonProperty("title") String title,
            @JsonProperty("sticker_type") StickerType stickerType,
            @JsonProperty("stickers") List<Sticker> stickers,
            @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail) {
        this.name = name;
        this.title = title;
        this.stickerType = stickerType;
        this.stickers = stickers;
        this.thumbnail = thumbnail;
    }

    public static StickerSet of(String name, String title, StickerType stickerType, List<Sticker> stickers) {
        return new StickerSet(name, title, stickerType, stickers, null);
    }

    /**
     * Sticker set name
     */
    public String name() {
        return name;
    }

    /**
     * Sticker set title
     */
    public String title() {
        return title;
    }

    /**
     * Type of stickers in the set, currently one of 'regular', 'mask', 'custom_emoji'
     */
    public StickerType stickerType() {
        return stickerType;
    }

    /**
     * List of all set stickers
     */
    public List<Sticker> stickers() {
        return stickers;
    }

    /**
     * Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
     */
    public @Nullable PhotoSize thumbnail() {
        return thumbnail;
    }

    public StickerSet withName(String name) {
        return new StickerSet(name, title, stickerType, stickers, thumbnail);
    }

    public StickerSet withTitle(String title) {
        return new StickerSet(name, title, stickerType, stickers, thumbnail);
    }

    public StickerSet withStickerType(StickerType stickerType) {
        return new StickerSet(name, title, stickerType, stickers, thumbnail);
    }

    public StickerSet withStickers(List<Sticker> stickers) {
        return new StickerSet(name, title, stickerType, stickers, thumbnail);
    }

    public StickerSet withThumbnail(@Nullable PhotoSize thumbnail) {
        return new StickerSet(name, title, stickerType, stickers, thumbnail);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StickerSet)) {
            return false;
        }
        StickerSet that = (StickerSet) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.stickerType, that.stickerType)
                && Objects.equals(this.stickers, that.stickers)
                && Objects.equals(this.thumbnail, that.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.title, this.stickerType, this.stickers, this.thumbnail);
    }

    @Override
    public String toString() {
        return "StickerSet[name=" + this.name
                + ", title=" + this.title
                + ", stickerType=" + this.stickerType
                + ", stickers=" + this.stickers
                + ", thumbnail=" + this.thumbnail
                + "]";
    }
}
