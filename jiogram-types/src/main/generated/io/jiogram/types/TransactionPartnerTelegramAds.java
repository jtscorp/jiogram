package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;

public class TransactionPartnerTelegramAds implements TransactionPartner {
    @JsonProperty("type") private final TransactionPartnerType type;

    @JsonCreator
    public TransactionPartnerTelegramAds(
            @JsonProperty("type") TransactionPartnerType type
    ) {
        this.type = type;
    }

    public TransactionPartnerType type() {
        return this.type;
    }
}
