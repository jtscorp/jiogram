package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.MaskPosition;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.StickerType;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a sticker.
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param type Type of the sticker, currently one of 'regular', 'mask', 'custom_emoji'. The type of
 *     the sticker is independent from its format, which is determined by the fields is_animated and
 *     is_video.
 * @param width Sticker width
 * @param height Sticker height
 * @param isAnimated True, if the sticker is animated
 * @param isVideo True, if the sticker is a video sticker
 * @param thumbnail Sticker thumbnail in the .WEBP or .JPG format
 * @param emoji Emoji associated with the sticker
 * @param setName Name of the sticker set to which the sticker belongs
 * @param premiumAnimation For premium regular stickers, premium animation for the sticker
 * @param maskPosition For mask stickers, the position where the mask should be placed
 * @param customEmojiId For custom emoji stickers, unique identifier of the custom emoji
 * @param needsRepainting True, if the sticker must be repainted to a text color in messages, the
 *     color of the Telegram Premium badge in emoji status, white color on chat photos, or another
 *     appropriate color in other places
 * @param fileSize File size in bytes
 * @see <a href="https://core.telegram.org/bots/api#sticker">Sticker in the Bot API</a>
 */
public record Sticker(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("type") StickerType type,
    @JsonProperty("width") long width,
    @JsonProperty("height") long height,
    @JsonProperty("is_animated") boolean isAnimated,
    @JsonProperty("is_video") boolean isVideo,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
    @JsonProperty("emoji") @Nullable String emoji,
    @JsonProperty("set_name") @Nullable String setName,
    @JsonProperty("premium_animation") @Nullable File premiumAnimation,
    @JsonProperty("mask_position") @Nullable MaskPosition maskPosition,
    @JsonProperty("custom_emoji_id") @Nullable String customEmojiId,
    @JsonProperty("needs_repainting") @Nullable Boolean needsRepainting,
    @JsonProperty("file_size") @Nullable Long fileSize
) {

    public Sticker withFileId(String fileId) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withFileUniqueId(String fileUniqueId) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withType(StickerType type) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withWidth(long width) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withHeight(long height) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withIsAnimated(boolean isAnimated) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withIsVideo(boolean isVideo) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withThumbnail(@Nullable PhotoSize thumbnail) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withEmoji(@Nullable String emoji) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withSetName(@Nullable String setName) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withPremiumAnimation(@Nullable File premiumAnimation) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withMaskPosition(@Nullable MaskPosition maskPosition) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withCustomEmojiId(@Nullable String customEmojiId) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withNeedsRepainting(@Nullable Boolean needsRepainting) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }

    public Sticker withFileSize(@Nullable Long fileSize) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, thumbnail, emoji, setName, premiumAnimation, maskPosition, customEmojiId, needsRepainting, fileSize);
    }
}
