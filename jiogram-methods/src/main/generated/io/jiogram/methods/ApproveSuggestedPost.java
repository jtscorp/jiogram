package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record ApproveSuggestedPost(
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("send_date") @Nullable Long sendDate
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "approveSuggestedPost";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    public static ApproveSuggestedPost of(long chatId, long messageId) {
        return new ApproveSuggestedPost(chatId, messageId, null);
    }
}
