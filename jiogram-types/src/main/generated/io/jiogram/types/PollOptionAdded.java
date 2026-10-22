package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MaybeInaccessibleMessage;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Describes a service message about an option added to a poll.
 *
 * @param pollMessage Message containing the poll to which the option was added, if known. Note that
 *     the Message object in this field will not contain the reply_to_message field even if it
 *     itself is a reply.
 * @param optionPersistentId Unique identifier of the added option
 * @param optionText Option text
 * @param optionTextEntities Special entities that appear in the option_text
 * @see <a href="https://core.telegram.org/bots/api#polloptionadded">PollOptionAdded in the Bot API</a>
 */
public record PollOptionAdded(
    @JsonProperty("poll_message") @Nullable MaybeInaccessibleMessage pollMessage,
    @JsonProperty("option_persistent_id") String optionPersistentId,
    @JsonProperty("option_text") String optionText,
    @JsonProperty("option_text_entities") @Nullable List<MessageEntity> optionTextEntities
) {}
