package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a message about the completion of a giveaway with public winners.
 *
 * @param chat The chat that created the giveaway
 * @param giveawayMessageId Identifier of the message with the giveaway in the chat
 * @param winnersSelectionDate Point in time (Unix timestamp) when winners of the giveaway were
 *     selected
 * @param winnerCount Total number of winners in the giveaway
 * @param winners List of up to 100 winners of the giveaway
 * @param additionalChatCount The number of other chats the user had to join in order to be eligible
 *     for the giveaway
 * @param prizeStarCount The number of Telegram Stars that were split between giveaway winners; for
 *     Telegram Star giveaways only
 * @param premiumSubscriptionMonthCount The number of months the Telegram Premium subscription won
 *     from the giveaway will be active for; for Telegram Premium giveaways only
 * @param unclaimedPrizeCount Number of undistributed prizes
 * @param onlyNewMembers True, if only users who had joined the chats after the giveaway started
 *     were eligible to win
 * @param wasRefunded True, if the giveaway was canceled because the payment for it was refunded
 * @param prizeDescription Description of additional giveaway prize
 * @see <a href="https://core.telegram.org/bots/api#giveawaywinners">GiveawayWinners in the Bot API</a>
 */
public record GiveawayWinners(
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
    @JsonProperty("prize_description") @Nullable String prizeDescription
) {}
