package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;

public class RevenueWithdrawalStateSucceeded implements RevenueWithdrawalState {
    @JsonProperty("type") private final RevenueWithdrawalStateType type;
    @JsonProperty("date") private final long date;
    @JsonProperty("url") private final String url;

    @JsonCreator
    public RevenueWithdrawalStateSucceeded(
            @JsonProperty("type") RevenueWithdrawalStateType type,
            @JsonProperty("date") long date,
            @JsonProperty("url") String url
    ) {
        this.type = type;
        this.date = date;
        this.url = url;
    }

    public RevenueWithdrawalStateType type() {
        return this.type;
    }

    public long date() {
        return this.date;
    }

    public String url() {
        return this.url;
    }
}
