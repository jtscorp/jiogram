package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.File;
import io.jiogram.types.MaskPosition;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.StickerType;
import org.jspecify.annotations.Nullable;

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
) {}
