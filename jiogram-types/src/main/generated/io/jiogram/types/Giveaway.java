package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class Giveaway {
    @JsonProperty("chats") private final List<Chat> chats;
    @JsonProperty("winners_selection_date") private final long winnersSelectionDate;
    @JsonProperty("winner_count") private final long winnerCount;
    @JsonProperty("only_new_members") @Nullable private final Boolean onlyNewMembers;
    @JsonProperty("has_public_winners") @Nullable private final Boolean hasPublicWinners;
    @JsonProperty("prize_description") @Nullable private final String prizeDescription;
    @JsonProperty("country_codes") @Nullable private final List<String> countryCodes;
    @JsonProperty("prize_star_count") @Nullable private final Long prizeStarCount;
    @JsonProperty("premium_subscription_month_count") @Nullable private final Long premiumSubscriptionMonthCount;

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
            @JsonProperty("premium_subscription_month_count") @Nullable Long premiumSubscriptionMonthCount
    ) {
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

    public List<Chat> chats() {
        return this.chats;
    }

    public long winnersSelectionDate() {
        return this.winnersSelectionDate;
    }

    public long winnerCount() {
        return this.winnerCount;
    }

    public Boolean onlyNewMembers() {
        return this.onlyNewMembers;
    }

    public Boolean hasPublicWinners() {
        return this.hasPublicWinners;
    }

    public String prizeDescription() {
        return this.prizeDescription;
    }

    public List<String> countryCodes() {
        return this.countryCodes;
    }

    public Long prizeStarCount() {
        return this.prizeStarCount;
    }

    public Long premiumSubscriptionMonthCount() {
        return this.premiumSubscriptionMonthCount;
    }
}
