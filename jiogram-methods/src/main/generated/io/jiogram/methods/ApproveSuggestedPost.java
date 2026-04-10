package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class ApproveSuggestedPost implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final long chatId;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("send_date") @Nullable private final Long sendDate;

    @JsonCreator
    public ApproveSuggestedPost(
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("send_date") @Nullable Long sendDate
    ) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.sendDate = sendDate;
    }

    public long chatId() {
        return this.chatId;
    }

    public long messageId() {
        return this.messageId;
    }

    public Long sendDate() {
        return this.sendDate;
    }

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
