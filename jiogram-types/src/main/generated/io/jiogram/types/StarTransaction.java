package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartner;
import org.jspecify.annotations.Nullable;

public record StarTransaction(
    @JsonProperty("id") String id,
    @JsonProperty("amount") long amount,
    @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount,
    @JsonProperty("date") long date,
    @JsonProperty("source") @Nullable TransactionPartner source,
    @JsonProperty("receiver") @Nullable TransactionPartner receiver
) {}
