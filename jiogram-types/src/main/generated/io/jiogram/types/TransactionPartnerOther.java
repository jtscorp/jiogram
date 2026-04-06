package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionPartnerOther(
    @JsonProperty("type") String type
) implements TransactionPartner {}
