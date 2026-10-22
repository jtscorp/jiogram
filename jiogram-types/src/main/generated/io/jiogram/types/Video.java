package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.VideoQuality;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a video file.
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param width Video width as defined by the sender
 * @param height Video height as defined by the sender
 * @param duration Duration of the video in seconds as defined by the sender
 * @param thumbnail Video thumbnail
 * @param cover Available sizes of the cover of the video in the message
 * @param startTimestamp Timestamp in seconds from which the video will play in the message
 * @param qualities List of available qualities of the video
 * @param fileName Original filename as defined by the sender
 * @param mimeType MIME type of the file as defined by the sender
 * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages may
 *     have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so
 *     a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @see <a href="https://core.telegram.org/bots/api#video">Video in the Bot API</a>
 */
public record Video(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("width") long width,
    @JsonProperty("height") long height,
    @JsonProperty("duration") long duration,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
    @JsonProperty("cover") @Nullable List<PhotoSize> cover,
    @JsonProperty("start_timestamp") @Nullable Long startTimestamp,
    @JsonProperty("qualities") @Nullable List<VideoQuality> qualities,
    @JsonProperty("file_name") @Nullable String fileName,
    @JsonProperty("mime_type") @Nullable String mimeType,
    @JsonProperty("file_size") @Nullable Long fileSize
) {

    public static Video of(String fileId, String fileUniqueId, long width, long height, long duration) {
        return new Video(fileId, fileUniqueId, width, height, duration, null, null, null, null, null, null, null);
    }

    public Video withFileId(String fileId) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withFileUniqueId(String fileUniqueId) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withWidth(long width) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withHeight(long height) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withDuration(long duration) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withThumbnail(@Nullable PhotoSize thumbnail) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withCover(@Nullable List<PhotoSize> cover) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withStartTimestamp(@Nullable Long startTimestamp) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withQualities(@Nullable List<VideoQuality> qualities) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withFileName(@Nullable String fileName) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withMimeType(@Nullable String mimeType) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }

    public Video withFileSize(@Nullable Long fileSize) {
        return new Video(fileId, fileUniqueId, width, height, duration, thumbnail, cover, startTimestamp, qualities, fileName, mimeType, fileSize);
    }
}
