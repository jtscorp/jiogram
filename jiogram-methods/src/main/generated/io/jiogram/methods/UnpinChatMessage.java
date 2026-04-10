package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class UnpinChatMessage implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_id") @Nullable private final Long messageId;

    @JsonCreator
    public UnpinChatMessage(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_id") @Nullable Long messageId
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Long messageId() {
        return this.messageId;
    }

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
