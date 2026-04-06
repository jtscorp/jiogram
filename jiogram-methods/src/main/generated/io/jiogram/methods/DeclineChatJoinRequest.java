package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record DeclineChatJoinRequest(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "declineChatJoinRequest";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
