package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class GiveawayCreated {
    @JsonProperty("prize_star_count") @Nullable private final Long prizeStarCount;

    @JsonCreator
    public GiveawayCreated(
            @JsonProperty("prize_star_count") @Nullable Long prizeStarCount
    ) {
        this.prizeStarCount = prizeStarCount;
    }

    public Long prizeStarCount() {
        return this.prizeStarCount;
    }
}
