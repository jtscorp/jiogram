package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SuggestedPostPrice(
    @JsonProperty("currency") String currency,
    @JsonProperty("amount") long amount
) {}
