package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LabeledPrice(
    @JsonProperty("label") String label,
    @JsonProperty("amount") long amount
) {}
