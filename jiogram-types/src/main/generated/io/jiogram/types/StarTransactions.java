package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarTransaction;
import java.util.List;

public class StarTransactions {
    @JsonProperty("transactions") private final List<StarTransaction> transactions;

    @JsonCreator
    public StarTransactions(
            @JsonProperty("transactions") List<StarTransaction> transactions
    ) {
        this.transactions = transactions;
    }

    public List<StarTransaction> transactions() {
        return this.transactions;
    }
}
