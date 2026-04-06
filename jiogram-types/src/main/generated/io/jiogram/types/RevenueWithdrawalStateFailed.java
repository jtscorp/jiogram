package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RevenueWithdrawalStateFailed(
    @JsonProperty("type") String type
) implements RevenueWithdrawalState {}
