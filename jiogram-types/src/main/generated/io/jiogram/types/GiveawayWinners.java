package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a message about the completion of a giveaway with public winners.
 *
 * @see <a href="https://core.telegram.org/bots/api#giveawaywinners">GiveawayWinners in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class GiveawayWinners {

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("giveaway_message_id")
    private final long giveawayMessageId;

    @JsonProperty("winners_selection_date")
    private final long winnersSelectionDate;

    @JsonProperty("winner_count")
    private final long winnerCount;

    @JsonProperty("winners")
    private final List<User> winners;

    @JsonProperty("additional_chat_count")
    private final @Nullable Long additionalChatCount;

    @JsonProperty("prize_star_count")
    private final @Nullable Long prizeStarCount;

    @JsonProperty("premium_subscription_month_count")
    private final @Nullable Long premiumSubscriptionMonthCount;

    @JsonProperty("unclaimed_prize_count")
    private final @Nullable Long unclaimedPrizeCount;

    @JsonProperty("only_new_members")
    private final @Nullable Boolean onlyNewMembers;

    @JsonProperty("was_refunded")
    private final @Nullable Boolean wasRefunded;

    @JsonProperty("prize_description")
    private final @Nullable String prizeDescription;

    /**
     * Creates a new {@code GiveawayWinners} instance.
     *
     * @param chat The chat that created the giveaway
     * @param giveawayMessageId Identifier of the message with the giveaway in the chat
     * @param winnersSelectionDate Point in time (Unix timestamp) when winners of the giveaway were
     *     selected
     * @param winnerCount Total number of winners in the giveaway
     * @param winners List of up to 100 winners of the giveaway
     * @param additionalChatCount The number of other chats the user had to join in order to be
     *     eligible for the giveaway
     * @param prizeStarCount The number of Telegram Stars that were split between giveaway winners;
     *     for Telegram Star giveaways only
     * @param premiumSubscriptionMonthCount The number of months the Telegram Premium subscription
     *     won from the giveaway will be active for; for Telegram Premium giveaways only
     * @param unclaimedPrizeCount Number of undistributed prizes
     * @param onlyNewMembers True, if only users who had joined the chats after the giveaway started
     *     were eligible to win
     * @param wasRefunded True, if the giveaway was canceled because the payment for it was refunded
     * @param prizeDescription Description of additional giveaway prize
     */
    @JsonCreator
    public GiveawayWinners(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("giveaway_message_id") long giveawayMessageId,
            @JsonProperty("winners_selection_date") long winnersSelectionDate,
            @JsonProperty("winner_count") long winnerCount,
            @JsonProperty("winners") List<User> winners,
            @JsonProperty("additional_chat_count") @Nullable Long additionalChatCount,
            @JsonProperty("prize_star_count") @Nullable Long prizeStarCount,
            @JsonProperty("premium_subscription_month_count") @Nullable Long premiumSubscriptionMonthCount,
            @JsonProperty("unclaimed_prize_count") @Nullable Long unclaimedPrizeCount,
            @JsonProperty("only_new_members") @Nullable Boolean onlyNewMembers,
            @JsonProperty("was_refunded") @Nullable Boolean wasRefunded,
            @JsonProperty("prize_description") @Nullable String prizeDescription) {
        this.chat = chat;
        this.giveawayMessageId = giveawayMessageId;
        this.winnersSelectionDate = winnersSelectionDate;
        this.winnerCount = winnerCount;
        this.winners = winners;
        this.additionalChatCount = additionalChatCount;
        this.prizeStarCount = prizeStarCount;
        this.premiumSubscriptionMonthCount = premiumSubscriptionMonthCount;
        this.unclaimedPrizeCount = unclaimedPrizeCount;
        this.onlyNewMembers = onlyNewMembers;
        this.wasRefunded = wasRefunded;
        this.prizeDescription = prizeDescription;
    }

    public static GiveawayWinners of(Chat chat, long giveawayMessageId, long winnersSelectionDate, long winnerCount, List<User> winners) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, null, null, null, null, null, null, null);
    }

    /**
     * The chat that created the giveaway
     */
    public Chat chat() {
        return chat;
    }

    /**
     * Identifier of the message with the giveaway in the chat
     */
    public long giveawayMessageId() {
        return giveawayMessageId;
    }

    /**
     * Point in time (Unix timestamp) when winners of the giveaway were selected
     */
    public long winnersSelectionDate() {
        return winnersSelectionDate;
    }

    /**
     * Total number of winners in the giveaway
     */
    public long winnerCount() {
        return winnerCount;
    }

    /**
     * List of up to 100 winners of the giveaway
     */
    public List<User> winners() {
        return winners;
    }

    /**
     * The number of other chats the user had to join in order to be eligible for the giveaway
     */
    public @Nullable Long additionalChatCount() {
        return additionalChatCount;
    }

    /**
     * The number of Telegram Stars that were split between giveaway winners; for Telegram Star
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

    /**
     * Number of undistributed prizes
     */
    public @Nullable Long unclaimedPrizeCount() {
        return unclaimedPrizeCount;
    }

    /**
     * True, if only users who had joined the chats after the giveaway started were eligible to win
     */
    public @Nullable Boolean onlyNewMembers() {
        return onlyNewMembers;
    }

    /**
     * True, if the giveaway was canceled because the payment for it was refunded
     */
    public @Nullable Boolean wasRefunded() {
        return wasRefunded;
    }

    /**
     * Description of additional giveaway prize
     */
    public @Nullable String prizeDescription() {
        return prizeDescription;
    }

    public GiveawayWinners withChat(Chat chat) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withGiveawayMessageId(long giveawayMessageId) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withWinnersSelectionDate(long winnersSelectionDate) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withWinnerCount(long winnerCount) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withWinners(List<User> winners) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withAdditionalChatCount(@Nullable Long additionalChatCount) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withPrizeStarCount(@Nullable Long prizeStarCount) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withPremiumSubscriptionMonthCount(@Nullable Long premiumSubscriptionMonthCount) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withUnclaimedPrizeCount(@Nullable Long unclaimedPrizeCount) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withOnlyNewMembers(@Nullable Boolean onlyNewMembers) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withWasRefunded(@Nullable Boolean wasRefunded) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    public GiveawayWinners withPrizeDescription(@Nullable String prizeDescription) {
        return new GiveawayWinners(chat, giveawayMessageId, winnersSelectionDate, winnerCount, winners, additionalChatCount, prizeStarCount, premiumSubscriptionMonthCount, unclaimedPrizeCount, onlyNewMembers, wasRefunded, prizeDescription);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GiveawayWinners)) {
            return false;
        }
        GiveawayWinners that = (GiveawayWinners) o;
        return Objects.equals(this.chat, that.chat)
                && this.giveawayMessageId == that.giveawayMessageId
                && this.winnersSelectionDate == that.winnersSelectionDate
                && this.winnerCount == that.winnerCount
                && Objects.equals(this.winners, that.winners)
                && Objects.equals(this.additionalChatCount, that.additionalChatCount)
                && Objects.equals(this.prizeStarCount, that.prizeStarCount)
                && Objects.equals(this.premiumSubscriptionMonthCount, that.premiumSubscriptionMonthCount)
                && Objects.equals(this.unclaimedPrizeCount, that.unclaimedPrizeCount)
                && Objects.equals(this.onlyNewMembers, that.onlyNewMembers)
                && Objects.equals(this.wasRefunded, that.wasRefunded)
                && Objects.equals(this.prizeDescription, that.prizeDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat, this.giveawayMessageId, this.winnersSelectionDate, this.winnerCount, this.winners, this.additionalChatCount, this.prizeStarCount, this.premiumSubscriptionMonthCount, this.unclaimedPrizeCount, this.onlyNewMembers, this.wasRefunded, this.prizeDescription);
    }

    @Override
    public String toString() {
        return "GiveawayWinners[chat=" + this.chat
                + ", giveawayMessageId=" + this.giveawayMessageId
                + ", winnersSelectionDate=" + this.winnersSelectionDate
                + ", winnerCount=" + this.winnerCount
                + ", winners=" + this.winners
                + ", additionalChatCount=" + this.additionalChatCount
                + ", prizeStarCount=" + this.prizeStarCount
                + ", premiumSubscriptionMonthCount=" + this.premiumSubscriptionMonthCount
                + ", unclaimedPrizeCount=" + this.unclaimedPrizeCount
                + ", onlyNewMembers=" + this.onlyNewMembers
                + ", wasRefunded=" + this.wasRefunded
                + ", prizeDescription=" + this.prizeDescription
                + "]";
    }
}
