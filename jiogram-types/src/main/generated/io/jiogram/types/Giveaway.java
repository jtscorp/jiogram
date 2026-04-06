package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.List;
import org.jspecify.annotations.Nullable;

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
) {}
