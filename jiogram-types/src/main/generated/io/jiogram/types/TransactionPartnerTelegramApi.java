package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;

public class TransactionPartnerTelegramApi implements TransactionPartner {
    @JsonProperty("type") private final TransactionPartnerType type;
    @JsonProperty("request_count") private final long requestCount;

    @JsonCreator
    public TransactionPartnerTelegramApi(
            @JsonProperty("type") TransactionPartnerType type,
            @JsonProperty("request_count") long requestCount
    ) {
        this.type = type;
        this.requestCount = requestCount;
    }

    public TransactionPartnerType type() {
        return this.type;
    }

    public long requestCount() {
        return this.requestCount;
    }
}
