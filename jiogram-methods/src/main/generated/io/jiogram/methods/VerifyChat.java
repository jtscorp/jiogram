package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record VerifyChat(
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("custom_description") @Nullable String customDescription
) implements TelegramMethod<Boolean> {

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
