package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputChecklist;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record EditMessageChecklist(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("checklist") InputChecklist checklist,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Message> {

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
