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
) implements MessageOrigin {

    public static MessageOriginChannel of(long date, Chat chat, long messageId) {
        return new MessageOriginChannel(MessageOriginType.CHANNEL, date, chat, messageId, null);
    }

    public MessageOriginChannel withDate(long date) {
        return new MessageOriginChannel(type, date, chat, messageId, authorSignature);
    }

    public MessageOriginChannel withChat(Chat chat) {
        return new MessageOriginChannel(type, date, chat, messageId, authorSignature);
    }

    public MessageOriginChannel withMessageId(long messageId) {
        return new MessageOriginChannel(type, date, chat, messageId, authorSignature);
    }

    public MessageOriginChannel withAuthorSignature(@Nullable String authorSignature) {
        return new MessageOriginChannel(type, date, chat, messageId, authorSignature);
    }
}
