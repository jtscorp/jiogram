package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarAmount;
import io.jiogram.types.TelegramMethod;

public record GetBusinessAccountStarBalance(
    @JsonProperty("business_connection_id") String businessConnectionId
) implements TelegramMethod<StarAmount> {

    @Override
    public String apiMethod() {
        return "getBusinessAccountStarBalance";
    }

    @Override
    public String apiReturnType() {
        return "StarAmount";
    }
}
