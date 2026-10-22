package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit only the reply markup of messages. On success, if the edited message is
 * not an inline message, the edited Message is returned, otherwise True is returned. Note that
 * business messages that were not sent by the bot and do not contain an inline keyboard can only be
 * edited within 48 hours from the time they were sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagereplymarkup">editMessageReplyMarkup in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditMessageReplyMarkup implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final @Nullable ChatId chatId;

    @JsonProperty("message_id")
    private final @Nullable Long messageId;

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code EditMessageReplyMarkup} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message to be edited was sent
     * @param chatId Required if inline_message_id is not specified. Unique identifier for the
     *     target chat or username of the target channel (in the format &#64;channelusername)
     * @param messageId Required if inline_message_id is not specified. Identifier of the message to
     *     edit
     * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of
     *     the inline message
     * @param replyMarkup A JSON-serialized object for an inline keyboard.
     */
    @JsonCreator
    public EditMessageReplyMarkup(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.replyMarkup = replyMarkup;
    }

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

    /**
     * Unique identifier of the business connection on behalf of which the message to be edited was
     * sent
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Required if inline_message_id is not specified. Unique identifier for the target chat or
     * username of the target channel (in the format &#64;channelusername)
     */
    public @Nullable ChatId chatId() {
        return chatId;
    }

    /**
     * Required if inline_message_id is not specified. Identifier of the message to edit
     */
    public @Nullable Long messageId() {
        return messageId;
    }

    /**
     * Required if chat_id and message_id are not specified. Identifier of the inline message
     */
    public @Nullable String inlineMessageId() {
        return inlineMessageId;
    }

    /**
     * A JSON-serialized object for an inline keyboard.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditMessageReplyMarkup)) {
            return false;
        }
        EditMessageReplyMarkup that = (EditMessageReplyMarkup) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageId, that.messageId)
                && Objects.equals(this.inlineMessageId, that.inlineMessageId)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId, this.inlineMessageId, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "EditMessageReplyMarkup[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", inlineMessageId=" + this.inlineMessageId
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
