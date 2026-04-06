package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

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
