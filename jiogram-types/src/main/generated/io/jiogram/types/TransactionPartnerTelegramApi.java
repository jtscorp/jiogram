package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionPartnerTelegramApi(
    @JsonProperty("type") String type,
    @JsonProperty("request_count") long requestCount
) implements TransactionPartner {}
