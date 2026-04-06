package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotCommandScopeAllChatAdministrators(
    @JsonProperty("type") String type
) implements BotCommandScope {}
