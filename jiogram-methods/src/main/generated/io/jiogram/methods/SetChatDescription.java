package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SetChatDescription(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("description") @Nullable String description
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "setChatDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetChatDescription of(ChatId chatId) {
        return new SetChatDescription(chatId, null);
    }
}
