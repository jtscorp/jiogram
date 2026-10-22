package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a file ready to be downloaded. The file can be downloaded via the link
 * https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;. It is guaranteed that the link
 * will be valid for at least 1 hour. When the link expires, a new one can be requested by calling
 * getFile.
 * <br>The maximum file size to download is 20 MB
 *
 * @see <a href="https://core.telegram.org/bots/api#file">File in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class File {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("file_size")
    private final @Nullable Long fileSize;

    @JsonProperty("file_path")
    private final @Nullable String filePath;

    /**
     * Creates a new {@code File} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages
     *     may have difficulty/silent defects in interpreting it. But it has at most 52 significant
     *     bits, so a signed 64-bit integer or double-precision float type are safe for storing this
     *     value.
     * @param filePath File path. Use
     *     https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt; to get the file.
     */
    @JsonCreator
    public File(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("file_size") @Nullable Long fileSize,
            @JsonProperty("file_path") @Nullable String filePath) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public static File of(String fileId, String fileUniqueId) {
        return new File(fileId, fileUniqueId, null, null);
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
     * File size in bytes. It can be bigger than 2^31 and some programming languages may have
     * difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a
     * signed 64-bit integer or double-precision float type are safe for storing this value.
     */
    public @Nullable Long fileSize() {
        return fileSize;
    }

    /**
     * File path. Use https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt; to get the
     * file.
     */
    public @Nullable String filePath() {
        return filePath;
    }

    public File withFileId(String fileId) {
        return new File(fileId, fileUniqueId, fileSize, filePath);
    }

    public File withFileUniqueId(String fileUniqueId) {
        return new File(fileId, fileUniqueId, fileSize, filePath);
    }

    public File withFileSize(@Nullable Long fileSize) {
        return new File(fileId, fileUniqueId, fileSize, filePath);
    }

    public File withFilePath(@Nullable String filePath) {
        return new File(fileId, fileUniqueId, fileSize, filePath);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof File)) {
            return false;
        }
        File that = (File) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && Objects.equals(this.fileSize, that.fileSize)
                && Objects.equals(this.filePath, that.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.fileSize, this.filePath);
    }

    @Override
    public String toString() {
        return "File[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", fileSize=" + this.fileSize
                + ", filePath=" + this.filePath
                + "]";
    }
}
