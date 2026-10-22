package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param width Photo width
 * @param height Photo height
 * @param fileSize File size in bytes
 * @see <a href="https://core.telegram.org/bots/api#photosize">PhotoSize in the Bot API</a>
 */
public record PhotoSize(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("width") long width,
    @JsonProperty("height") long height,
    @JsonProperty("file_size") @Nullable Long fileSize
) {}
