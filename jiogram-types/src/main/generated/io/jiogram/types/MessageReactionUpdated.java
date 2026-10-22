package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ReactionType;
import io.jiogram.types.User;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a change of a reaction on a message performed by a user.
 *
 * @see <a href="https://core.telegram.org/bots/api#messagereactionupdated">MessageReactionUpdated in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class MessageReactionUpdated {

    @JsonProperty("chat")
    private final Chat chat;

    @JsonProperty("message_id")
    private final long messageId;

    @JsonProperty("user")
    private final @Nullable User user;

    @JsonProperty("actor_chat")
    private final @Nullable Chat actorChat;

    @JsonProperty("date")
    private final long date;

    @JsonProperty("old_reaction")
    private final List<ReactionType> oldReaction;

    @JsonProperty("new_reaction")
    private final List<ReactionType> newReaction;

    /**
     * Creates a new {@code MessageReactionUpdated} instance.
     *
     * @param chat The chat containing the message the user reacted to
     * @param messageId Unique identifier of the message inside the chat
     * @param user The user that changed the reaction, if the user isn't anonymous
     * @param actorChat The chat on behalf of which the reaction was changed, if the user is
     *     anonymous
     * @param date Date of the change in Unix time
     * @param oldReaction Previous list of reaction types that were set by the user
     * @param newReaction New list of reaction types that have been set by the user
     */
    @JsonCreator
    public MessageReactionUpdated(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("user") @Nullable User user,
            @JsonProperty("actor_chat") @Nullable Chat actorChat,
            @JsonProperty("date") long date,
            @JsonProperty("old_reaction") List<ReactionType> oldReaction,
            @JsonProperty("new_reaction") List<ReactionType> newReaction) {
        this.chat = chat;
        this.messageId = messageId;
        this.user = user;
        this.actorChat = actorChat;
        this.date = date;
        this.oldReaction = oldReaction;
        this.newReaction = newReaction;
    }

    public static MessageReactionUpdated of(Chat chat, long messageId, long date, List<ReactionType> oldReaction, List<ReactionType> newReaction) {
        return new MessageReactionUpdated(chat, messageId, null, null, date, oldReaction, newReaction);
    }

    /**
     * The chat containing the message the user reacted to
     */
    public Chat chat() {
        return chat;
    }

    /**
     * Unique identifier of the message inside the chat
     */
    public long messageId() {
        return messageId;
    }

    /**
     * The user that changed the reaction, if the user isn't anonymous
     */
    public @Nullable User user() {
        return user;
    }

    /**
     * The chat on behalf of which the reaction was changed, if the user is anonymous
     */
    public @Nullable Chat actorChat() {
        return actorChat;
    }

    /**
     * Date of the change in Unix time
     */
    public long date() {
        return date;
    }

    /**
     * Previous list of reaction types that were set by the user
     */
    public List<ReactionType> oldReaction() {
        return oldReaction;
    }

    /**
     * New list of reaction types that have been set by the user
     */
    public List<ReactionType> newReaction() {
        return newReaction;
    }

    public MessageReactionUpdated withChat(Chat chat) {
        return new MessageReactionUpdated(chat, messageId, user, actorChat, date, oldReaction, newReaction);
    }

    public MessageReactionUpdated withMessageId(long messageId) {
        return new MessageReactionUpdated(chat, messageId, user, actorChat, date, oldReaction, newReaction);
    }

    public MessageReactionUpdated withUser(@Nullable User user) {
        return new MessageReactionUpdated(chat, messageId, user, actorChat, date, oldReaction, newReaction);
    }

    public MessageReactionUpdated withActorChat(@Nullable Chat actorChat) {
        return new MessageReactionUpdated(chat, messageId, user, actorChat, date, oldReaction, newReaction);
    }

    public MessageReactionUpdated withDate(long date) {
        return new MessageReactionUpdated(chat, messageId, user, actorChat, date, oldReaction, newReaction);
    }

    public MessageReactionUpdated withOldReaction(List<ReactionType> oldReaction) {
        return new MessageReactionUpdated(chat, messageId, user, actorChat, date, oldReaction, newReaction);
    }

    public MessageReactionUpdated withNewReaction(List<ReactionType> newReaction) {
        return new MessageReactionUpdated(chat, messageId, user, actorChat, date, oldReaction, newReaction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageReactionUpdated)) {
            return false;
        }
        MessageReactionUpdated that = (MessageReactionUpdated) o;
        return Objects.equals(this.chat, that.chat)
                && this.messageId == that.messageId
                && Objects.equals(this.user, that.user)
                && Objects.equals(this.actorChat, that.actorChat)
                && this.date == that.date
                && Objects.equals(this.oldReaction, that.oldReaction)
                && Objects.equals(this.newReaction, that.newReaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat, this.messageId, this.user, this.actorChat, this.date, this.oldReaction, this.newReaction);
    }

    @Override
    public String toString() {
        return "MessageReactionUpdated[chat=" + this.chat
                + ", messageId=" + this.messageId
                + ", user=" + this.user
                + ", actorChat=" + this.actorChat
                + ", date=" + this.date
                + ", oldReaction=" + this.oldReaction
                + ", newReaction=" + this.newReaction
                + "]";
    }
}
