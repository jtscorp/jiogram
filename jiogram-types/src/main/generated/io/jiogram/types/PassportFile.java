package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport
 * files are in JPEG format when decrypted and don't exceed 10MB.
 *
 * @see <a href="https://core.telegram.org/bots/api#passportfile">PassportFile in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PassportFile {

    @JsonProperty("file_id")
    private final String fileId;

    @JsonProperty("file_unique_id")
    private final String fileUniqueId;

    @JsonProperty("file_size")
    private final long fileSize;

    @JsonProperty("file_date")
    private final long fileDate;

    /**
     * Creates a new {@code PassportFile} instance.
     *
     * @param fileId Identifier for this file, which can be used to download or reuse the file
     * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over
     *     time and for different bots. Can't be used to download or reuse the file.
     * @param fileSize File size in bytes
     * @param fileDate Unix time when the file was uploaded
     */
    @JsonCreator
    public PassportFile(
            @JsonProperty("file_id") String fileId,
            @JsonProperty("file_unique_id") String fileUniqueId,
            @JsonProperty("file_size") long fileSize,
            @JsonProperty("file_date") long fileDate) {
        this.fileId = fileId;
        this.fileUniqueId = fileUniqueId;
        this.fileSize = fileSize;
        this.fileDate = fileDate;
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
     * File size in bytes
     */
    public long fileSize() {
        return fileSize;
    }

    /**
     * Unix time when the file was uploaded
     */
    public long fileDate() {
        return fileDate;
    }

    public PassportFile withFileId(String fileId) {
        return new PassportFile(fileId, fileUniqueId, fileSize, fileDate);
    }

    public PassportFile withFileUniqueId(String fileUniqueId) {
        return new PassportFile(fileId, fileUniqueId, fileSize, fileDate);
    }

    public PassportFile withFileSize(long fileSize) {
        return new PassportFile(fileId, fileUniqueId, fileSize, fileDate);
    }

    public PassportFile withFileDate(long fileDate) {
        return new PassportFile(fileId, fileUniqueId, fileSize, fileDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PassportFile)) {
            return false;
        }
        PassportFile that = (PassportFile) o;
        return Objects.equals(this.fileId, that.fileId)
                && Objects.equals(this.fileUniqueId, that.fileUniqueId)
                && this.fileSize == that.fileSize
                && this.fileDate == that.fileDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fileId, this.fileUniqueId, this.fileSize, this.fileDate);
    }

    @Override
    public String toString() {
        return "PassportFile[fileId=" + this.fileId
                + ", fileUniqueId=" + this.fileUniqueId
                + ", fileSize=" + this.fileSize
                + ", fileDate=" + this.fileDate
                + "]";
    }
}
