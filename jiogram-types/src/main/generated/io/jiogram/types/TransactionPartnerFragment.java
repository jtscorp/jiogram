package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalState;
import io.jiogram.types.TransactionPartnerType;
import org.jspecify.annotations.Nullable;

public record TransactionPartnerFragment(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
    @JsonProperty("withdrawal_state") @Nullable RevenueWithdrawalState withdrawalState
) implements TransactionPartner {}
