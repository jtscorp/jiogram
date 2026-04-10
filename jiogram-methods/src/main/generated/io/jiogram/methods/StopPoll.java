package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Poll;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class StopPoll implements TelegramMethod<Poll> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") private final ChatId chatId;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public StopPoll(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.replyMarkup = replyMarkup;
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

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "stopPoll";
    }

    @Override
    public String apiReturnType() {
        return "Poll";
    }

    public static StopPoll of(ChatId chatId, long messageId) {
        return new StopPoll(null, chatId, messageId, null);
    }
}
