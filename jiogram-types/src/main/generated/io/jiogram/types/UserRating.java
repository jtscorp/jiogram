package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object describes the rating of a user based on their Telegram Star spendings.
 *
 * @param level Current level of the user, indicating their reliability when purchasing digital
 *     goods and services. A higher level suggests a more trustworthy customer; a negative level is
 *     likely reason for concern.
 * @param rating Numerical value of the user's rating; the higher the rating, the better
 * @param currentLevelRating The rating value required to get the current level
 * @param nextLevelRating The rating value required to get to the next level; omitted if the maximum
 *     level was reached
 * @see <a href="https://core.telegram.org/bots/api#userrating">UserRating in the Bot API</a>
 */
public record UserRating(
    @JsonProperty("level") long level,
    @JsonProperty("rating") long rating,
    @JsonProperty("current_level_rating") long currentLevelRating,
    @JsonProperty("next_level_rating") @Nullable Long nextLevelRating
) {

    public static UserRating of(long level, long rating, long currentLevelRating) {
        return new UserRating(level, rating, currentLevelRating, null);
    }

    public UserRating withLevel(long level) {
        return new UserRating(level, rating, currentLevelRating, nextLevelRating);
    }

    public UserRating withRating(long rating) {
        return new UserRating(level, rating, currentLevelRating, nextLevelRating);
    }

    public UserRating withCurrentLevelRating(long currentLevelRating) {
        return new UserRating(level, rating, currentLevelRating, nextLevelRating);
    }

    public UserRating withNextLevelRating(@Nullable Long nextLevelRating) {
        return new UserRating(level, rating, currentLevelRating, nextLevelRating);
    }
}
