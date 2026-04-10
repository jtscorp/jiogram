package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputChecklist;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class SendChecklist implements TelegramMethod<Message> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("chat_id") private final long chatId;
    @JsonProperty("checklist") private final InputChecklist checklist;
    @JsonProperty("disable_notification") @Nullable private final Boolean disableNotification;
    @JsonProperty("protect_content") @Nullable private final Boolean protectContent;
    @JsonProperty("message_effect_id") @Nullable private final String messageEffectId;
    @JsonProperty("reply_parameters") @Nullable private final ReplyParameters replyParameters;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public SendChecklist(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("checklist") InputChecklist checklist,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.checklist = checklist;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
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

    public InputChecklist checklist() {
        return this.checklist;
    }

    public Boolean disableNotification() {
        return this.disableNotification;
    }

    public Boolean protectContent() {
        return this.protectContent;
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
        return "sendChecklist";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendChecklist of(String businessConnectionId, long chatId, InputChecklist checklist) {
        return new SendChecklist(businessConnectionId, chatId, checklist, null, null, null, null, null);
    }
}
