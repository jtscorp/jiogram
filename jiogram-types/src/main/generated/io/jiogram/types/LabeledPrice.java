package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LabeledPrice {
    @JsonProperty("label") private final String label;
    @JsonProperty("amount") private final long amount;

    @JsonCreator
    public LabeledPrice(
            @JsonProperty("label") String label,
            @JsonProperty("amount") long amount
    ) {
        this.label = label;
        this.amount = amount;
    }

    public String label() {
        return this.label;
    }

    public long amount() {
        return this.amount;
    }
}
