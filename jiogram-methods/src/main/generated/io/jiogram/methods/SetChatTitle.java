package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record SetChatTitle(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("title") String title
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatTitle";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
