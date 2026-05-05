package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TransactionPartnerType;

public record TransactionPartnerTelegramApi(
    @JsonProperty("type") TransactionPartnerType type,
    @JsonProperty("request_count") long requestCount
) implements TransactionPartner {}
