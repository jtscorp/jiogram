package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record UserRating(
    @JsonProperty("level") long level,
    @JsonProperty("rating") long rating,
    @JsonProperty("current_level_rating") long currentLevelRating,
    @JsonProperty("next_level_rating") @Nullable Long nextLevelRating
) {}
