package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a message about a scheduled giveaway.
 *
 * @param chats The list of chats which the user must join to participate in the giveaway
 * @param winnersSelectionDate Point in time (Unix timestamp) when winners of the giveaway will be
 *     selected
 * @param winnerCount The number of users which are supposed to be selected as winners of the
 *     giveaway
 * @param onlyNewMembers True, if only users who join the chats after the giveaway started should be
 *     eligible to win
 * @param hasPublicWinners True, if the list of giveaway winners will be visible to everyone
 * @param prizeDescription Description of additional giveaway prize
 * @param countryCodes A list of two-letter ISO 3166-1 alpha-2 country codes indicating the
 *     countries from which eligible users for the giveaway must come. If empty, then all users can
 *     participate in the giveaway. Users with a phone number that was bought on Fragment can always
 *     participate in giveaways.
 * @param prizeStarCount The number of Telegram Stars to be split between giveaway winners; for
 *     Telegram Star giveaways only
 * @param premiumSubscriptionMonthCount The number of months the Telegram Premium subscription won
 *     from the giveaway will be active for; for Telegram Premium giveaways only
 * @see <a href="https://core.telegram.org/bots/api#giveaway">Giveaway in the Bot API</a>
 */
public record Giveaway(
    @JsonProperty("chats") List<Chat> chats,
    @JsonProperty("winners_selection_date") long winnersSelectionDate,
    @JsonProperty("winner_count") long winnerCount,
    @JsonProperty("only_new_members") @Nullable Boolean onlyNewMembers,
    @JsonProperty("has_public_winners") @Nullable Boolean hasPublicWinners,
    @JsonProperty("prize_description") @Nullable String prizeDescription,
    @JsonProperty("country_codes") @Nullable List<String> countryCodes,
    @JsonProperty("prize_star_count") @Nullable Long prizeStarCount,
    @JsonProperty("premium_subscription_month_count") @Nullable Long premiumSubscriptionMonthCount
) {

    public Giveaway withChats(List<Chat> chats) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, onlyNewMembers, hasPublicWinners, prizeDescription, countryCodes, prizeStarCount, premiumSubscriptionMonthCount);
    }

    public Giveaway withWinnersSelectionDate(long winnersSelectionDate) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, onlyNewMembers, hasPublicWinners, prizeDescription, countryCodes, prizeStarCount, premiumSubscriptionMonthCount);
    }

    public Giveaway withWinnerCount(long winnerCount) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, onlyNewMembers, hasPublicWinners, prizeDescription, countryCodes, prizeStarCount, premiumSubscriptionMonthCount);
    }

    public Giveaway withOnlyNewMembers(@Nullable Boolean onlyNewMembers) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, onlyNewMembers, hasPublicWinners, prizeDescription, countryCodes, prizeStarCount, premiumSubscriptionMonthCount);
    }

    public Giveaway withHasPublicWinners(@Nullable Boolean hasPublicWinners) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, onlyNewMembers, hasPublicWinners, prizeDescription, countryCodes, prizeStarCount, premiumSubscriptionMonthCount);
    }

    public Giveaway withPrizeDescription(@Nullable String prizeDescription) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, onlyNewMembers, hasPublicWinners, prizeDescription, countryCodes, prizeStarCount, premiumSubscriptionMonthCount);
    }

    public Giveaway withCountryCodes(@Nullable List<String> countryCodes) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, onlyNewMembers, hasPublicWinners, prizeDescription, countryCodes, prizeStarCount, premiumSubscriptionMonthCount);
    }

    public Giveaway withPrizeStarCount(@Nullable Long prizeStarCount) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, onlyNewMembers, hasPublicWinners, prizeDescription, countryCodes, prizeStarCount, premiumSubscriptionMonthCount);
    }

    public Giveaway withPremiumSubscriptionMonthCount(@Nullable Long premiumSubscriptionMonthCount) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, onlyNewMembers, hasPublicWinners, prizeDescription, countryCodes, prizeStarCount, premiumSubscriptionMonthCount);
    }
}
