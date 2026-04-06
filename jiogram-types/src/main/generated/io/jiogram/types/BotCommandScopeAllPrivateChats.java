package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotCommandScopeAllPrivateChats(
    @JsonProperty("type") String type
) implements BotCommandScope {}
