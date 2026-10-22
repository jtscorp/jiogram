package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

/**
 * Describes a service message about an ownership change in the chat.
 *
 * @param newOwner The new owner of the chat
 * @see <a href="https://core.telegram.org/bots/api#chatownerchanged">ChatOwnerChanged in the Bot API</a>
 */
public record ChatOwnerChanged(
    @JsonProperty("new_owner") User newOwner
) {

    public ChatOwnerChanged withNewOwner(User newOwner) {
        return new ChatOwnerChanged(newOwner);
    }
}
