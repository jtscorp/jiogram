package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSource;

public record ChatBoost(
    @JsonProperty("boost_id") String boostId,
    @JsonProperty("add_date") long addDate,
    @JsonProperty("expiration_date") long expirationDate,
    @JsonProperty("source") ChatBoostSource source
) {}
