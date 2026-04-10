package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionPartnerTelegramApi implements TransactionPartner {
    @JsonProperty("type") private final String type;
    @JsonProperty("request_count") private final long requestCount;

    @JsonCreator
    public TransactionPartnerTelegramApi(
            @JsonProperty("type") String type,
            @JsonProperty("request_count") long requestCount
    ) {
        this.type = type;
        this.requestCount = requestCount;
    }

    public String type() {
        return this.type;
    }

    public long requestCount() {
        return this.requestCount;
    }
}
