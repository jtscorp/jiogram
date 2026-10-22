package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PhotoSize;
import java.util.List;

/**
 * This object represent a user's profile pictures.
 *
 * @param totalCount Total number of profile pictures the target user has
 * @param photos Requested profile pictures (in up to 4 sizes each)
 * @see <a href="https://core.telegram.org/bots/api#userprofilephotos">UserProfilePhotos in the Bot API</a>
 */
public record UserProfilePhotos(
    @JsonProperty("total_count") long totalCount,
    @JsonProperty("photos") List<List<PhotoSize>> photos
) {}
