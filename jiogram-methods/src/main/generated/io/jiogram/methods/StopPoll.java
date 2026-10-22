package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Poll;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to stop a poll which was sent by the bot. On success, the stopped Poll is
 * returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#stoppoll">stopPoll in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StopPoll implements TelegramMethod<Poll> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code StopPoll} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message to be edited was sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageId Identifier of the original message with the poll
     * @param replyMarkup A JSON-serialized object for a new message inline keyboard.
     */
    @JsonCreator
    public StopPoll(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.replyMarkup = replyMarkup;
    }

    @Override
    public String apiMethod() {
        return "stopPoll";
    }

    @Override
    public String apiReturnType() {
        return "Poll";
    }

    public static StopPoll of(ChatId chatId, long messageId) {
        return new StopPoll(null, chatId, messageId, null);
    }

    /**
     * Unique identifier of the business connection on behalf of which the message to be edited was
     * sent
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Identifier of the original message with the poll
     */
    public long messageId() {
        return messageId;
    }

    /**
     * A JSON-serialized object for a new message inline keyboard.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    public StopPoll withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new StopPoll(businessConnectionId, chatId, messageId, replyMarkup);
    }

    public StopPoll withChatId(ChatId chatId) {
        return new StopPoll(businessConnectionId, chatId, messageId, replyMarkup);
    }

    public StopPoll withMessageId(long messageId) {
        return new StopPoll(businessConnectionId, chatId, messageId, replyMarkup);
    }

    public StopPoll withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new StopPoll(businessConnectionId, chatId, messageId, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StopPoll)) {
            return false;
        }
        StopPoll that = (StopPoll) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && this.messageId == that.messageId
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "StopPoll[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
