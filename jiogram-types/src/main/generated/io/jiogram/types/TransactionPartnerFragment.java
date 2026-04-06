package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalState;
import org.jspecify.annotations.Nullable;

public record TransactionPartnerFragment(
    @JsonProperty("type") String type,
    @JsonProperty("withdrawal_state") @Nullable RevenueWithdrawalState withdrawalState
) implements TransactionPartner {}
