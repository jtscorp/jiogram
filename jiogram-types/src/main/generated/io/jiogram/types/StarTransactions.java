package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarTransaction;
import java.util.List;

public record StarTransactions(
    @JsonProperty("transactions") List<StarTransaction> transactions
) {}
