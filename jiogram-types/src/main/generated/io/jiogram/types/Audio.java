package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 *
 * @param fileId Identifier for this file, which can be used to download or reuse the file
 * @param fileUniqueId Unique identifier for this file, which is supposed to be the same over time
 *     and for different bots. Can't be used to download or reuse the file.
 * @param duration Duration of the audio in seconds as defined by the sender
 * @param performer Performer of the audio as defined by the sender or by audio tags
 * @param title Title of the audio as defined by the sender or by audio tags
 * @param fileName Original filename as defined by the sender
 * @param mimeType MIME type of the file as defined by the sender
 * @param fileSize File size in bytes. It can be bigger than 2^31 and some programming languages may
 *     have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so
 *     a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @param thumbnail Thumbnail of the album cover to which the music file belongs
 * @see <a href="https://core.telegram.org/bots/api#audio">Audio in the Bot API</a>
 */
public record Audio(
    @JsonProperty("file_id") String fileId,
    @JsonProperty("file_unique_id") String fileUniqueId,
    @JsonProperty("duration") long duration,
    @JsonProperty("performer") @Nullable String performer,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("file_name") @Nullable String fileName,
    @JsonProperty("mime_type") @Nullable String mimeType,
    @JsonProperty("file_size") @Nullable Long fileSize,
    @JsonProperty("thumbnail") @Nullable PhotoSize thumbnail
) {}
