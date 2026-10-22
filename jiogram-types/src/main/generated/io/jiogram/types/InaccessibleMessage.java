package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;

/**
 * This object describes a message that was deleted or is otherwise inaccessible to the bot.
 *
 * @param chat Chat the message belonged to
 * @param messageId Unique message identifier inside the chat
 * @param date Always 0. The field can be used to differentiate regular and inaccessible messages.
 * @see <a href="https://core.telegram.org/bots/api#inaccessiblemessage">InaccessibleMessage in the Bot API</a>
 */
public record InaccessibleMessage(
    @JsonProperty("chat") Chat chat,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("date") long date
) implements MaybeInaccessibleMessage {}
