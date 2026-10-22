package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit only the reply markup of messages. On success, if the edited message is
 * not an inline message, the edited Message is returned, otherwise True is returned. Note that
 * business messages that were not sent by the bot and do not contain an inline keyboard can only be
 * edited within 48 hours from the time they were sent.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message to be edited was sent
 * @param chatId Required if inline_message_id is not specified. Unique identifier for the target
 *     chat or username of the target channel (in the format &#64;channelusername)
 * @param messageId Required if inline_message_id is not specified. Identifier of the message to
 *     edit
 * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of the
 *     inline message
 * @param replyMarkup A JSON-serialized object for an inline keyboard.
 * @see <a href="https://core.telegram.org/bots/api#editmessagereplymarkup">editMessageReplyMarkup in the Bot API</a>
 */
public record EditMessageReplyMarkup(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") @Nullable ChatId chatId,
    @JsonProperty("message_id") @Nullable Long messageId,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "editMessageReplyMarkup";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static EditMessageReplyMarkup of() {
        return new EditMessageReplyMarkup(null, null, null, null, null);
    }

    public EditMessageReplyMarkup withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new EditMessageReplyMarkup(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }

    public EditMessageReplyMarkup withChatId(@Nullable ChatId chatId) {
        return new EditMessageReplyMarkup(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }

    public EditMessageReplyMarkup withMessageId(@Nullable Long messageId) {
        return new EditMessageReplyMarkup(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }

    public EditMessageReplyMarkup withInlineMessageId(@Nullable String inlineMessageId) {
        return new EditMessageReplyMarkup(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }

    public EditMessageReplyMarkup withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new EditMessageReplyMarkup(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }
}
