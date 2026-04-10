package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class GiveawayWinners {
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("giveaway_message_id") private final long giveawayMessageId;
    @JsonProperty("winners_selection_date") private final long winnersSelectionDate;
    @JsonProperty("winner_count") private final long winnerCount;
    @JsonProperty("winners") private final List<User> winners;
    @JsonProperty("additional_chat_count") @Nullable private final Long additionalChatCount;
    @JsonProperty("prize_star_count") @Nullable private final Long prizeStarCount;
    @JsonProperty("premium_subscription_month_count") @Nullable private final Long premiumSubscriptionMonthCount;
    @JsonProperty("unclaimed_prize_count") @Nullable private final Long unclaimedPrizeCount;
    @JsonProperty("only_new_members") @Nullable private final Boolean onlyNewMembers;
    @JsonProperty("was_refunded") @Nullable private final Boolean wasRefunded;
    @JsonProperty("prize_description") @Nullable private final String prizeDescription;

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
            @JsonProperty("prize_description") @Nullable String prizeDescription
    ) {
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

    public Chat chat() {
        return this.chat;
    }

    public long giveawayMessageId() {
        return this.giveawayMessageId;
    }

    public long winnersSelectionDate() {
        return this.winnersSelectionDate;
    }

    public long winnerCount() {
        return this.winnerCount;
    }

    public List<User> winners() {
        return this.winners;
    }

    public Long additionalChatCount() {
        return this.additionalChatCount;
    }

    public Long prizeStarCount() {
        return this.prizeStarCount;
    }

    public Long premiumSubscriptionMonthCount() {
        return this.premiumSubscriptionMonthCount;
    }

    public Long unclaimedPrizeCount() {
        return this.unclaimedPrizeCount;
    }

    public Boolean onlyNewMembers() {
        return this.onlyNewMembers;
    }

    public Boolean wasRefunded() {
        return this.wasRefunded;
    }

    public String prizeDescription() {
        return this.prizeDescription;
    }
}
