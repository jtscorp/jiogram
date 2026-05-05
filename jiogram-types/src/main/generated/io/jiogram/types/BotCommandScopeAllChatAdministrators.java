package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;

public record BotCommandScopeAllChatAdministrators(
    @JsonProperty("type") BotCommandScopeType type
) implements BotCommandScope {}
