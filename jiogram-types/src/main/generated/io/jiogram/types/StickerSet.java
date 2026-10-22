package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.Sticker;
import io.jiogram.types.StickerType;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a sticker set.
 *
 * @param name Sticker set name
 * @param title Sticker set title
 * @param stickerType Type of stickers in the set, currently one of 'regular', 'mask',
 *     'custom_emoji'
 * @param stickers List of all set stickers
 * @param thumbnail Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
 * @see <a href="https://core.telegram.org/bots/api#stickerset">StickerSet in the Bot API</a>
 */
public record StickerSet(
    @JsonProperty("name") String name,
    @JsonProperty("title") String title,
    @JsonProperty("sticker_type") StickerType stickerType,
    @JsonProperty("stickers") List<Sticker> stickers,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail
) {

    public static StickerSet of(String name, String title, StickerType stickerType, List<Sticker> stickers) {
        return new StickerSet(name, title, stickerType, stickers, null);
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
}
