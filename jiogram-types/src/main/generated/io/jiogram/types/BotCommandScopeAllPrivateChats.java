package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BotCommandScopeType;

public class BotCommandScopeAllPrivateChats implements BotCommandScope {
    @JsonProperty("type") private final BotCommandScopeType type;

    @JsonCreator
    public BotCommandScopeAllPrivateChats(
            @JsonProperty("type") BotCommandScopeType type
    ) {
        this.type = type;
    }

    public BotCommandScopeType type() {
        return this.type;
    }
}
