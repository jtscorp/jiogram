package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record UnbanChatSenderChat(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("sender_chat_id") long senderChatId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unbanChatSenderChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
