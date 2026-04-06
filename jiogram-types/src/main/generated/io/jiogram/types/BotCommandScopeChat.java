package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;

public record BotCommandScopeChat(
    @JsonProperty("type") String type,
    @JsonProperty("chat_id") ChatId chatId
) implements BotCommandScope {}
