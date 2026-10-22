package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ReactionType;
import io.jiogram.types.User;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a change of a reaction on a message performed by a user.
 *
 * @param chat The chat containing the message the user reacted to
 * @param messageId Unique identifier of the message inside the chat
 * @param user The user that changed the reaction, if the user isn't anonymous
 * @param actorChat The chat on behalf of which the reaction was changed, if the user is anonymous
 * @param date Date of the change in Unix time
 * @param oldReaction Previous list of reaction types that were set by the user
 * @param newReaction New list of reaction types that have been set by the user
 * @see <a href="https://core.telegram.org/bots/api#messagereactionupdated">MessageReactionUpdated in the Bot API</a>
 */
public record MessageReactionUpdated(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("user") @Nullable User user,
    @JsonProperty("actor_chat") @Nullable Chat actorChat,
    @JsonProperty("date") long date,
    @JsonProperty("old_reaction") List<ReactionType> oldReaction,
    @JsonProperty("new_reaction") List<ReactionType> newReaction
) {

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
}
