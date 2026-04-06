package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record GetChatMemberCount(
    @JsonProperty("chat_id") ChatId chatId
) implements TelegramMethod<Long> {

    @Override
    public String apiMethod() {
        return "getChatMemberCount";
    }

    @Override
    public String apiReturnType() {
        return "Int";
    }
}
