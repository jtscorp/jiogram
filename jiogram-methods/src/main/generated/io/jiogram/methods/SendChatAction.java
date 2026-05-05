package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAction;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SendChatAction(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("action") ChatAction action
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "sendChatAction";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SendChatAction of(ChatId chatId, ChatAction action) {
        return new SendChatAction(null, chatId, null, action);
    }
}
