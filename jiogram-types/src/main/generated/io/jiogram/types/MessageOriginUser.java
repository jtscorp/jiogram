package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageOriginType;
import io.jiogram.types.User;

/**
 * The message was originally sent by a known user.
 *
 * @param type Type of the message origin, always 'user'
 * @param date Date the message was sent originally in Unix time
 * @param senderUser User that sent the message originally
 * @see <a href="https://core.telegram.org/bots/api#messageoriginuser">MessageOriginUser in the Bot API</a>
 */
public record MessageOriginUser(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) MessageOriginType type,
    @JsonProperty("date") long date,
    @JsonProperty("sender_user") User senderUser
) implements MessageOrigin {}
