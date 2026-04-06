package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatBoostAdded(
    @JsonProperty("boost_count") long boostCount
) {}
