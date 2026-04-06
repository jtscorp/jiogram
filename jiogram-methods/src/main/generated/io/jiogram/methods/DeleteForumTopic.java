package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record DeleteForumTopic(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") long messageThreadId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
