package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionPartnerTelegramAds(
    @JsonProperty("type") String type
) implements TransactionPartner {}
