package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about an option deleted from a poll.
 *
 * @param pollMessage Message containing the poll from which the option was deleted, if known. Note
 *     that the Message object in this field will not contain the reply_to_message field even if it
 *     itself is a reply.
 * @param optionPersistentId Unique identifier of the deleted option
 * @param optionText Option text
 * @param optionTextEntities Special entities that appear in the option_text
 * @see <a href="https://core.telegram.org/bots/api#polloptiondeleted">PollOptionDeleted in the Bot API</a>
 */
public record PollOptionDeleted(
    @JsonProperty("poll_message") @Nullable MaybeInaccessibleMessage pollMessage,
    @JsonProperty("option_persistent_id") String optionPersistentId,
    @JsonProperty("option_text") String optionText,
    @JsonProperty("option_text_entities") @Nullable List<MessageEntity> optionTextEntities
) {

    public static PollOptionDeleted of(String optionPersistentId, String optionText) {
        return new PollOptionDeleted(null, optionPersistentId, optionText, null);
    }

    public PollOptionDeleted withPollMessage(@Nullable MaybeInaccessibleMessage pollMessage) {
        return new PollOptionDeleted(pollMessage, optionPersistentId, optionText, optionTextEntities);
    }

    public PollOptionDeleted withOptionPersistentId(String optionPersistentId) {
        return new PollOptionDeleted(pollMessage, optionPersistentId, optionText, optionTextEntities);
    }

    public PollOptionDeleted withOptionText(String optionText) {
        return new PollOptionDeleted(pollMessage, optionPersistentId, optionText, optionTextEntities);
    }

    public PollOptionDeleted withOptionTextEntities(@Nullable List<MessageEntity> optionTextEntities) {
        return new PollOptionDeleted(pollMessage, optionPersistentId, optionText, optionTextEntities);
    }
}
