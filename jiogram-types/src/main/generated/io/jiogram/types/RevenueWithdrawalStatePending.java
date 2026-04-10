package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RevenueWithdrawalStatePending implements RevenueWithdrawalState {
    @JsonProperty("type") private final String type;

    @JsonCreator
    public RevenueWithdrawalStatePending(
            @JsonProperty("type") String type
    ) {
        this.type = type;
    }

    public String type() {
        return this.type;
    }
}
