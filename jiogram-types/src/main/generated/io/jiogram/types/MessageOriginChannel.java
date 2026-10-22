package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageOriginType;
import org.jspecify.annotations.Nullable;

/**
 * The message was originally sent to a channel chat.
 *
 * @param type Type of the message origin, always 'channel'
 * @param date Date the message was sent originally in Unix time
 * @param chat Channel chat to which the message was originally sent
 * @param messageId Unique message identifier inside the chat
 * @param authorSignature Signature of the original post author
 * @see <a href="https://core.telegram.org/bots/api#messageoriginchannel">MessageOriginChannel in the Bot API</a>
 */
public record MessageOriginChannel(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MessageOriginType type,
    @JsonProperty("date") long date,
    @JsonProperty("chat") Chat chat,
    @JsonProperty("message_id") long messageId,
    @JsonProperty("author_signature") @Nullable String authorSignature
) implements MessageOrigin {}
