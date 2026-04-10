package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarTransactions;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class GetStarTransactions implements TelegramMethod<StarTransactions> {
    @JsonProperty("offset") @Nullable private final Long offset;
    @JsonProperty("limit") @Nullable private final Long limit;

    @JsonCreator
    public GetStarTransactions(
            @JsonProperty("offset") @Nullable Long offset,
            @JsonProperty("limit") @Nullable Long limit
    ) {
        this.offset = offset;
        this.limit = limit;
    }

    public Long offset() {
        return this.offset;
    }

    public Long limit() {
        return this.limit;
    }

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
