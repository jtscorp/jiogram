package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.TelegramMethod;

public class GetBusinessConnection implements TelegramMethod<BusinessConnection> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;

    @JsonCreator
    public GetBusinessConnection(
            @JsonProperty("business_connection_id") String businessConnectionId
    ) {
        this.businessConnectionId = businessConnectionId;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    @Override
    public String apiMethod() {
        return "getBusinessConnection";
    }

    @Override
    public String apiReturnType() {
        return "BusinessConnection";
    }
}
