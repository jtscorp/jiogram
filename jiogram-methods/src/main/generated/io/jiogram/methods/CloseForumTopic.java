package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;

public class CloseForumTopic implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_thread_id") private final long messageThreadId;

    @JsonCreator
    public CloseForumTopic(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") long messageThreadId
    ) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long messageThreadId() {
        return this.messageThreadId;
    }

    @Override
    public String apiMethod() {
        return "closeForumTopic";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
