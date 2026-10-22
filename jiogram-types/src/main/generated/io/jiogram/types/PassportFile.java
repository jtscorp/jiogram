package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport
 * files are in JPEG format when decrypted and don't exceed 10MB.
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param fileSize File size in bytes
 * @param fileDate Unix time when the file was uploaded
 * @see <a href="https://core.telegram.org/bots/api#passportfile">PassportFile in the Bot API</a>
 */
public record PassportFile(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("file_size") long fileSize,
    @JsonProperty("file_date") long fileDate
) {

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
}
