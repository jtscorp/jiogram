package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a video message (available in Telegram apps as of v.4.0).
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param length Video width and height (diameter of the video message) as defined by the sender
 * @param duration Duration of the video in seconds as defined by the sender
 * @param thumbnail Video thumbnail
 * @param fileSize File size in bytes
 * @see <a href="https://core.telegram.org/bots/api#videonote">VideoNote in the Bot API</a>
 */
public record VideoNote(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("length") long length,
    @JsonProperty("duration") long duration,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
    @JsonProperty("file_size") @Nullable Long fileSize
) {

    public VideoNote withFileId(String fileId) {
        return new VideoNote(fileId, fileUniqueId, length, duration, thumbnail, fileSize);
    }

    public VideoNote withFileUniqueId(String fileUniqueId) {
        return new VideoNote(fileId, fileUniqueId, length, duration, thumbnail, fileSize);
    }

    public VideoNote withLength(long length) {
        return new VideoNote(fileId, fileUniqueId, length, duration, thumbnail, fileSize);
    }

    public VideoNote withDuration(long duration) {
        return new VideoNote(fileId, fileUniqueId, length, duration, thumbnail, fileSize);
    }

    public VideoNote withThumbnail(@Nullable PhotoSize thumbnail) {
        return new VideoNote(fileId, fileUniqueId, length, duration, thumbnail, fileSize);
    }

    public VideoNote withFileSize(@Nullable Long fileSize) {
        return new VideoNote(fileId, fileUniqueId, length, duration, thumbnail, fileSize);
    }
}
