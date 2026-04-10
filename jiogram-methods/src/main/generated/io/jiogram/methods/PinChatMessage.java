package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class PinChatMessage implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("disable_notification") @Nullable private final Boolean disableNotification;

    @JsonCreator
    public PinChatMessage(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.disableNotification = disableNotification;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public long messageId() {
        return this.messageId;
    }

    public Boolean disableNotification() {
        return this.disableNotification;
    }

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
