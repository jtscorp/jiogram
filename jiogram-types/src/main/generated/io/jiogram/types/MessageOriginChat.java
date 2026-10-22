package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.MessageOriginType;
import org.jspecify.annotations.Nullable;

/**
 * The message was originally sent on behalf of a chat to a group chat.
 *
 * @param type Type of the message origin, always 'chat'
 * @param date Date the message was sent originally in Unix time
 * @param senderChat Chat that sent the message originally
 * @param authorSignature For messages originally sent by an anonymous chat administrator, original
 *     message author signature
 * @see <a href="https://core.telegram.org/bots/api#messageoriginchat">MessageOriginChat in the Bot API</a>
 */
public record MessageOriginChat(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MessageOriginType type,
    @JsonProperty("date") long date,
    @JsonProperty("sender_chat") Chat senderChat,
    @JsonProperty("author_signature") @Nullable String authorSignature
) implements MessageOrigin {

    public static MessageOriginChat of(long date, Chat senderChat) {
        return new MessageOriginChat(MessageOriginType.CHAT, date, senderChat, null);
    }

    public MessageOriginChat withDate(long date) {
        return new MessageOriginChat(type, date, senderChat, authorSignature);
    }

    public MessageOriginChat withSenderChat(Chat senderChat) {
        return new MessageOriginChat(type, date, senderChat, authorSignature);
    }

    public MessageOriginChat withAuthorSignature(@Nullable String authorSignature) {
        return new MessageOriginChat(type, date, senderChat, authorSignature);
    }
}
