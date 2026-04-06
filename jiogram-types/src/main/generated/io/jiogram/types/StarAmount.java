package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record StarAmount(
    @JsonProperty("amount") long amount,
    @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount
) {}
