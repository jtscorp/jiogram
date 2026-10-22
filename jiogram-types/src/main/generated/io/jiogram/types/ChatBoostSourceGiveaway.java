package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSourceType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * The boost was obtained by the creation of a Telegram Premium or a Telegram Star giveaway. This
 * boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription for
 * Telegram Premium giveaways and prize_star_count / 500 times for one year for Telegram Star
 * giveaways.
 *
 * @param source Source of the boost, always 'giveaway'
 * @param giveawayMessageId Identifier of a message in the chat with the giveaway; the message could
 *     have been deleted already. May be 0 if the message isn't sent yet.
 * @param user User that won the prize in the giveaway if any; for Telegram Premium giveaways only
 * @param prizeStarCount The number of Telegram Stars to be split between giveaway winners; for
 *     Telegram Star giveaways only
 * @param isUnclaimed True, if the giveaway was completed, but there was no user to win the prize
 * @see <a href="https://core.telegram.org/bots/api#chatboostsourcegiveaway">ChatBoostSourceGiveaway in the Bot API</a>
 */
public record ChatBoostSourceGiveaway(
    @JsonProperty(value = "source", access = JsonProperty.Access.WRITE_ONLY) ChatBoostSourceType source,
    @JsonProperty("giveaway_message_id") long giveawayMessageId,
    @JsonProperty("user") @Nullable User user,
    @JsonProperty("prize_star_count") @Nullable Long prizeStarCount,
    @JsonProperty("is_unclaimed") @Nullable Boolean isUnclaimed
) implements ChatBoostSource {

    public ChatBoostSourceGiveaway withGiveawayMessageId(long giveawayMessageId) {
        return new ChatBoostSourceGiveaway(source, giveawayMessageId, user, prizeStarCount, isUnclaimed);
    }

    public ChatBoostSourceGiveaway withUser(@Nullable User user) {
        return new ChatBoostSourceGiveaway(source, giveawayMessageId, user, prizeStarCount, isUnclaimed);
    }

    public ChatBoostSourceGiveaway withPrizeStarCount(@Nullable Long prizeStarCount) {
        return new ChatBoostSourceGiveaway(source, giveawayMessageId, user, prizeStarCount, isUnclaimed);
    }

    public ChatBoostSourceGiveaway withIsUnclaimed(@Nullable Boolean isUnclaimed) {
        return new ChatBoostSourceGiveaway(source, giveawayMessageId, user, prizeStarCount, isUnclaimed);
    }
}
