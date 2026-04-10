package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class GetChatMemberCount implements TelegramMethod<Long> {
    @JsonProperty("chat_id") private final ChatId chatId;

    @JsonCreator
    public GetChatMemberCount(
            @JsonProperty("chat_id") ChatId chatId
    ) {
        this.chatId = chatId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    @Override
    public String apiMethod() {
        return "getChatMemberCount";
    }

    @Override
    public String apiReturnType() {
        return "Int";
    }
}
