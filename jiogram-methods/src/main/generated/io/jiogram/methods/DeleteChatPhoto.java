package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class DeleteChatPhoto implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;

    @JsonCreator
    public DeleteChatPhoto(
            @JsonProperty("chat_id") ChatId chatId
    ) {
        this.chatId = chatId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    @Override
    public String apiMethod() {
        return "deleteChatPhoto";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
