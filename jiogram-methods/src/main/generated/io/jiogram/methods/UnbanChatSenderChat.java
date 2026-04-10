package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class UnbanChatSenderChat implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("sender_chat_id") private final long senderChatId;

    @JsonCreator
    public UnbanChatSenderChat(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("sender_chat_id") long senderChatId
    ) {
        this.chatId = chatId;
        this.senderChatId = senderChatId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long senderChatId() {
        return this.senderChatId;
    }

    @Override
    public String apiMethod() {
        return "unbanChatSenderChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
