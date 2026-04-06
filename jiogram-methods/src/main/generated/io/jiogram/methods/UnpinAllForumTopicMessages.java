package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public record UnpinAllForumTopicMessages(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") long messageThreadId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unpinAllForumTopicMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
