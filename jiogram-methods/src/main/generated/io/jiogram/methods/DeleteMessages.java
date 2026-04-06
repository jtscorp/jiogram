package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import java.util.List;

public record DeleteMessages(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_ids") List<Long> messageIds
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "deleteMessages";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
