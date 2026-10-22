package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 *
 * @see <a href="https://core.telegram.org/bots/api#photosize">PhotoSize in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PhotoSize {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("width")
    private final long width;

    @JsonProperty("height")
    private final long height;

    @JsonProperty("file_size")
    private final @Nullable Long fileSize;

    /**
     * Creates a new {@code PhotoSize} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param width Photo width
     * @param height Photo height
     * @param fileSize File size in bytes
     */
    @JsonCreator
    public PhotoSize(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("width") long width,
            @JsonProperty("height") long height,
            @JsonProperty("file_size") @Nullable Long fileSize) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.width = width;
        this.height = height;
        this.fileSize = fileSize;
    }

    public static PhotoSize of(String fileId, String fileUniqueId, long width, long height) {
        return new PhotoSize(fileId, fileUniqueId, width, height, null);
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
     * Photo width
     */
    public long width() {
        return width;
    }

    /**
     * Photo height
     */
    public long height() {
        return height;
    }

    /**
     * File size in bytes
     */
    public @Nullable Long fileSize() {
        return fileSize;
    }

    public PhotoSize withFileId(String fileId) {
        return new PhotoSize(fileId, fileUniqueId, width, height, fileSize);
    }

    public PhotoSize withFileUniqueId(String fileUniqueId) {
        return new PhotoSize(fileId, fileUniqueId, width, height, fileSize);
    }

    public PhotoSize withWidth(long width) {
        return new PhotoSize(fileId, fileUniqueId, width, height, fileSize);
    }

    public PhotoSize withHeight(long height) {
        return new PhotoSize(fileId, fileUniqueId, width, height, fileSize);
    }

    public PhotoSize withFileSize(@Nullable Long fileSize) {
        return new PhotoSize(fileId, fileUniqueId, width, height, fileSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhotoSize)) {
            return false;
        }
        PhotoSize that = (PhotoSize) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && this.width == that.width
                && this.height == that.height
                && Objects.equals(this.fileSize, that.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.width, this.height, this.fileSize);
    }

    @Override
    public String toString() {
        return "PhotoSize[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", width=" + this.width
                + ", height=" + this.height
                + ", fileSize=" + this.fileSize
                + "]";
    }
}
