package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatMember;
import io.jiogram.types.TelegramMethod;

public record GetChatMember(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId
) implements TelegramMethod<ChatMember> {

    @Override
    public String apiMethod() {
        return "getChatMember";
    }

    @Override
    public String apiReturnType() {
        return "ChatMember";
    }
}
