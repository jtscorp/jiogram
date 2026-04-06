package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.TelegramMethod;

public record GetBusinessConnection(
    @JsonProperty("business_connection_id") String businessConnectionId
) implements TelegramMethod<BusinessConnection> {

    @Override
    public String apiMethod() {
        return "getBusinessConnection";
    }

    @Override
    public String apiReturnType() {
        return "BusinessConnection";
    }
}
