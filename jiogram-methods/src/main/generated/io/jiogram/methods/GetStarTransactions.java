package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarTransactions;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record GetStarTransactions(
    @JsonProperty("offset") @Nullable Long offset,
    @JsonProperty("limit") @Nullable Long limit
) implements TelegramMethod<StarTransactions> {

    @Override
    public String apiMethod() {
        return "getStarTransactions";
    }

    @Override
    public String apiReturnType() {
        return "StarTransactions";
    }

    public static GetStarTransactions of() {
        return new GetStarTransactions(null, null);
    }
}
