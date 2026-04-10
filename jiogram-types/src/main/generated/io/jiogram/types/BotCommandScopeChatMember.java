package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;

public class BotCommandScopeChatMember implements BotCommandScope {
    @JsonProperty("type") private final String type;
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("user_id") private final long userId;

    @JsonCreator
    public BotCommandScopeChatMember(
            @JsonProperty("type") String type,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("user_id") long userId
    ) {
        this.type = type;
        this.chatId = chatId;
        this.userId = userId;
    }

    public String type() {
        return this.type;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long userId() {
        return this.userId;
    }
}
