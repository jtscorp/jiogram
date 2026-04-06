package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record UnpinChatMessage(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_id") @Nullable Long messageId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "unpinChatMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static UnpinChatMessage of(ChatId chatId) {
        return new UnpinChatMessage(null, chatId, null);
    }
}
