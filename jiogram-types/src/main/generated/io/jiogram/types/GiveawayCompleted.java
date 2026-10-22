package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Message;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about the completion of a giveaway without public
 * winners.
 *
 * @param winnerCount Number of winners in the giveaway
 * @param unclaimedPrizeCount Number of undistributed prizes
 * @param giveawayMessage Message with the giveaway that was completed, if it wasn't deleted
 * @param isStarGiveaway True, if the giveaway is a Telegram Star giveaway. Otherwise, currently,
 *     the giveaway is a Telegram Premium giveaway.
 * @see <a href="https://core.telegram.org/bots/api#giveawaycompleted">GiveawayCompleted in the Bot API</a>
 */
public record GiveawayCompleted(
    @JsonProperty("winner_count") long winnerCount,
    @JsonProperty("unclaimed_prize_count") @Nullable Long unclaimedPrizeCount,
    @JsonProperty("giveaway_message") @Nullable Message giveawayMessage,
    @JsonProperty("is_star_giveaway") @Nullable Boolean isStarGiveaway
) {

    public GiveawayCompleted withWinnerCount(long winnerCount) {
        return new GiveawayCompleted(winnerCount, unclaimedPrizeCount, giveawayMessage, isStarGiveaway);
    }

    public GiveawayCompleted withUnclaimedPrizeCount(@Nullable Long unclaimedPrizeCount) {
        return new GiveawayCompleted(winnerCount, unclaimedPrizeCount, giveawayMessage, isStarGiveaway);
    }

    public GiveawayCompleted withGiveawayMessage(@Nullable Message giveawayMessage) {
        return new GiveawayCompleted(winnerCount, unclaimedPrizeCount, giveawayMessage, isStarGiveaway);
    }

    public GiveawayCompleted withIsStarGiveaway(@Nullable Boolean isStarGiveaway) {
        return new GiveawayCompleted(winnerCount, unclaimedPrizeCount, giveawayMessage, isStarGiveaway);
    }
}
