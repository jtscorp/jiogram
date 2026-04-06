package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record DeleteMessage(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_id") long messageId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
