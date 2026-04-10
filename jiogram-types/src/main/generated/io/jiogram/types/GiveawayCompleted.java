package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import org.jspecify.annotations.Nullable;

public class GiveawayCompleted {
    @JsonProperty("winner_count") private final long winnerCount;
    @JsonProperty("unclaimed_prize_count") @Nullable private final Long unclaimedPrizeCount;
    @JsonProperty("giveaway_message") @Nullable private final Message giveawayMessage;
    @JsonProperty("is_star_giveaway") @Nullable private final Boolean isStarGiveaway;

    @JsonCreator
    public GiveawayCompleted(
            @JsonProperty("winner_count") long winnerCount,
            @JsonProperty("unclaimed_prize_count") @Nullable Long unclaimedPrizeCount,
            @JsonProperty("giveaway_message") @Nullable Message giveawayMessage,
            @JsonProperty("is_star_giveaway") @Nullable Boolean isStarGiveaway
    ) {
        this.winnerCount = winnerCount;
        this.unclaimedPrizeCount = unclaimedPrizeCount;
        this.giveawayMessage = giveawayMessage;
        this.isStarGiveaway = isStarGiveaway;
    }

    public long winnerCount() {
        return this.winnerCount;
    }

    public Long unclaimedPrizeCount() {
        return this.unclaimedPrizeCount;
    }

    public Message giveawayMessage() {
        return this.giveawayMessage;
    }

    public Boolean isStarGiveaway() {
        return this.isStarGiveaway;
    }
}
