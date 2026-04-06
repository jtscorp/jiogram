package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatBoost;

public record ChatBoostUpdated(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("boost") ChatBoost boost
) {}
