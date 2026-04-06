package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record SetChatAdministratorCustomTitle(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("user_id") long userId,
    @JsonProperty("custom_title") String customTitle
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatAdministratorCustomTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
