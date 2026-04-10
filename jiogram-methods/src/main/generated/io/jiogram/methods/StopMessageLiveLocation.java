package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class StopMessageLiveLocation implements TelegramMethod<Message> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") @Nullable private final ChatId chatId;
    @JsonProperty("message_id") @Nullable private final Long messageId;
    @JsonProperty("inline_message_id") @Nullable private final String inlineMessageId;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public StopMessageLiveLocation(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.replyMarkup = replyMarkup;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public ChatId chatId() {
        return this.chatId;
    }

    public Long messageId() {
        return this.messageId;
    }

    public String inlineMessageId() {
        return this.inlineMessageId;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "stopMessageLiveLocation";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static StopMessageLiveLocation of() {
        return new StopMessageLiveLocation(null, null, null, null, null);
    }
}
