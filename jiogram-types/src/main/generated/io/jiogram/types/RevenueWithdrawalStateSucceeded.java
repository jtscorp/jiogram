package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RevenueWithdrawalStateSucceeded(
    @JsonProperty("type") String type,
    @JsonProperty("date") long date,
    @JsonProperty("url") String url
) implements RevenueWithdrawalState {}
