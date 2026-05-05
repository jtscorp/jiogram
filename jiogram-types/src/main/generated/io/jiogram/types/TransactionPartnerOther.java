package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;

public class TransactionPartnerOther implements TransactionPartner {
    @JsonProperty("type") private final TransactionPartnerType type;

    @JsonCreator
    public TransactionPartnerOther(
            @JsonProperty("type") TransactionPartnerType type
    ) {
        this.type = type;
    }

    public TransactionPartnerType type() {
        return this.type;
    }
}
