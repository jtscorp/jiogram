package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Marks incoming message as read on behalf of a business account. Requires the can_read_messages
 * business bot right. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#readbusinessmessage">readBusinessMessage in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ReadBusinessMessage implements TelegramMethod<Boolean> {

    @JsonProperty("business_connection_id")
    private final String businessConnectionId;

    @JsonProperty("chat_id")
    private final long chatId;

    @JsonProperty("message_id")
    private final long messageId;

    /**
     * Creates a new {@code ReadBusinessMessage} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     to read the message
     * @param chatId Unique identifier of the chat in which the message was received. The chat must
     *     have been active in the last 24 hours.
     * @param messageId Unique identifier of the message to mark as read
     */
    @JsonCreator
    public ReadBusinessMessage(
            @JsonProperty("business_connection_id") String businessConnectionId,
            @JsonProperty("chat_id") long chatId,
            @JsonProperty("message_id") long messageId) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
    }

    @Override
    public String apiMethod() {
        return "readBusinessMessage";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Unique identifier of the business connection on behalf of which to read the message
     */
    public String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier of the chat in which the message was received. The chat must have been
     * active in the last 24 hours.
     */
    public long chatId() {
        return chatId;
    }

    /**
     * Unique identifier of the message to mark as read
     */
    public long messageId() {
        return messageId;
    }

    public ReadBusinessMessage withBusinessConnectionId(String businessConnectionId) {
        return new ReadBusinessMessage(businessConnectionId, chatId, messageId);
    }

    public ReadBusinessMessage withChatId(long chatId) {
        return new ReadBusinessMessage(businessConnectionId, chatId, messageId);
    }

    public ReadBusinessMessage withMessageId(long messageId) {
        return new ReadBusinessMessage(businessConnectionId, chatId, messageId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReadBusinessMessage)) {
            return false;
        }
        ReadBusinessMessage that = (ReadBusinessMessage) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && this.chatId == that.chatId
                && this.messageId == that.messageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId);
    }

    @Override
    public String toString() {
        return "ReadBusinessMessage[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + "]";
    }
}
