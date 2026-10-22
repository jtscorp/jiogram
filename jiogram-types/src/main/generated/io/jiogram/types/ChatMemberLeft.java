package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;

/**
 * Represents a chat member that isn't currently a member of the chat, but may join it themselves.
 *
 * @param status The member's status in the chat, always 'left'
 * @param user Information about the user
 * @see <a href="https://core.telegram.org/bots/api#chatmemberleft">ChatMemberLeft in the Bot API</a>
 */
public record ChatMemberLeft(
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
    @JsonProperty("user") User user
) implements ChatMember {

    public ChatMemberLeft withUser(User user) {
        return new ChatMemberLeft(status, user);
    }
}
