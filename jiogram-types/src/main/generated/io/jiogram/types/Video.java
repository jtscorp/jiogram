package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.VideoQuality;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a video file.
 *
 * @see <a href="https://core.telegram.org/bots/api#video">Video in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Video {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("width")
    private final long width;

    @JsonProperty("height")
    private final long height;

    @JsonProperty("duration")
    private final long duration;

    @JsonProperty("thumbnail")
    private final @Nullable PhotoSize thumbnail;

    @JsonProperty("cover")
    private final @Nullable List<PhotoSize> cover;

    @JsonProperty("start_timestamp")
    private final @Nullable Long startTimestamp;

    @JsonProperty("qualities")
    private final @Nullable List<VideoQuality> qualities;

    @JsonProperty("file_name")
    private final @Nullable String fileName;

    @JsonProperty("mime_type")
    private final @Nullable String mimeType;

    @JsonProperty("file_size")
    private final @Nullable Long fileSize;

    /**
     * Creates a new {@code Video} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param width Video width as defined by the sender
     * @param height Video height as defined by the sender
     * @param duration Duration of the video in seconds as defined by the sender
     * @param thumbnail Video thumbnail
     * @param cover Available sizes of the cover of the video in the message
     * @param startTimestamp Timestamp in seconds from which the video will play in the message
     * @param qualities List of available qualities of the video
     * @param fileName Original filename as defined by the sender
     * @param mimeType MIME type of the file as defined by the sender
     * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages
     *     may have difficulty/silent defects in interpreting it. But it has at most 52 significant
     *     bits, so a signed 64-bit integer or double-precision float type are safe for storing this
     *     value.
     */
    @JsonCreator
    public Video(
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
            @JsonProperty("file_size") @Nullable Long fileSize) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.thumbnail = thumbnail;
        this.cover = cover;
        this.startTimestamp = startTimestamp;
        this.qualities = qualities;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    public static Video of(String fileId, String fileUniqueId, long width, long height, long duration) {
        return new Video(fileId, fileUniqueId, width, height, duration, null, null, null, null, null, null, null);
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
     * Video width as defined by the sender
     */
    public long width() {
        return width;
    }

    /**
     * Video height as defined by the sender
     */
    public long height() {
        return height;
    }

    /**
     * Duration of the video in seconds as defined by the sender
     */
    public long duration() {
        return duration;
    }

    /**
     * Video thumbnail
     */
    public @Nullable PhotoSize thumbnail() {
        return thumbnail;
    }

    /**
     * Available sizes of the cover of the video in the message
     */
    public @Nullable List<PhotoSize> cover() {
        return cover;
    }

    /**
     * Timestamp in seconds from which the video will play in the message
     */
    public @Nullable Long startTimestamp() {
        return startTimestamp;
    }

    /**
     * List of available qualities of the video
     */
    public @Nullable List<VideoQuality> qualities() {
        return qualities;
    }

    /**
     * Original filename as defined by the sender
     */
    public @Nullable String fileName() {
        return fileName;
    }

    /**
     * MIME type of the file as defined by the sender
     */
    public @Nullable String mimeType() {
        return mimeType;
    }

    /**
     * File size in bytes. It can be bigger than 2^31 and some programming languages may have
     * difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
     * signed 64-bit integer or double-precision float type are safe for storing this value.
     */
    public @Nullable Long fileSize() {
        return fileSize;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Video)) {
            return false;
        }
        Video that = (Video) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && this.width == that.width
                && this.height == that.height
                && this.duration == that.duration
                && Objects.equals(this.thumbnail, that.thumbnail)
                && Objects.equals(this.cover, that.cover)
                && Objects.equals(this.startTimestamp, that.startTimestamp)
                && Objects.equals(this.qualities, that.qualities)
                && Objects.equals(this.fileName, that.fileName)
                && Objects.equals(this.mimeType, that.mimeType)
                && Objects.equals(this.fileSize, that.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.width, this.height, this.duration, this.thumbnail, this.cover, this.startTimestamp, this.qualities, this.fileName, this.mimeType, this.fileSize);
    }

    @Override
    public String toString() {
        return "Video[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", width=" + this.width
                + ", height=" + this.height
                + ", duration=" + this.duration
                + ", thumbnail=" + this.thumbnail
                + ", cover=" + this.cover
                + ", startTimestamp=" + this.startTimestamp
                + ", qualities=" + this.qualities
                + ", fileName=" + this.fileName
                + ", mimeType=" + this.mimeType
                + ", fileSize=" + this.fileSize
                + "]";
    }
}
