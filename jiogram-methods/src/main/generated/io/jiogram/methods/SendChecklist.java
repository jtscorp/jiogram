package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputChecklist;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send a checklist on behalf of a connected business account. On success, the
 * sent Message is returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be sent
 * @param chatId Unique identifier for the target chat
 * @param checklist A JSON-serialized object for the checklist to send
 * @param disableNotification Sends the message silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the sent message from forwarding and saving
 * @param messageEffectId Unique identifier of the message effect to be added to the message
 * @param replyParameters A JSON-serialized object for description of the message to reply to
 * @param replyMarkup A JSON-serialized object for an inline keyboard
 * @see <a href="https://core.telegram.org/bots/api#sendchecklist">sendChecklist in the Bot API</a>
 */
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
