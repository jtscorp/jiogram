package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;

public class RevenueWithdrawalStatePending implements RevenueWithdrawalState {
    @JsonProperty("type") private final RevenueWithdrawalStateType type;

    @JsonCreator
    public RevenueWithdrawalStatePending(
            @JsonProperty("type") RevenueWithdrawalStateType type
    ) {
        this.type = type;
    }

    public RevenueWithdrawalStateType type() {
        return this.type;
    }
}
