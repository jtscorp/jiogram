package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record PinChatMessage(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "pinChatMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static PinChatMessage of(ChatId chatId, long messageId) {
        return new PinChatMessage(null, chatId, messageId, null);
    }
}
