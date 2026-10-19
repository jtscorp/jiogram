package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;

public record RevenueWithdrawalStateSucceeded(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) RevenueWithdrawalStateType type,
    @JsonProperty("date") long date,
    @JsonProperty("url") String url
) implements RevenueWithdrawalState {}
