package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public class DeleteMessages implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_ids") private final List<Long> messageIds;

    @JsonCreator
    public DeleteMessages(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_ids") List<Long> messageIds
    ) {
        this.chatId = chatId;
        this.messageIds = messageIds;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public List<Long> messageIds() {
        return this.messageIds;
    }

    @Override
    public String apiMethod() {
        return "deleteMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
