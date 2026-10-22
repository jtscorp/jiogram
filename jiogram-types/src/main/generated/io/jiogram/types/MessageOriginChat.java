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
 * The message was originally sent on behalf of a chat to a group chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#messageoriginchat">MessageOriginChat in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MessageOriginChat implements MessageOrigin {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final MessageOriginType type;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("sender_chat")
    private final Chat senderChat;

    @JsonProperty("author_signature")
    private final @Nullable String authorSignature;

    /**
     * Creates a new {@code MessageOriginChat} instance.
     *
     * @param type Type of the message origin, always 'chat'
     * @param date Date the message was sent originally in Unix time
     * @param senderChat Chat that sent the message originally
     * @param authorSignature For messages originally sent by an anonymous chat administrator,
     *     original message author signature
     */
    @JsonCreator
    public MessageOriginChat(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MessageOriginType type,
            @JsonProperty("date") long date,
            @JsonProperty("sender_chat") Chat senderChat,
            @JsonProperty("author_signature") @Nullable String authorSignature) {
        this.type = type;
        this.date = date;
        this.senderChat = senderChat;
        this.authorSignature = authorSignature;
    }

    public static MessageOriginChat of(long date, Chat senderChat) {
        return new MessageOriginChat(MessageOriginType.CHAT, date, senderChat, null);
    }

    /**
     * Type of the message origin, always 'chat'
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
     * Chat that sent the message originally
     */
    public Chat senderChat() {
        return senderChat;
    }

    /**
     * For messages originally sent by an anonymous chat administrator, original message author
     * signature
     */
    public @Nullable String authorSignature() {
        return authorSignature;
    }

    public MessageOriginChat withDate(long date) {
        return new MessageOriginChat(type, date, senderChat, authorSignature);
    }

    public MessageOriginChat withSenderChat(Chat senderChat) {
        return new MessageOriginChat(type, date, senderChat, authorSignature);
    }

    public MessageOriginChat withAuthorSignature(@Nullable String authorSignature) {
        return new MessageOriginChat(type, date, senderChat, authorSignature);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageOriginChat)) {
            return false;
        }
        MessageOriginChat that = (MessageOriginChat) o;
        return Objects.equals(this.type, that.type)
                && this.date == that.date
                && Objects.equals(this.senderChat, that.senderChat)
                && Objects.equals(this.authorSignature, that.authorSignature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.date, this.senderChat, this.authorSignature);
    }

    @Override
    public String toString() {
        return "MessageOriginChat[type=" + this.type
                + ", date=" + this.date
                + ", senderChat=" + this.senderChat
                + ", authorSignature=" + this.authorSignature
                + "]";
    }
}
