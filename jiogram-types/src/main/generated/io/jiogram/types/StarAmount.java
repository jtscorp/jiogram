package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class StarAmount {
    @JsonProperty("amount") private final long amount;
    @JsonProperty("nanostar_amount") @Nullable private final Long nanostarAmount;

    @JsonCreator
    public StarAmount(
            @JsonProperty("amount") long amount,
            @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount
    ) {
        this.amount = amount;
        this.nanostarAmount = nanostarAmount;
    }

    public long amount() {
        return this.amount;
    }

    public Long nanostarAmount() {
        return this.nanostarAmount;
    }
}
