package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RevenueWithdrawalStatePending(
    @JsonProperty("type") String type
) implements RevenueWithdrawalState {}
