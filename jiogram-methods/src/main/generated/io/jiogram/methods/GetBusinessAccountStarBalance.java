package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StarAmount;
import io.jiogram.types.TelegramMethod;

public class GetBusinessAccountStarBalance implements TelegramMethod<StarAmount> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;

    @JsonCreator
    public GetBusinessAccountStarBalance(
            @JsonProperty("business_connection_id") String businessConnectionId
    ) {
        this.businessConnectionId = businessConnectionId;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    @Override
    public String apiMethod() {
        return "getBusinessAccountStarBalance";
    }

    @Override
    public String apiReturnType() {
        return "StarAmount";
    }
}
