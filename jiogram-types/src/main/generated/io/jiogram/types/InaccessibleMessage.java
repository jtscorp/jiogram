package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import java.util.Objects;

/**
 * This object describes a message that was deleted or is otherwise inaccessible to the bot.
 *
 * @see <a href="https://core.telegram.org/bots/api#inaccessiblemessage">InaccessibleMessage in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InaccessibleMessage implements MaybeInaccessibleMessage {

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("date")
    private final long date;

    /**
     * Creates a new {@code InaccessibleMessage} instance.
     *
     * @param chat Chat the message belonged to
     * @param messageId Unique message identifier inside the chat
     * @param date Always 0. The field can be used to differentiate regular and inaccessible
     *     messages.
     */
    @JsonCreator
    public InaccessibleMessage(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("date") long date) {
        this.chat = chat;
        this.messageId = messageId;
        this.date = date;
    }

    /**
     * Chat the message belonged to
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
     * Always 0. The field can be used to differentiate regular and inaccessible messages.
     */
    public long date() {
        return date;
    }

    public InaccessibleMessage withChat(Chat chat) {
        return new InaccessibleMessage(chat, messageId, date);
    }

    public InaccessibleMessage withMessageId(long messageId) {
        return new InaccessibleMessage(chat, messageId, date);
    }

    public InaccessibleMessage withDate(long date) {
        return new InaccessibleMessage(chat, messageId, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InaccessibleMessage)) {
            return false;
        }
        InaccessibleMessage that = (InaccessibleMessage) o;
        return Objects.equals(this.chat, that.chat)
                && this.messageId == that.messageId
                && this.date == that.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat, this.messageId, this.date);
    }

    @Override
    public String toString() {
        return "InaccessibleMessage[chat=" + this.chat
                + ", messageId=" + this.messageId
                + ", date=" + this.date
                + "]";
    }
}
