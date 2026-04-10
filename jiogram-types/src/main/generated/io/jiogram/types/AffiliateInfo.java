package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class AffiliateInfo {
    @JsonProperty("affiliate_user") @Nullable private final User affiliateUser;
    @JsonProperty("affiliate_chat") @Nullable private final Chat affiliateChat;
    @JsonProperty("commission_per_mille") private final long commissionPerMille;
    @JsonProperty("amount") private final long amount;
    @JsonProperty("nanostar_amount") @Nullable private final Long nanostarAmount;

    @JsonCreator
    public AffiliateInfo(
            @JsonProperty("affiliate_user") @Nullable User affiliateUser,
            @JsonProperty("affiliate_chat") @Nullable Chat affiliateChat,
            @JsonProperty("commission_per_mille") long commissionPerMille,
            @JsonProperty("amount") long amount,
            @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount
    ) {
        this.affiliateUser = affiliateUser;
        this.affiliateChat = affiliateChat;
        this.commissionPerMille = commissionPerMille;
        this.amount = amount;
        this.nanostarAmount = nanostarAmount;
    }

    public User affiliateUser() {
        return this.affiliateUser;
    }

    public Chat affiliateChat() {
        return this.affiliateChat;
    }

    public long commissionPerMille() {
        return this.commissionPerMille;
    }

    public long amount() {
        return this.amount;
    }

    public Long nanostarAmount() {
        return this.nanostarAmount;
    }
}
