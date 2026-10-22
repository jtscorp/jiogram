package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a file ready to be downloaded. The file can be downloaded via the link
 * https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;. It is guaranteed that the link
 * will be valid for at least 1 hour. When the link expires, a new one can be requested by calling
 * getFile.
 * <br>The maximum file size to download is 20 MB
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages may
 *     have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so
 *     a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @param filePath File path. Use https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;
 *     to get the file.
 * @see <a href="https://core.telegram.org/bots/api#file">File in the Bot API</a>
 */
public record File(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("file_size") @Nullable Long fileSize,
    @JsonProperty("file_path") @Nullable String filePath
) {

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
}
