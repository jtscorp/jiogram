package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Audio;
import java.util.List;

/**
 * This object represents the audios displayed on a user's profile.
 *
 * @param totalCount Total number of profile audios for the target user
 * @param audios Requested profile audios
 * @see <a href="https://core.telegram.org/bots/api#userprofileaudios">UserProfileAudios in the Bot API</a>
 */
public record UserProfileAudios(
    @JsonProperty("total_count") long totalCount,
    @JsonProperty("audios") List<Audio> audios
) {}
