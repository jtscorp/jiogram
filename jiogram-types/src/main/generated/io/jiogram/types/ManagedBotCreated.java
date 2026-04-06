package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public record ManagedBotCreated(
    @JsonProperty("bot") User bot
) {}
