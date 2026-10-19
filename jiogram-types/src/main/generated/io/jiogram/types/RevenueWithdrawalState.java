package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = RevenueWithdrawalStateUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = RevenueWithdrawalStateFailed.class, name = "failed"),
    @JsonSubTypes.Type(value = RevenueWithdrawalStatePending.class, name = "pending"),
    @JsonSubTypes.Type(value = RevenueWithdrawalStateSucceeded.class, name = "succeeded")
})
public sealed interface RevenueWithdrawalState permits RevenueWithdrawalStateFailed, RevenueWithdrawalStatePending, RevenueWithdrawalStateSucceeded, RevenueWithdrawalStateUnknown {}
