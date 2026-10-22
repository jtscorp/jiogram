package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a video file of a specific quality.
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param width Video width
 * @param height Video height
 * @param codec Codec that was used to encode the video, for example, 'h264', 'h265', or 'av01'
 * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages may
 *     have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so
 *     a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @see <a href="https://core.telegram.org/bots/api#videoquality">VideoQuality in the Bot API</a>
 */
public record VideoQuality(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("width") long width,
    @JsonProperty("height") long height,
    @JsonProperty("codec") String codec,
    @JsonProperty("file_size") @Nullable Long fileSize
) {

    public VideoQuality withFileId(String fileId) {
        return new VideoQuality(fileId, fileUniqueId, width, height, codec, fileSize);
    }

    public VideoQuality withFileUniqueId(String fileUniqueId) {
        return new VideoQuality(fileId, fileUniqueId, width, height, codec, fileSize);
    }

    public VideoQuality withWidth(long width) {
        return new VideoQuality(fileId, fileUniqueId, width, height, codec, fileSize);
    }

    public VideoQuality withHeight(long height) {
        return new VideoQuality(fileId, fileUniqueId, width, height, codec, fileSize);
    }

    public VideoQuality withCodec(String codec) {
        return new VideoQuality(fileId, fileUniqueId, width, height, codec, fileSize);
    }

    public VideoQuality withFileSize(@Nullable Long fileSize) {
        return new VideoQuality(fileId, fileUniqueId, width, height, codec, fileSize);
    }
}
