package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalState;
import org.jspecify.annotations.Nullable;

public class TransactionPartnerFragment implements TransactionPartner {
    @JsonProperty("type") private final String type;
    @JsonProperty("withdrawal_state") @Nullable private final RevenueWithdrawalState withdrawalState;

    @JsonCreator
    public TransactionPartnerFragment(
            @JsonProperty("type") String type,
            @JsonProperty("withdrawal_state") @Nullable RevenueWithdrawalState withdrawalState
    ) {
        this.type = type;
        this.withdrawalState = withdrawalState;
    }

    public String type() {
        return this.type;
    }

    public RevenueWithdrawalState withdrawalState() {
        return this.withdrawalState;
    }
}
