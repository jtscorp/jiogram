package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.MaskPosition;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.StickerType;
import org.jspecify.annotations.Nullable;

public class Sticker {
    @JsonProperty("file_id") private final String fileId;
    @JsonProperty("file_unique_id") private final String fileUniqueId;
    @JsonProperty("type") private final StickerType type;
    @JsonProperty("width") private final long width;
    @JsonProperty("height") private final long height;
    @JsonProperty("is_animated") private final boolean isAnimated;
    @JsonProperty("is_video") private final boolean isVideo;
    @JsonProperty("thumbnail") @Nullable private final PhotoSize thumbnail;
    @JsonProperty("emoji") @Nullable private final String emoji;
    @JsonProperty("set_name") @Nullable private final String setName;
    @JsonProperty("premium_animation") @Nullable private final File premiumAnimation;
    @JsonProperty("mask_position") @Nullable private final MaskPosition maskPosition;
    @JsonProperty("custom_emoji_id") @Nullable private final String customEmojiId;
    @JsonProperty("needs_repainting") @Nullable private final Boolean needsRepainting;
    @JsonProperty("file_size") @Nullable private final Long fileSize;

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
            @JsonProperty("file_size") @Nullable Long fileSize
    ) {
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

    public String fileId() {
        return this.fileId;
    }

    public String fileUniqueId() {
        return this.fileUniqueId;
    }

    public StickerType type() {
        return this.type;
    }

    public long width() {
        return this.width;
    }

    public long height() {
        return this.height;
    }

    public boolean isAnimated() {
        return this.isAnimated;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public PhotoSize thumbnail() {
        return this.thumbnail;
    }

    public String emoji() {
        return this.emoji;
    }

    public String setName() {
        return this.setName;
    }

    public File premiumAnimation() {
        return this.premiumAnimation;
    }

    public MaskPosition maskPosition() {
        return this.maskPosition;
    }

    public String customEmojiId() {
        return this.customEmojiId;
    }

    public Boolean needsRepainting() {
        return this.needsRepainting;
    }

    public Long fileSize() {
        return this.fileSize;
    }
}
