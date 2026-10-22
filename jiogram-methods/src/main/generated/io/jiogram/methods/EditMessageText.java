package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.Message;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit text and game messages. On success, if the edited message is not an
 * inline message, the edited Message is returned, otherwise True is returned. Note that business
 * messages that were not sent by the bot and do not contain an inline keyboard can only be edited
 * within 48 hours from the time they were sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagetext">editMessageText in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditMessageText implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final @Nullable ChatId chatId;

    @JsonProperty("message_id")
    private final @Nullable Long messageId;

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    @JsonProperty("text")
    private final String text;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("entities")
    private final @Nullable List<MessageEntity> entities;

    @JsonProperty("link_preview_options")
    private final @Nullable LinkPreviewOptions linkPreviewOptions;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code EditMessageText} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message to be edited was sent
     * @param chatId Required if inline_message_id is not specified. Unique identifier for the
     *     target chat or username of the target channel (in the format &#64;channelusername)
     * @param messageId Required if inline_message_id is not specified. Identifier of the message to
     *     edit
     * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of
     *     the inline message
     * @param text New text of the message, 1-4096 characters after entities parsing
     * @param parseMode Mode for parsing entities in the message text. See formatting options for
     *     more details.
     * @param entities A JSON-serialized list of special entities that appear in message text, which
     *     can be specified instead of parse_mode
     * @param linkPreviewOptions Link preview generation options for the message
     * @param replyMarkup A JSON-serialized object for an inline keyboard.
     */
    @JsonCreator
    public EditMessageText(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("message_id") @Nullable Long messageId,
            @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
            @JsonProperty("text") String text,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("entities") @Nullable List<MessageEntity> entities,
            @JsonProperty("link_preview_options") @Nullable LinkPreviewOptions linkPreviewOptions,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.text = text;
        this.parseMode = parseMode;
        this.entities = entities;
        this.linkPreviewOptions = linkPreviewOptions;
        this.replyMarkup = replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "editMessageText";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static EditMessageText of(String text) {
        return new EditMessageText(null, null, null, null, text, null, null, null, null);
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
     * New text of the message, 1-4096 characters after entities parsing
     */
    public String text() {
        return text;
    }

    /**
     * Mode for parsing entities in the message text. See formatting options for more details.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * A JSON-serialized list of special entities that appear in message text, which can be
     * specified instead of parse_mode
     */
    public @Nullable List<MessageEntity> entities() {
        return entities;
    }

    /**
     * Link preview generation options for the message
     */
    public @Nullable LinkPreviewOptions linkPreviewOptions() {
        return linkPreviewOptions;
    }

    /**
     * A JSON-serialized object for an inline keyboard.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    public EditMessageText withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new EditMessageText(businessConnectionId, chatId, messageId, inlineMessageId, text, parseMode, entities, linkPreviewOptions, replyMarkup);
    }

    public EditMessageText withChatId(@Nullable ChatId chatId) {
        return new EditMessageText(businessConnectionId, chatId, messageId, inlineMessageId, text, parseMode, entities, linkPreviewOptions, replyMarkup);
    }

    public EditMessageText withMessageId(@Nullable Long messageId) {
        return new EditMessageText(businessConnectionId, chatId, messageId, inlineMessageId, text, parseMode, entities, linkPreviewOptions, replyMarkup);
    }

    public EditMessageText withInlineMessageId(@Nullable String inlineMessageId) {
        return new EditMessageText(businessConnectionId, chatId, messageId, inlineMessageId, text, parseMode, entities, linkPreviewOptions, replyMarkup);
    }

    public EditMessageText withText(String text) {
        return new EditMessageText(businessConnectionId, chatId, messageId, inlineMessageId, text, parseMode, entities, linkPreviewOptions, replyMarkup);
    }

    public EditMessageText withParseMode(@Nullable ParseMode parseMode) {
        return new EditMessageText(businessConnectionId, chatId, messageId, inlineMessageId, text, parseMode, entities, linkPreviewOptions, replyMarkup);
    }

    public EditMessageText withEntities(@Nullable List<MessageEntity> entities) {
        return new EditMessageText(businessConnectionId, chatId, messageId, inlineMessageId, text, parseMode, entities, linkPreviewOptions, replyMarkup);
    }

    public EditMessageText withLinkPreviewOptions(@Nullable LinkPreviewOptions linkPreviewOptions) {
        return new EditMessageText(businessConnectionId, chatId, messageId, inlineMessageId, text, parseMode, entities, linkPreviewOptions, replyMarkup);
    }

    public EditMessageText withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new EditMessageText(businessConnectionId, chatId, messageId, inlineMessageId, text, parseMode, entities, linkPreviewOptions, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditMessageText)) {
            return false;
        }
        EditMessageText that = (EditMessageText) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageId, that.messageId)
                && Objects.equals(this.inlineMessageId, that.inlineMessageId)
                && Objects.equals(this.text, that.text)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.entities, that.entities)
                && Objects.equals(this.linkPreviewOptions, that.linkPreviewOptions)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId, this.inlineMessageId, this.text, this.parseMode, this.entities, this.linkPreviewOptions, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "EditMessageText[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", inlineMessageId=" + this.inlineMessageId
                + ", text=" + this.text
                + ", parseMode=" + this.parseMode
                + ", entities=" + this.entities
                + ", linkPreviewOptions=" + this.linkPreviewOptions
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
