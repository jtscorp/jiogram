package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param width Video width as defined by the sender
 * @param height Video height as defined by the sender
 * @param duration Duration of the video in seconds as defined by the sender
 * @param thumbnail Animation thumbnail as defined by the sender
 * @param fileName Original animation filename as defined by the sender
 * @param mimeType MIME type of the file as defined by the sender
 * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages may
 *     have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so
 *     a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @see <a href="https://core.telegram.org/bots/api#animation">Animation in the Bot API</a>
 */
public record Animation(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("width") long width,
    @JsonProperty("height") long height,
    @JsonProperty("duration") long duration,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
    @JsonProperty("file_name") @Nullable String fileName,
    @JsonProperty("mime_type") @Nullable String mimeType,
    @JsonProperty("file_size") @Nullable Long fileSize
) {

    public Animation withFileId(String fileId) {
        return new Animation(fileId, fileUniqueId, width, height, duration, thumbnail, fileName, mimeType, fileSize);
    }

    public Animation withFileUniqueId(String fileUniqueId) {
        return new Animation(fileId, fileUniqueId, width, height, duration, thumbnail, fileName, mimeType, fileSize);
    }

    public Animation withWidth(long width) {
        return new Animation(fileId, fileUniqueId, width, height, duration, thumbnail, fileName, mimeType, fileSize);
    }

    public Animation withHeight(long height) {
        return new Animation(fileId, fileUniqueId, width, height, duration, thumbnail, fileName, mimeType, fileSize);
    }

    public Animation withDuration(long duration) {
        return new Animation(fileId, fileUniqueId, width, height, duration, thumbnail, fileName, mimeType, fileSize);
    }

    public Animation withThumbnail(@Nullable PhotoSize thumbnail) {
        return new Animation(fileId, fileUniqueId, width, height, duration, thumbnail, fileName, mimeType, fileSize);
    }

    public Animation withFileName(@Nullable String fileName) {
        return new Animation(fileId, fileUniqueId, width, height, duration, thumbnail, fileName, mimeType, fileSize);
    }

    public Animation withMimeType(@Nullable String mimeType) {
        return new Animation(fileId, fileUniqueId, width, height, duration, thumbnail, fileName, mimeType, fileSize);
    }

    public Animation withFileSize(@Nullable Long fileSize) {
        return new Animation(fileId, fileUniqueId, width, height, duration, thumbnail, fileName, mimeType, fileSize);
    }
}
