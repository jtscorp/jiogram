package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;

public record BotCommandScopeChatMember(
    @JsonProperty("type") String type,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId
) implements BotCommandScope {}
