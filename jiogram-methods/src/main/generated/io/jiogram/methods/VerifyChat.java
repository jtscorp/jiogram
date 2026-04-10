package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class VerifyChat implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("custom_description") @Nullable private final String customDescription;

    @JsonCreator
    public VerifyChat(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("custom_description") @Nullable String customDescription
    ) {
        this.chatId = chatId;
        this.customDescription = customDescription;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public String customDescription() {
        return this.customDescription;
    }

    @Override
    public String apiMethod() {
        return "verifyChat";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static VerifyChat of(ChatId chatId) {
        return new VerifyChat(chatId, null);
    }
}
