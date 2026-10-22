package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a video file of a specific quality.
 *
 * @see <a href="https://core.telegram.org/bots/api#videoquality">VideoQuality in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class VideoQuality {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("width")
    private final long width;

    @JsonProperty("height")
    private final long height;

    @JsonProperty("codec")
    private final String codec;

    @JsonProperty("file_size")
    private final @Nullable Long fileSize;

    /**
     * Creates a new {@code VideoQuality} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param width Video width
     * @param height Video height
     * @param codec Codec that was used to encode the video, for example, 'h264', 'h265', or 'av01'
     * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages
     *     may have difficulty/silent defects in interpreting it. But it has at most 52 significant
     *     bits, so a signed 64-bit integer or double-precision float type are safe for storing this
     *     value.
     */
    @JsonCreator
    public VideoQuality(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("width") long width,
            @JsonProperty("height") long height,
            @JsonProperty("codec") String codec,
            @JsonProperty("file_size") @Nullable Long fileSize) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.width = width;
        this.height = height;
        this.codec = codec;
        this.fileSize = fileSize;
    }

    public static VideoQuality of(String fileId, String fileUniqueId, long width, long height, String codec) {
        return new VideoQuality(fileId, fileUniqueId, width, height, codec, null);
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
     * Video width
     */
    public long width() {
        return width;
    }

    /**
     * Video height
     */
    public long height() {
        return height;
    }

    /**
     * Codec that was used to encode the video, for example, 'h264', 'h265', or 'av01'
     */
    public String codec() {
        return codec;
    }

    /**
     * File size in bytes. It can be bigger than 2^31 and some programming languages may have
     * difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
     * signed 64-bit integer or double-precision float type are safe for storing this value.
     */
    public @Nullable Long fileSize() {
        return fileSize;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VideoQuality)) {
            return false;
        }
        VideoQuality that = (VideoQuality) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && this.width == that.width
                && this.height == that.height
                && Objects.equals(this.codec, that.codec)
                && Objects.equals(this.fileSize, that.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.width, this.height, this.codec, this.fileSize);
    }

    @Override
    public String toString() {
        return "VideoQuality[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", width=" + this.width
                + ", height=" + this.height
                + ", codec=" + this.codec
                + ", fileSize=" + this.fileSize
                + "]";
    }
}
