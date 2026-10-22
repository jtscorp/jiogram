package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ReactionCount;
import java.util.List;
import java.util.Objects;

/**
 * This object represents reaction changes on a message with anonymous reactions.
 *
 * @see <a href="https://core.telegram.org/bots/api#messagereactioncountupdated">MessageReactionCountUpdated in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MessageReactionCountUpdated {

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("reactions")
    private final List<ReactionCount> reactions;

    /**
     * Creates a new {@code MessageReactionCountUpdated} instance.
     *
     * @param chat The chat containing the message
     * @param messageId Unique message identifier inside the chat
     * @param date Date of the change in Unix time
     * @param reactions List of reactions that are present on the message
     */
    @JsonCreator
    public MessageReactionCountUpdated(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("date") long date,
            @JsonProperty("reactions") List<ReactionCount> reactions) {
        this.chat = chat;
        this.messageId = messageId;
        this.date = date;
        this.reactions = reactions;
    }

    /**
     * The chat containing the message
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
     * Date of the change in Unix time
     */
    public long date() {
        return date;
    }

    /**
     * List of reactions that are present on the message
     */
    public List<ReactionCount> reactions() {
        return reactions;
    }

    public MessageReactionCountUpdated withChat(Chat chat) {
        return new MessageReactionCountUpdated(chat, messageId, date, reactions);
    }

    public MessageReactionCountUpdated withMessageId(long messageId) {
        return new MessageReactionCountUpdated(chat, messageId, date, reactions);
    }

    public MessageReactionCountUpdated withDate(long date) {
        return new MessageReactionCountUpdated(chat, messageId, date, reactions);
    }

    public MessageReactionCountUpdated withReactions(List<ReactionCount> reactions) {
        return new MessageReactionCountUpdated(chat, messageId, date, reactions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageReactionCountUpdated)) {
            return false;
        }
        MessageReactionCountUpdated that = (MessageReactionCountUpdated) o;
        return Objects.equals(this.chat, that.chat)
                && this.messageId == that.messageId
                && this.date == that.date
                && Objects.equals(this.reactions, that.reactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat, this.messageId, this.date, this.reactions);
    }

    @Override
    public String toString() {
        return "MessageReactionCountUpdated[chat=" + this.chat
                + ", messageId=" + this.messageId
                + ", date=" + this.date
                + ", reactions=" + this.reactions
                + "]";
    }
}
