package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;

public record TransactionPartnerOther(
    @JsonProperty("type") TransactionPartnerType type
) implements TransactionPartner {}
