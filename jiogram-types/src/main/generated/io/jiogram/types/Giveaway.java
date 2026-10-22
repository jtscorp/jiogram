package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a message about a scheduled giveaway.
 *
 * @see <a href="https://core.telegram.org/bots/api#giveaway">Giveaway in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Giveaway {

    @JsonProperty("chats")
    private final List<Chat> chats;

    @JsonProperty("winners_selection_date")
    private final long winnersSelectionDate;

    @JsonProperty("winner_count")
    private final long winnerCount;

    @JsonProperty("only_new_members")
    private final @Nullable Boolean onlyNewMembers;

    @JsonProperty("has_public_winners")
    private final @Nullable Boolean hasPublicWinners;

    @JsonProperty("prize_description")
    private final @Nullable String prizeDescription;

    @JsonProperty("country_codes")
    private final @Nullable List<String> countryCodes;

    @JsonProperty("prize_star_count")
    private final @Nullable Long prizeStarCount;

    @JsonProperty("premium_subscription_month_count")
    private final @Nullable Long premiumSubscriptionMonthCount;

    /**
     * Creates a new {@code Giveaway} instance.
     *
     * @param chats The list of chats which the user must join to participate in the giveaway
     * @param winnersSelectionDate Point in time (Unix timestamp) when winners of the giveaway will
     *     be selected
     * @param winnerCount The number of users which are supposed to be selected as winners of the
     *     giveaway
     * @param onlyNewMembers True, if only users who join the chats after the giveaway started
     *     should be eligible to win
     * @param hasPublicWinners True, if the list of giveaway winners will be visible to everyone
     * @param prizeDescription Description of additional giveaway prize
     * @param countryCodes A list of two-letter ISO 3166-1 alpha-2 country codes indicating the
     *     countries from which eligible users for the giveaway must come. If empty, then all users
     *     can participate in the giveaway. Users with a phone number that was bought on Fragment
     *     can always participate in giveaways.
     * @param prizeStarCount The number of Telegram Stars to be split between giveaway winners; for
     *     Telegram Star giveaways only
     * @param premiumSubscriptionMonthCount The number of months the Telegram Premium subscription
     *     won from the giveaway will be active for; for Telegram Premium giveaways only
     */
    @JsonCreator
    public Giveaway(
            @JsonProperty("chats") List<Chat> chats,
            @JsonProperty("winners_selection_date") long winnersSelectionDate,
            @JsonProperty("winner_count") long winnerCount,
            @JsonProperty("only_new_members") @Nullable Boolean onlyNewMembers,
            @JsonProperty("has_public_winners") @Nullable Boolean hasPublicWinners,
            @JsonProperty("prize_description") @Nullable String prizeDescription,
            @JsonProperty("country_codes") @Nullable List<String> countryCodes,
            @JsonProperty("prize_star_count") @Nullable Long prizeStarCount,
            @JsonProperty("premium_subscription_month_count") @Nullable Long premiumSubscriptionMonthCount) {
        this.chats = chats;
        this.winnersSelectionDate = winnersSelectionDate;
        this.winnerCount = winnerCount;
        this.onlyNewMembers = onlyNewMembers;
        this.hasPublicWinners = hasPublicWinners;
        this.prizeDescription = prizeDescription;
        this.countryCodes = countryCodes;
        this.prizeStarCount = prizeStarCount;
        this.premiumSubscriptionMonthCount = premiumSubscriptionMonthCount;
    }

    public static Giveaway of(List<Chat> chats, long winnersSelectionDate, long winnerCount) {
        return new Giveaway(chats, winnersSelectionDate, winnerCount, null, null, null, null, null, null);
    }

    /**
     * The list of chats which the user must join to participate in the giveaway
     */
    public List<Chat> chats() {
        return chats;
    }

    /**
     * Point in time (Unix timestamp) when winners of the giveaway will be selected
     */
    public long winnersSelectionDate() {
        return winnersSelectionDate;
    }

    /**
     * The number of users which are supposed to be selected as winners of the giveaway
     */
    public long winnerCount() {
        return winnerCount;
    }

    /**
     * True, if only users who join the chats after the giveaway started should be eligible to win
     */
    public @Nullable Boolean onlyNewMembers() {
        return onlyNewMembers;
    }

    /**
     * True, if the list of giveaway winners will be visible to everyone
     */
    public @Nullable Boolean hasPublicWinners() {
        return hasPublicWinners;
    }

    /**
     * Description of additional giveaway prize
     */
    public @Nullable String prizeDescription() {
        return prizeDescription;
    }

    /**
     * A list of two-letter ISO 3166-1 alpha-2 country codes indicating the countries from which
     * eligible users for the giveaway must come. If empty, then all users can participate in the
     * giveaway. Users with a phone number that was bought on Fragment can always participate in
     * giveaways.
     */
    public @Nullable List<String> countryCodes() {
        return countryCodes;
    }

    /**
     * The number of Telegram Stars to be split between giveaway winners; for Telegram Star
     * giveaways only
     */
    public @Nullable Long prizeStarCount() {
        return prizeStarCount;
    }

    /**
     * The number of months the Telegram Premium subscription won from the giveaway will be active
     * for; for Telegram Premium giveaways only
     */
    public @Nullable Long premiumSubscriptionMonthCount() {
        return premiumSubscriptionMonthCount;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Giveaway)) {
            return false;
        }
        Giveaway that = (Giveaway) o;
        return Objects.equals(this.chats, that.chats)
                && this.winnersSelectionDate == that.winnersSelectionDate
                && this.winnerCount == that.winnerCount
                && Objects.equals(this.onlyNewMembers, that.onlyNewMembers)
                && Objects.equals(this.hasPublicWinners, that.hasPublicWinners)
                && Objects.equals(this.prizeDescription, that.prizeDescription)
                && Objects.equals(this.countryCodes, that.countryCodes)
                && Objects.equals(this.prizeStarCount, that.prizeStarCount)
                && Objects.equals(this.premiumSubscriptionMonthCount, that.premiumSubscriptionMonthCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chats, this.winnersSelectionDate, this.winnerCount, this.onlyNewMembers, this.hasPublicWinners, this.prizeDescription, this.countryCodes, this.prizeStarCount, this.premiumSubscriptionMonthCount);
    }

    @Override
    public String toString() {
        return "Giveaway[chats=" + this.chats
                + ", winnersSelectionDate=" + this.winnersSelectionDate
                + ", winnerCount=" + this.winnerCount
                + ", onlyNewMembers=" + this.onlyNewMembers
                + ", hasPublicWinners=" + this.hasPublicWinners
                + ", prizeDescription=" + this.prizeDescription
                + ", countryCodes=" + this.countryCodes
                + ", prizeStarCount=" + this.prizeStarCount
                + ", premiumSubscriptionMonthCount=" + this.premiumSubscriptionMonthCount
                + "]";
    }
}
