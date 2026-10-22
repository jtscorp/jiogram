package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ReactionCount;
import java.util.List;

/**
 * This object represents reaction changes on a message with anonymous reactions.
 *
 * @param chat The chat containing the message
 * @param messageId Unique message identifier inside the chat
 * @param date Date of the change in Unix time
 * @param reactions List of reactions that are present on the message
 * @see <a href="https://core.telegram.org/bots/api#messagereactioncountupdated">MessageReactionCountUpdated in the Bot API</a>
 */
public record MessageReactionCountUpdated(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("date") long date,
    @JsonProperty("reactions") List<ReactionCount> reactions
) {

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
}
