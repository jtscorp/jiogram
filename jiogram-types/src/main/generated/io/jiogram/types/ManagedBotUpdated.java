package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public record ManagedBotUpdated(
    @JsonProperty("user") User user,
    @JsonProperty("bot") User bot
) {}
