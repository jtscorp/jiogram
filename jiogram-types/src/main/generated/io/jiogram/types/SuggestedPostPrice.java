package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SuggestedPostPrice {
    @JsonProperty("currency") private final String currency;
    @JsonProperty("amount") private final long amount;

    @JsonCreator
    public SuggestedPostPrice(
            @JsonProperty("currency") String currency,
            @JsonProperty("amount") long amount
    ) {
        this.currency = currency;
        this.amount = amount;
    }

    public String currency() {
        return this.currency;
    }

    public long amount() {
        return this.amount;
    }
}
