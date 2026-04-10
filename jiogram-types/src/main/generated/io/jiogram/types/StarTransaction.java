package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartner;
import org.jspecify.annotations.Nullable;

public class StarTransaction {
    @JsonProperty("id") private final String id;
    @JsonProperty("amount") private final long amount;
    @JsonProperty("nanostar_amount") @Nullable private final Long nanostarAmount;
    @JsonProperty("date") private final long date;
    @JsonProperty("source") @Nullable private final TransactionPartner source;
    @JsonProperty("receiver") @Nullable private final TransactionPartner receiver;

    @JsonCreator
    public StarTransaction(
            @JsonProperty("id") String id,
            @JsonProperty("amount") long amount,
            @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount,
            @JsonProperty("date") long date,
            @JsonProperty("source") @Nullable TransactionPartner source,
            @JsonProperty("receiver") @Nullable TransactionPartner receiver
    ) {
        this.id = id;
        this.amount = amount;
        this.nanostarAmount = nanostarAmount;
        this.date = date;
        this.source = source;
        this.receiver = receiver;
    }

    public String id() {
        return this.id;
    }

    public long amount() {
        return this.amount;
    }

    public Long nanostarAmount() {
        return this.nanostarAmount;
    }

    public long date() {
        return this.date;
    }

    public TransactionPartner source() {
        return this.source;
    }

    public TransactionPartner receiver() {
        return this.receiver;
    }
}
