package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = RevenueWithdrawalStateFailed.class, name = "failed"),
    @JsonSubTypes.Type(value = RevenueWithdrawalStatePending.class, name = "pending"),
    @JsonSubTypes.Type(value = RevenueWithdrawalStateSucceeded.class, name = "succeeded")
})
public interface RevenueWithdrawalState {}
