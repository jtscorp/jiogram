package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

public record TransactionPartnerAffiliateProgram(
    @JsonProperty("type") TransactionPartnerType type,
    @JsonProperty("sponsor_user") @Nullable User sponsorUser,
    @JsonProperty("commission_per_mille") long commissionPerMille
) implements TransactionPartner {}
