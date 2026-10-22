package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes reply parameters for the message that is being sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#replyparameters">ReplyParameters in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReplyParameters {

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("chat_id")
    private final @Nullable ChatId chatId;

    @JsonProperty("allow_sending_without_reply")
    private final @Nullable Boolean allowSendingWithoutReply;

    @JsonProperty("quote")
    private final @Nullable String quote;

    @JsonProperty("quote_parse_mode")
    private final @Nullable ParseMode quoteParseMode;

    @JsonProperty("quote_entities")
    private final @Nullable List<MessageEntity> quoteEntities;

    @JsonProperty("quote_position")
    private final @Nullable Long quotePosition;

    @JsonProperty("checklist_task_id")
    private final @Nullable Long checklistTaskId;

    @JsonProperty("poll_option_id")
    private final @Nullable String pollOptionId;

    /**
     * Creates a new {@code ReplyParameters} instance.
     *
     * @param messageId Identifier of the message that will be replied to in the current chat, or in
     *     the chat chat_id if it is specified
     * @param chatId If the message to be replied to is from a different chat, unique identifier for
     *     the chat or username of the channel (in the format &#64;channelusername). Not supported
     *     for messages sent on behalf of a business account and messages from channel direct
     *     messages chats.
     * @param allowSendingWithoutReply Pass True if the message should be sent even if the specified
     *     message to be replied to is not found. Always False for replies in another chat or forum
     *     topic. Always True for messages sent on behalf of a business account.
     * @param quote Quoted part of the message to be replied to; 0-1024 characters after entities
     *     parsing. The quote must be an exact substring of the message to be replied to, including
     *     bold, italic, underline, strikethrough, spoiler, custom_emoji, and date_time entities.
     *     The message will fail to send if the quote isn't found in the original message.
     * @param quoteParseMode Mode for parsing entities in the quote. See formatting options for more
     *     details.
     * @param quoteEntities A JSON-serialized list of special entities that appear in the quote. It
     *     can be specified instead of quote_parse_mode.
     * @param quotePosition Position of the quote in the original message in UTF-16 code units
     * @param checklistTaskId Identifier of the specific checklist task to be replied to
     * @param pollOptionId Persistent identifier of the specific poll option to be replied to
     */
    @JsonCreator
    public ReplyParameters(
            @JsonProperty("message_id") long messageId,
            @JsonProperty("chat_id") @Nullable ChatId chatId,
            @JsonProperty("allow_sending_without_reply") @Nullable Boolean allowSendingWithoutReply,
            @JsonProperty("quote") @Nullable String quote,
            @JsonProperty("quote_parse_mode") @Nullable ParseMode quoteParseMode,
            @JsonProperty("quote_entities") @Nullable List<MessageEntity> quoteEntities,
            @JsonProperty("quote_position") @Nullable Long quotePosition,
            @JsonProperty("checklist_task_id") @Nullable Long checklistTaskId,
            @JsonProperty("poll_option_id") @Nullable String pollOptionId) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.allowSendingWithoutReply = allowSendingWithoutReply;
        this.quote = quote;
        this.quoteParseMode = quoteParseMode;
        this.quoteEntities = quoteEntities;
        this.quotePosition = quotePosition;
        this.checklistTaskId = checklistTaskId;
        this.pollOptionId = pollOptionId;
    }

    public static ReplyParameters of(long messageId) {
        return new ReplyParameters(messageId, null, null, null, null, null, null, null, null);
    }

    /**
     * Identifier of the message that will be replied to in the current chat, or in the chat chat_id
     * if it is specified
     */
    public long messageId() {
        return messageId;
    }

    /**
     * If the message to be replied to is from a different chat, unique identifier for the chat or
     * username of the channel (in the format &#64;channelusername). Not supported for messages sent
     * on behalf of a business account and messages from channel direct messages chats.
     */
    public @Nullable ChatId chatId() {
        return chatId;
    }

    /**
     * Pass True if the message should be sent even if the specified message to be replied to is not
     * found. Always False for replies in another chat or forum topic. Always True for messages sent
     * on behalf of a business account.
     */
    public @Nullable Boolean allowSendingWithoutReply() {
        return allowSendingWithoutReply;
    }

    /**
     * Quoted part of the message to be replied to; 0-1024 characters after entities parsing. The
     * quote must be an exact substring of the message to be replied to, including bold, italic,
     * underline, strikethrough, spoiler, custom_emoji, and date_time entities. The message will
     * fail to send if the quote isn't found in the original message.
     */
    public @Nullable String quote() {
        return quote;
    }

    /**
     * Mode for parsing entities in the quote. See formatting options for more details.
     */
    public @Nullable ParseMode quoteParseMode() {
        return quoteParseMode;
    }

    /**
     * A JSON-serialized list of special entities that appear in the quote. It can be specified
     * instead of quote_parse_mode.
     */
    public @Nullable List<MessageEntity> quoteEntities() {
        return quoteEntities;
    }

    /**
     * Position of the quote in the original message in UTF-16 code units
     */
    public @Nullable Long quotePosition() {
        return quotePosition;
    }

    /**
     * Identifier of the specific checklist task to be replied to
     */
    public @Nullable Long checklistTaskId() {
        return checklistTaskId;
    }

    /**
     * Persistent identifier of the specific poll option to be replied to
     */
    public @Nullable String pollOptionId() {
        return pollOptionId;
    }

    public ReplyParameters withMessageId(long messageId) {
        return new ReplyParameters(messageId, chatId, allowSendingWithoutReply, quote, quoteParseMode, quoteEntities, quotePosition, checklistTaskId, pollOptionId);
    }

    public ReplyParameters withChatId(@Nullable ChatId chatId) {
        return new ReplyParameters(messageId, chatId, allowSendingWithoutReply, quote, quoteParseMode, quoteEntities, quotePosition, checklistTaskId, pollOptionId);
    }

    public ReplyParameters withAllowSendingWithoutReply(@Nullable Boolean allowSendingWithoutReply) {
        return new ReplyParameters(messageId, chatId, allowSendingWithoutReply, quote, quoteParseMode, quoteEntities, quotePosition, checklistTaskId, pollOptionId);
    }

    public ReplyParameters withQuote(@Nullable String quote) {
        return new ReplyParameters(messageId, chatId, allowSendingWithoutReply, quote, quoteParseMode, quoteEntities, quotePosition, checklistTaskId, pollOptionId);
    }

    public ReplyParameters withQuoteParseMode(@Nullable ParseMode quoteParseMode) {
        return new ReplyParameters(messageId, chatId, allowSendingWithoutReply, quote, quoteParseMode, quoteEntities, quotePosition, checklistTaskId, pollOptionId);
    }

    public ReplyParameters withQuoteEntities(@Nullable List<MessageEntity> quoteEntities) {
        return new ReplyParameters(messageId, chatId, allowSendingWithoutReply, quote, quoteParseMode, quoteEntities, quotePosition, checklistTaskId, pollOptionId);
    }

    public ReplyParameters withQuotePosition(@Nullable Long quotePosition) {
        return new ReplyParameters(messageId, chatId, allowSendingWithoutReply, quote, quoteParseMode, quoteEntities, quotePosition, checklistTaskId, pollOptionId);
    }

    public ReplyParameters withChecklistTaskId(@Nullable Long checklistTaskId) {
        return new ReplyParameters(messageId, chatId, allowSendingWithoutReply, quote, quoteParseMode, quoteEntities, quotePosition, checklistTaskId, pollOptionId);
    }

    public ReplyParameters withPollOptionId(@Nullable String pollOptionId) {
        return new ReplyParameters(messageId, chatId, allowSendingWithoutReply, quote, quoteParseMode, quoteEntities, quotePosition, checklistTaskId, pollOptionId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReplyParameters)) {
            return false;
        }
        ReplyParameters that = (ReplyParameters) o;
        return this.messageId == that.messageId
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.allowSendingWithoutReply, that.allowSendingWithoutReply)
                && Objects.equals(this.quote, that.quote)
                && Objects.equals(this.quoteParseMode, that.quoteParseMode)
                && Objects.equals(this.quoteEntities, that.quoteEntities)
                && Objects.equals(this.quotePosition, that.quotePosition)
                && Objects.equals(this.checklistTaskId, that.checklistTaskId)
                && Objects.equals(this.pollOptionId, that.pollOptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.messageId, this.chatId, this.allowSendingWithoutReply, this.quote, this.quoteParseMode, this.quoteEntities, this.quotePosition, this.checklistTaskId, this.pollOptionId);
    }

    @Override
    public String toString() {
        return "ReplyParameters[messageId=" + this.messageId
                + ", chatId=" + this.chatId
                + ", allowSendingWithoutReply=" + this.allowSendingWithoutReply
                + ", quote=" + this.quote
                + ", quoteParseMode=" + this.quoteParseMode
                + ", quoteEntities=" + this.quoteEntities
                + ", quotePosition=" + this.quotePosition
                + ", checklistTaskId=" + this.checklistTaskId
                + ", pollOptionId=" + this.pollOptionId
                + "]";
    }
}
