package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class UserRating {
    @JsonProperty("level") private final long level;
    @JsonProperty("rating") private final long rating;
    @JsonProperty("current_level_rating") private final long currentLevelRating;
    @JsonProperty("next_level_rating") @Nullable private final Long nextLevelRating;

    @JsonCreator
    public UserRating(
            @JsonProperty("level") long level,
            @JsonProperty("rating") long rating,
            @JsonProperty("current_level_rating") long currentLevelRating,
            @JsonProperty("next_level_rating") @Nullable Long nextLevelRating
    ) {
        this.level = level;
        this.rating = rating;
        this.currentLevelRating = currentLevelRating;
        this.nextLevelRating = nextLevelRating;
    }

    public long level() {
        return this.level;
    }

    public long rating() {
        return this.rating;
    }

    public long currentLevelRating() {
        return this.currentLevelRating;
    }

    public Long nextLevelRating() {
        return this.nextLevelRating;
    }
}
