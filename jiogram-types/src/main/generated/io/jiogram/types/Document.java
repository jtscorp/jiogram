package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a general file (as opposed to photos, voice messages and audio files).
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param thumbnail Document thumbnail as defined by the sender
 * @param fileName Original filename as defined by the sender
 * @param mimeType MIME type of the file as defined by the sender
 * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages may
 *     have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so
 *     a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @see <a href="https://core.telegram.org/bots/api#document">Document in the Bot API</a>
 */
public record Document(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail,
    @JsonProperty("file_name") @Nullable String fileName,
    @JsonProperty("mime_type") @Nullable String mimeType,
    @JsonProperty("file_size") @Nullable Long fileSize
) {}
