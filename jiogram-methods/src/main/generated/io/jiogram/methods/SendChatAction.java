package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatAction;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SendChatAction implements TelegramMethod<Boolean> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("action") private final ChatAction action;

    @JsonCreator
    public SendChatAction(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("action") ChatAction action
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.action = action;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Long messageThreadId() {
        return this.messageThreadId;
    }

    public ChatAction action() {
        return this.action;
    }

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
