package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public class TransactionPartnerAffiliateProgram implements TransactionPartner {
    @JsonProperty("type") private final String type;
    @JsonProperty("sponsor_user") @Nullable private final User sponsorUser;
    @JsonProperty("commission_per_mille") private final long commissionPerMille;

    @JsonCreator
    public TransactionPartnerAffiliateProgram(
            @JsonProperty("type") String type,
            @JsonProperty("sponsor_user") @Nullable User sponsorUser,
            @JsonProperty("commission_per_mille") long commissionPerMille
    ) {
        this.type = type;
        this.sponsorUser = sponsorUser;
        this.commissionPerMille = commissionPerMille;
    }

    public String type() {
        return this.type;
    }

    public User sponsorUser() {
        return this.sponsorUser;
    }

    public long commissionPerMille() {
        return this.commissionPerMille;
    }
}
