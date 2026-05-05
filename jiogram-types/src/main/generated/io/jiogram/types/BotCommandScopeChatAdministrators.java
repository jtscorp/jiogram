package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;
import io.jiogram.types.ChatId;

public class BotCommandScopeChatAdministrators implements BotCommandScope {
    @JsonProperty("type") private final BotCommandScopeType type;
    @JsonProperty("chat_id") private final ChatId chatId;

    @JsonCreator
    public BotCommandScopeChatAdministrators(
            @JsonProperty("type") BotCommandScopeType type,
            @JsonProperty("chat_id") ChatId chatId
    ) {
        this.type = type;
        this.chatId = chatId;
    }

    public BotCommandScopeType type() {
        return this.type;
    }

    public ChatId chatId() {
        return this.chatId;
    }
}
