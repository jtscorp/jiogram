package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a video message (available in Telegram apps as of v.4.0).
 *
 * @see <a href="https://core.telegram.org/bots/api#videonote">VideoNote in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class VideoNote {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("length")
    private final long length;

    @JsonProperty("duration")
    private final long duration;

    @JsonProperty("thumbnail")
    private final @Nullable PhotoSize thumbnail;

    @JsonProperty("file_size")
    private final @Nullable Long fileSize;

    /**
     * Creates a new {@code VideoNote} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param length Video width and height (diameter of the video message) as defined by the sender
     * @param duration Duration of the video in seconds as defined by the sender
     * @param thumbnail Video thumbnail
     * @param fileSize File size in bytes
     */
    @JsonCreator
    public VideoNote(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("length") long length,
            @JsonProperty("duration") long duration,
            @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
            @JsonProperty("file_size") @Nullable Long fileSize) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.length = length;
        this.duration = duration;
        this.thumbnail = thumbnail;
        this.fileSize = fileSize;
    }

    public static VideoNote of(String fileId, String fileUniqueId, long length, long duration) {
        return new VideoNote(fileId, fileUniqueId, length, duration, null, null);
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
     * Video width and height (diameter of the video message) as defined by the sender
     */
    public long length() {
        return length;
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
     * File size in bytes
     */
    public @Nullable Long fileSize() {
        return fileSize;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VideoNote)) {
            return false;
        }
        VideoNote that = (VideoNote) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && this.length == that.length
                && this.duration == that.duration
                && Objects.equals(this.thumbnail, that.thumbnail)
                && Objects.equals(this.fileSize, that.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.length, this.duration, this.thumbnail, this.fileSize);
    }

    @Override
    public String toString() {
        return "VideoNote[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", length=" + this.length
                + ", duration=" + this.duration
                + ", thumbnail=" + this.thumbnail
                + ", fileSize=" + this.fileSize
                + "]";
    }
}
