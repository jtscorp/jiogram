package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class DeleteMessage implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_id") private final long messageId;

    @JsonCreator
    public DeleteMessage(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_id") long messageId
    ) {
        this.chatId = chatId;
        this.messageId = messageId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long messageId() {
        return this.messageId;
    }

    @Override
    public String apiMethod() {
        return "deleteMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
