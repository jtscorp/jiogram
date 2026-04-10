package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class DeclineSuggestedPost implements TelegramMethod<Boolean> {
    @JsonProperty("chat_id") private final long chatId;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("comment") @Nullable private final String comment;

    @JsonCreator
    public DeclineSuggestedPost(
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("comment") @Nullable String comment
    ) {
        this.chatId = chatId;
        this.messageId = messageId;
        this.comment = comment;
    }

    public long chatId() {
        return this.chatId;
    }

    public long messageId() {
        return this.messageId;
    }

    public String comment() {
        return this.comment;
    }

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
