package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record GiveawayCreated(
    @JsonProperty("prize_star_count") @Nullable Long prizeStarCount
) {}
