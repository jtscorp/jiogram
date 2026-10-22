package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.MaskPosition;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.StickerType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a sticker.
 *
 * @see <a href="https://core.telegram.org/bots/api#sticker">Sticker in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Sticker {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("type")
    private final StickerType type;

    @JsonProperty("width")
    private final long width;

    @JsonProperty("height")
    private final long height;

    @JsonProperty("is_animated")
    private final boolean isAnimated;

    @JsonProperty("is_video")
    private final boolean isVideo;

    @JsonProperty("thumbnail")
    private final @Nullable PhotoSize thumbnail;

    @JsonProperty("emoji")
    private final @Nullable String emoji;

    @JsonProperty("set_name")
    private final @Nullable String setName;

    @JsonProperty("premium_animation")
    private final @Nullable File premiumAnimation;

    @JsonProperty("mask_position")
    private final @Nullable MaskPosition maskPosition;

    @JsonProperty("custom_emoji_id")
    private final @Nullable String customEmojiId;

    @JsonProperty("needs_repainting")
    private final @Nullable Boolean needsRepainting;

    @JsonProperty("file_size")
    private final @Nullable Long fileSize;

    /**
     * Creates a new {@code Sticker} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param type Type of the sticker, currently one of 'regular', 'mask', 'custom_emoji'. The type
     *     of the sticker is independent from its format, which is determined by the fields
     *     is_animated and is_video.
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
     * @param needsRepainting True, if the sticker must be repainted to a text color in messages,
     *     the color of the Telegram Premium badge in emoji status, white color on chat photos, or
     *     another appropriate color in other places
     * @param fileSize File size in bytes
     */
    @JsonCreator
    public Sticker(
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
            @JsonProperty("file_size") @Nullable Long fileSize) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.type = type;
        this.width = width;
        this.height = height;
        this.isAnimated = isAnimated;
        this.isVideo = isVideo;
        this.thumbnail = thumbnail;
        this.emoji = emoji;
        this.setName = setName;
        this.premiumAnimation = premiumAnimation;
        this.maskPosition = maskPosition;
        this.customEmojiId = customEmojiId;
        this.needsRepainting = needsRepainting;
        this.fileSize = fileSize;
    }

    public static Sticker of(String fileId, String fileUniqueId, StickerType type, long width, long height, boolean isAnimated, boolean isVideo) {
        return new Sticker(fileId, fileUniqueId, type, width, height, isAnimated, isVideo, null, null, null, null, null, null, null, null);
    }

    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    public String fileId() {
        return fileId;
    }

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different
     * bots. Can't be used to download or reuse the file.
     */
    public String fileUniqueId() {
        return fileUniqueId;
    }

    /**
     * Type of the sticker, currently one of 'regular', 'mask', 'custom_emoji'. The type of the
     * sticker is independent from its format, which is determined by the fields is_animated and
     * is_video.
     */
    public StickerType type() {
        return type;
    }

    /**
     * Sticker width
     */
    public long width() {
        return width;
    }

    /**
     * Sticker height
     */
    public long height() {
        return height;
    }

    /**
     * True, if the sticker is animated
     */
    public boolean isAnimated() {
        return isAnimated;
    }

    /**
     * True, if the sticker is a video sticker
     */
    public boolean isVideo() {
        return isVideo;
    }

    /**
     * Sticker thumbnail in the .WEBP or .JPG format
     */
    public @Nullable PhotoSize thumbnail() {
        return thumbnail;
    }

    /**
     * Emoji associated with the sticker
     */
    public @Nullable String emoji() {
        return emoji;
    }

    /**
     * Name of the sticker set to which the sticker belongs
     */
    public @Nullable String setName() {
        return setName;
    }

    /**
     * For premium regular stickers, premium animation for the sticker
     */
    public @Nullable File premiumAnimation() {
        return premiumAnimation;
    }

    /**
     * For mask stickers, the position where the mask should be placed
     */
    public @Nullable MaskPosition maskPosition() {
        return maskPosition;
    }

    /**
     * For custom emoji stickers, unique identifier of the custom emoji
     */
    public @Nullable String customEmojiId() {
        return customEmojiId;
    }

    /**
     * True, if the sticker must be repainted to a text color in messages, the color of the Telegram
     * Premium badge in emoji status, white color on chat photos, or another appropriate color in
     * other places
     */
    public @Nullable Boolean needsRepainting() {
        return needsRepainting;
    }

    /**
     * File size in bytes
     */
    public @Nullable Long fileSize() {
        return fileSize;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sticker)) {
            return false;
        }
        Sticker that = (Sticker) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && Objects.equals(this.type, that.type)
                && this.width == that.width
                && this.height == that.height
                && this.isAnimated == that.isAnimated
                && this.isVideo == that.isVideo
                && Objects.equals(this.thumbnail, that.thumbnail)
                && Objects.equals(this.emoji, that.emoji)
                && Objects.equals(this.setName, that.setName)
                && Objects.equals(this.premiumAnimation, that.premiumAnimation)
                && Objects.equals(this.maskPosition, that.maskPosition)
                && Objects.equals(this.customEmojiId, that.customEmojiId)
                && Objects.equals(this.needsRepainting, that.needsRepainting)
                && Objects.equals(this.fileSize, that.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.type, this.width, this.height, this.isAnimated, this.isVideo, this.thumbnail, this.emoji, this.setName, this.premiumAnimation, this.maskPosition, this.customEmojiId, this.needsRepainting, this.fileSize);
    }

    @Override
    public String toString() {
        return "Sticker[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", type=" + this.type
                + ", width=" + this.width
                + ", height=" + this.height
                + ", isAnimated=" + this.isAnimated
                + ", isVideo=" + this.isVideo
                + ", thumbnail=" + this.thumbnail
                + ", emoji=" + this.emoji
                + ", setName=" + this.setName
                + ", premiumAnimation=" + this.premiumAnimation
                + ", maskPosition=" + this.maskPosition
                + ", customEmojiId=" + this.customEmojiId
                + ", needsRepainting=" + this.needsRepainting
                + ", fileSize=" + this.fileSize
                + "]";
    }
}
