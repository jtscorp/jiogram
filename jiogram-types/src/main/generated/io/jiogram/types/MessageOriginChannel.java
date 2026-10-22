package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageOriginType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * The message was originally sent to a channel chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#messageoriginchannel">MessageOriginChannel in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MessageOriginChannel implements MessageOrigin {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final MessageOriginType type;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("author_signature")
    private final @Nullable String authorSignature;

    /**
     * Creates a new {@code MessageOriginChannel} instance.
     *
     * @param type Type of the message origin, always 'channel'
     * @param date Date the message was sent originally in Unix time
     * @param chat Channel chat to which the message was originally sent
     * @param messageId Unique message identifier inside the chat
     * @param authorSignature Signature of the original post author
     */
    @JsonCreator
    public MessageOriginChannel(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MessageOriginType type,
            @JsonProperty("date") long date,
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("author_signature") @Nullable String authorSignature) {
        this.type = type;
        this.date = date;
        this.chat = chat;
        this.messageId = messageId;
        this.authorSignature = authorSignature;
    }

    public static MessageOriginChannel of(long date, Chat chat, long messageId) {
        return new MessageOriginChannel(MessageOriginType.CHANNEL, date, chat, messageId, null);
    }

    /**
     * Type of the message origin, always 'channel'
     */
    public MessageOriginType type() {
        return type;
    }

    /**
     * Date the message was sent originally in Unix time
     */
    public long date() {
        return date;
    }

    /**
     * Channel chat to which the message was originally sent
     */
    public Chat chat() {
        return chat;
    }

    /**
     * Unique message identifier inside the chat
     */
    public long messageId() {
        return messageId;
    }

    /**
     * Signature of the original post author
     */
    public @Nullable String authorSignature() {
        return authorSignature;
    }

    public MessageOriginChannel withDate(long date) {
        return new MessageOriginChannel(type, date, chat, messageId, authorSignature);
    }

    public MessageOriginChannel withChat(Chat chat) {
        return new MessageOriginChannel(type, date, chat, messageId, authorSignature);
    }

    public MessageOriginChannel withMessageId(long messageId) {
        return new MessageOriginChannel(type, date, chat, messageId, authorSignature);
    }

    public MessageOriginChannel withAuthorSignature(@Nullable String authorSignature) {
        return new MessageOriginChannel(type, date, chat, messageId, authorSignature);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageOriginChannel)) {
            return false;
        }
        MessageOriginChannel that = (MessageOriginChannel) o;
        return Objects.equals(this.type, that.type)
                && this.date == that.date
                && Objects.equals(this.chat, that.chat)
                && this.messageId == that.messageId
                && Objects.equals(this.authorSignature, that.authorSignature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.date, this.chat, this.messageId, this.authorSignature);
    }

    @Override
    public String toString() {
        return "MessageOriginChannel[type=" + this.type
                + ", date=" + this.date
                + ", chat=" + this.chat
                + ", messageId=" + this.messageId
                + ", authorSignature=" + this.authorSignature
                + "]";
    }
}
