package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatBoostSourceType;
import io.jiogram.types.User;

public record ChatBoostSourcePremium(
    @JsonProperty("source") ChatBoostSourceType source,
    @JsonProperty("user") User user
) implements ChatBoostSource {}
