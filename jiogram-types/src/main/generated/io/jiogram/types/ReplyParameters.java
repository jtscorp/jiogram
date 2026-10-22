package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes reply parameters for the message that is being sent.
 *
 * @param messageId Identifier of the message that will be replied to in the current chat, or in the
 *     chat chat_id if it is specified
 * @param chatId If the message to be replied to is from a different chat, unique identifier for the
 *     chat or username of the channel (in the format &#64;channelusername). Not supported for
 *     messages sent on behalf of a business account and messages from channel direct messages
 *     chats.
 * @param allowSendingWithoutReply Pass True if the message should be sent even if the specified
 *     message to be replied to is not found. Always False for replies in another chat or forum
 *     topic. Always True for messages sent on behalf of a business account.
 * @param quote Quoted part of the message to be replied to; 0-1024 characters after entities
 *     parsing. The quote must be an exact substring of the message to be replied to, including
 *     bold, italic, underline, strikethrough, spoiler, custom_emoji, and date_time entities. The
 *     message will fail to send if the quote isn't found in the original message.
 * @param quoteParseMode Mode for parsing entities in the quote. See formatting options for more
 *     details.
 * @param quoteEntities A JSON-serialized list of special entities that appear in the quote. It can
 *     be specified instead of quote_parse_mode.
 * @param quotePosition Position of the quote in the original message in UTF-16 code units
 * @param checklistTaskId Identifier of the specific checklist task to be replied to
 * @param pollOptionId Persistent identifier of the specific poll option to be replied to
 * @see <a href="https://core.telegram.org/bots/api#replyparameters">ReplyParameters in the Bot API</a>
 */
public record ReplyParameters(
    @JsonProperty("message_id") long messageId,
    @JsonProperty("chat_id") @Nullable ChatId chatId,
    @JsonProperty("allow_sending_without_reply") @Nullable Boolean allowSendingWithoutReply,
    @JsonProperty("quote") @Nullable String quote,
    @JsonProperty("quote_parse_mode") @Nullable ParseMode quoteParseMode,
    @JsonProperty("quote_entities") @Nullable List<MessageEntity> quoteEntities,
    @JsonProperty("quote_position") @Nullable Long quotePosition,
    @JsonProperty("checklist_task_id") @Nullable Long checklistTaskId,
    @JsonProperty("poll_option_id") @Nullable String pollOptionId
) {

    public static ReplyParameters of(long messageId) {
        return new ReplyParameters(messageId, null, null, null, null, null, null, null, null);
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
}
