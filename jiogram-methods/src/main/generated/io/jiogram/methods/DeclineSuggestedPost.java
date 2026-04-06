package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record DeclineSuggestedPost(
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("comment") @Nullable String comment
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "declineSuggestedPost";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static DeclineSuggestedPost of(long chatId, long messageId) {
        return new DeclineSuggestedPost(chatId, messageId, null);
    }
}
