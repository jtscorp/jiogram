package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageOriginType;

/**
 * The message was originally sent by an unknown user.
 *
 * @param type Type of the message origin, always 'hidden_user'
 * @param date Date the message was sent originally in Unix time
 * @param senderUserName Name of the user that sent the message originally
 * @see <a href="https://core.telegram.org/bots/api#messageoriginhiddenuser">MessageOriginHiddenUser in the Bot API</a>
 */
public record MessageOriginHiddenUser(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MessageOriginType type,
    @JsonProperty("date") long date,
    @JsonProperty("sender_user_name") String senderUserName
) implements MessageOrigin {

    public static MessageOriginHiddenUser of(long date, String senderUserName) {
        return new MessageOriginHiddenUser(MessageOriginType.HIDDEN_USER, date, senderUserName);
    }

    public MessageOriginHiddenUser withDate(long date) {
        return new MessageOriginHiddenUser(type, date, senderUserName);
    }

    public MessageOriginHiddenUser withSenderUserName(String senderUserName) {
        return new MessageOriginHiddenUser(type, date, senderUserName);
    }
}
