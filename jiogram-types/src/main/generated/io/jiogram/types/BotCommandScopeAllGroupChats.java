package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotCommandScopeAllGroupChats(
    @JsonProperty("type") String type
) implements BotCommandScope {}
