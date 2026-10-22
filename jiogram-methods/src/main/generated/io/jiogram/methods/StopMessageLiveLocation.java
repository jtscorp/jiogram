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
 * Use this method to stop updating a live location message before live_period expires. On success,
 * if the message is not an inline message, the edited Message is returned, otherwise True is
 * returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#stopmessagelivelocation">stopMessageLiveLocation in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StopMessageLiveLocation implements TelegramMethod<Message> {

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
     * Creates a new {@code StopMessageLiveLocation} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message to be edited was sent
     * @param chatId Required if inline_message_id is not specified. Unique identifier for the
     *     target chat or username of the target channel (in the format &#64;channelusername)
     * @param messageId Required if inline_message_id is not specified. Identifier of the message
     *     with live location to stop
     * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of
     *     the inline message
     * @param replyMarkup A JSON-serialized object for a new inline keyboard.
     */
    @JsonCreator
    public StopMessageLiveLocation(
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
        return "stopMessageLiveLocation";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static StopMessageLiveLocation of() {
        return new StopMessageLiveLocation(null, null, null, null, null);
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
     * Required if inline_message_id is not specified. Identifier of the message with live location
     * to stop
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
     * A JSON-serialized object for a new inline keyboard.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    public StopMessageLiveLocation withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new StopMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }

    public StopMessageLiveLocation withChatId(@Nullable ChatId chatId) {
        return new StopMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }

    public StopMessageLiveLocation withMessageId(@Nullable Long messageId) {
        return new StopMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }

    public StopMessageLiveLocation withInlineMessageId(@Nullable String inlineMessageId) {
        return new StopMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }

    public StopMessageLiveLocation withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new StopMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StopMessageLiveLocation)) {
            return false;
        }
        StopMessageLiveLocation that = (StopMessageLiveLocation) o;
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
        return "StopMessageLiveLocation[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", inlineMessageId=" + this.inlineMessageId
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
