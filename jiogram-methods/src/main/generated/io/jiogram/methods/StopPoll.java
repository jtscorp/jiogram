package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Poll;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record StopPoll(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Poll> {

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
