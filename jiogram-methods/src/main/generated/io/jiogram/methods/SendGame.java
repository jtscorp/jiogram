package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SendGame implements TelegramMethod<Message> {
    @JsonProperty("business_connection_id") @Nullable private final String businessConnectionId;
    @JsonProperty("chat_id") private final long chatId;
    @JsonProperty("message_thread_id") @Nullable private final Long messageThreadId;
    @JsonProperty("game_short_name") private final String gameShortName;
    @JsonProperty("disable_notification") @Nullable private final Boolean disableNotification;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;
    @JsonProperty("allow_paid_broadcast") @Nullable private final Boolean allowPaidBroadcast;
    @JsonProperty("message_effect_id") @Nullable private final String messageEffectId;
    @JsonProperty("reply_parameters") @Nullable private final ReplyParameters replyParameters;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public SendGame(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("game_short_name") String gameShortName,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.gameShortName = gameShortName;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.messageEffectId = messageEffectId;
        this.replyParameters = replyParameters;
        this.replyMarkup = replyMarkup;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public long chatId() {
        return this.chatId;
    }

    public Long messageThreadId() {
        return this.messageThreadId;
    }

    public String gameShortName() {
        return this.gameShortName;
    }

    public Boolean disableNotification() {
        return this.disableNotification;
    }

    public Boolean protectContent() {
        return this.protectContent;
    }

    public Boolean allowPaidBroadcast() {
        return this.allowPaidBroadcast;
    }

    public String messageEffectId() {
        return this.messageEffectId;
    }

    public ReplyParameters replyParameters() {
        return this.replyParameters;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "sendGame";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendGame of(long chatId, String gameShortName) {
        return new SendGame(null, chatId, null, gameShortName, null, null, null, null, null, null);
    }
}
