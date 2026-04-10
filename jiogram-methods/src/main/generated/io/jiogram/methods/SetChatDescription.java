package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SetChatDescription implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("description") @Nullable private final String description;

    @JsonCreator
    public SetChatDescription(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("description") @Nullable String description
    ) {
        this.chatId = chatId;
        this.description = description;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String description() {
        return this.description;
    }

    @Override
    public String apiMethod() {
        return "setChatDescription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static SetChatDescription of(ChatId chatId) {
        return new SetChatDescription(chatId, null);
    }
}
