package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a chat photo.
 *
 * @param smallFileId File identifier of small (160x160) chat photo. This file_id can be used only
 *     for photo download and only for as long as the photo is not changed.
 * @param smallFileUniqueId Unique file identifier of small (160x160) chat photo, which is supposed
 *     to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @param bigFileId File identifier of big (640x640) chat photo. This file_id can be used only for
 *     photo download and only for as long as the photo is not changed.
 * @param bigFileUniqueId Unique file identifier of big (640x640) chat photo, which is supposed to
 *     be the same over time and for different bots. Can't be used to download or reuse the file.
 * @see <a href="https://core.telegram.org/bots/api#chatphoto">ChatPhoto in the Bot API</a>
 */
public record ChatPhoto(
    @JsonProperty("small_file_id") String smallFileId,
    @JsonProperty("small_file_unique_id") String smallFileUniqueId,
    @JsonProperty("big_file_id") String bigFileId,
    @JsonProperty("big_file_unique_id") String bigFileUniqueId
) {}
