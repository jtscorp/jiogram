package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputChecklist;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

public record SendChecklist(
    @JsonProperty("business_connection_id") String businessConnectionId,
    @JsonProperty("chat_id") long chatId,
    @JsonProperty("checklist") InputChecklist checklist,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("message_effect_id") @Nullable String messageEffectId,
    @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Message> {

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
