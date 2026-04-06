package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import org.jspecify.annotations.Nullable;

public record GiveawayCompleted(
    @JsonProperty("winner_count") long winnerCount,
    @JsonProperty("unclaimed_prize_count") @Nullable Long unclaimedPrizeCount,
    @JsonProperty("giveaway_message") @Nullable Message giveawayMessage,
    @JsonProperty("is_star_giveaway") @Nullable Boolean isStarGiveaway
) {}
