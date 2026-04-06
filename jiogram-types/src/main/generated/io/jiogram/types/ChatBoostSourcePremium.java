package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public record ChatBoostSourcePremium(
    @JsonProperty("source") String source,
    @JsonProperty("user") User user
) implements ChatBoostSource {}
