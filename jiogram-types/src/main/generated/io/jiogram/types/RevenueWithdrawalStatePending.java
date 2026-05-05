package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;

public record RevenueWithdrawalStatePending(
    @JsonProperty("type") RevenueWithdrawalStateType type
) implements RevenueWithdrawalState {}
