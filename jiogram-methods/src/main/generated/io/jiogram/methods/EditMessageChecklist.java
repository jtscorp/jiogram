package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputChecklist;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public class EditMessageChecklist implements TelegramMethod<Message> {
    @JsonProperty("business_connection_id") private final String businessConnectionId;
    @JsonProperty("chat_id") private final long chatId;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("checklist") private final InputChecklist checklist;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;

    @JsonCreator
    public EditMessageChecklist(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("checklist") InputChecklist checklist,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
    ) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.checklist = checklist;
        this.replyMarkup = replyMarkup;
    }

    public String businessConnectionId() {
        return this.businessConnectionId;
    }

    public long chatId() {
        return this.chatId;
    }

    public long messageId() {
        return this.messageId;
    }

    public InputChecklist checklist() {
        return this.checklist;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "editMessageChecklist";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static EditMessageChecklist of(String businessConnectionId, long chatId, long messageId, InputChecklist checklist) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, null);
    }
}
