package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a service message about the creation of a scheduled giveaway.
 *
 * @param prizeStarCount The number of Telegram Stars to be split between giveaway winners; for
 *     Telegram Star giveaways only
 * @see <a href="https://core.telegram.org/bots/api#giveawaycreated">GiveawayCreated in the Bot API</a>
 */
public record GiveawayCreated(
    @JsonProperty("prize_star_count") @Nullable Long prizeStarCount
) {

    public static GiveawayCreated of() {
        return new GiveawayCreated(null);
    }

    public GiveawayCreated withPrizeStarCount(@Nullable Long prizeStarCount) {
        return new GiveawayCreated(prizeStarCount);
    }
}
