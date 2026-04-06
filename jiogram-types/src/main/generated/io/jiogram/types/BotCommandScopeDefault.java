package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotCommandScopeDefault(
    @JsonProperty("type") String type
) implements BotCommandScope {}
