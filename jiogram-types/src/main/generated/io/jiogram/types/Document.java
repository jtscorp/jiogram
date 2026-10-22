package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a general file (as opposed to photos, voice messages and audio files).
 *
 * @see <a href="https://core.telegram.org/bots/api#document">Document in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Document {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("thumbnail")
    private final @Nullable PhotoSize thumbnail;

    @JsonProperty("file_name")
    private final @Nullable String fileName;

    @JsonProperty("mime_type")
    private final @Nullable String mimeType;

    @JsonProperty("file_size")
    private final @Nullable Long fileSize;

    /**
     * Creates a new {@code Document} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param thumbnail Document thumbnail as defined by the sender
     * @param fileName Original filename as defined by the sender
     * @param mimeType MIME type of the file as defined by the sender
     * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages
     *     may have difficulty/silent defects in interpreting it. But it has at most 52 significant
     *     bits, so a signed 64-bit integer or double-precision float type are safe for storing this
     *     value.
     */
    @JsonCreator
    public Document(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
            @JsonProperty("file_name") @Nullable String fileName,
            @JsonProperty("mime_type") @Nullable String mimeType,
            @JsonProperty("file_size") @Nullable Long fileSize) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.thumbnail = thumbnail;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.fileSize = fileSize;
    }

    public static Document of(String fileId, String fileUniqueId) {
        return new Document(fileId, fileUniqueId, null, null, null, null);
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
     * Document thumbnail as defined by the sender
     */
    public @Nullable PhotoSize thumbnail() {
        return thumbnail;
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

    public Document withFileId(String fileId) {
        return new Document(fileId, fileUniqueId, thumbnail, fileName, mimeType, fileSize);
    }

    public Document withFileUniqueId(String fileUniqueId) {
        return new Document(fileId, fileUniqueId, thumbnail, fileName, mimeType, fileSize);
    }

    public Document withThumbnail(@Nullable PhotoSize thumbnail) {
        return new Document(fileId, fileUniqueId, thumbnail, fileName, mimeType, fileSize);
    }

    public Document withFileName(@Nullable String fileName) {
        return new Document(fileId, fileUniqueId, thumbnail, fileName, mimeType, fileSize);
    }

    public Document withMimeType(@Nullable String mimeType) {
        return new Document(fileId, fileUniqueId, thumbnail, fileName, mimeType, fileSize);
    }

    public Document withFileSize(@Nullable Long fileSize) {
        return new Document(fileId, fileUniqueId, thumbnail, fileName, mimeType, fileSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Document)) {
            return false;
        }
        Document that = (Document) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && Objects.equals(this.thumbnail, that.thumbnail)
                && Objects.equals(this.fileName, that.fileName)
                && Objects.equals(this.mimeType, that.mimeType)
                && Objects.equals(this.fileSize, that.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.thumbnail, this.fileName, this.mimeType, this.fileSize);
    }

    @Override
    public String toString() {
        return "Document[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", thumbnail=" + this.thumbnail
                + ", fileName=" + this.fileName
                + ", mimeType=" + this.mimeType
                + ", fileSize=" + this.fileSize
                + "]";
    }
}
