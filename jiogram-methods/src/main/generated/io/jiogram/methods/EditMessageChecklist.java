package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputChecklist;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit a checklist on behalf of a connected business account. On success, the
 * edited Message is returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be sent
 * @param chatId Unique identifier for the target chat
 * @param messageId Unique identifier for the target message
 * @param checklist A JSON-serialized object for the new checklist
 * @param replyMarkup A JSON-serialized object for the new inline keyboard for the message
 * @see <a href="https://core.telegram.org/bots/api#editmessagechecklist">editMessageChecklist in the Bot API</a>
 */
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

    public EditMessageChecklist withBusinessConnectionId(String businessConnectionId) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }

    public EditMessageChecklist withChatId(long chatId) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }

    public EditMessageChecklist withMessageId(long messageId) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }

    public EditMessageChecklist withChecklist(InputChecklist checklist) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }

    public EditMessageChecklist withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new EditMessageChecklist(businessConnectionId, chatId, messageId, checklist, replyMarkup);
    }
}
