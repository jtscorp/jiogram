package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object describes the rating of a user based on their Telegram Star spendings.
 *
 * @see <a href="https://core.telegram.org/bots/api#userrating">UserRating in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UserRating {

    @JsonProperty("level")
    private final long level;

    @JsonProperty("rating")
    private final long rating;

    @JsonProperty("current_level_rating")
    private final long currentLevelRating;

    @JsonProperty("next_level_rating")
    private final @Nullable Long nextLevelRating;

    /**
     * Creates a new {@code UserRating} instance.
     *
     * @param level Current level of the user, indicating their reliability when purchasing digital
     *     goods and services. A higher level suggests a more trustworthy customer; a negative level
     *     is likely reason for concern.
     * @param rating Numerical value of the user's rating; the higher the rating, the better
     * @param currentLevelRating The rating value required to get the current level
     * @param nextLevelRating The rating value required to get to the next level; omitted if the
     *     maximum level was reached
     */
    @JsonCreator
    public UserRating(
            @JsonProperty("level") long level,
            @JsonProperty("rating") long rating,
            @JsonProperty("current_level_rating") long currentLevelRating,
            @JsonProperty("next_level_rating") @Nullable Long nextLevelRating) {
        this.level = level;
        this.rating = rating;
        this.currentLevelRating = currentLevelRating;
        this.nextLevelRating = nextLevelRating;
    }

    public static UserRating of(long level, long rating, long currentLevelRating) {
        return new UserRating(level, rating, currentLevelRating, null);
    }

    /**
     * Current level of the user, indicating their reliability when purchasing digital goods and
     * services. A higher level suggests a more trustworthy customer; a negative level is likely
     * reason for concern.
     */
    public long level() {
        return level;
    }

    /**
     * Numerical value of the user's rating; the higher the rating, the better
     */
    public long rating() {
        return rating;
    }

    /**
     * The rating value required to get the current level
     */
    public long currentLevelRating() {
        return currentLevelRating;
    }

    /**
     * The rating value required to get to the next level; omitted if the maximum level was reached
     */
    public @Nullable Long nextLevelRating() {
        return nextLevelRating;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserRating)) {
            return false;
        }
        UserRating that = (UserRating) o;
        return this.level == that.level
                && this.rating == that.rating
                && this.currentLevelRating == that.currentLevelRating
                && Objects.equals(this.nextLevelRating, that.nextLevelRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.level, this.rating, this.currentLevelRating, this.nextLevelRating);
    }

    @Override
    public String toString() {
        return "UserRating[level=" + this.level
                + ", rating=" + this.rating
                + ", currentLevelRating=" + this.currentLevelRating
                + ", nextLevelRating=" + this.nextLevelRating
                + "]";
    }
}
