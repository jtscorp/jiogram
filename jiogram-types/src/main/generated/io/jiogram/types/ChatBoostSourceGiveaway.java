package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record ChatBoostSourceGiveaway(
    @JsonProperty("source") String source,
    @JsonProperty("giveaway_message_id") long giveawayMessageId,
    @JsonProperty("user") @Nullable User user,
    @JsonProperty("prize_star_count") @Nullable Long prizeStarCount,
    @JsonProperty("is_unclaimed") @Nullable Boolean isUnclaimed
) implements ChatBoostSource {}
