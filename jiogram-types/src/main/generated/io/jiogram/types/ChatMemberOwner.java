package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Represents a chat member that owns the chat and has all administrator privileges.
 *
 * @param status The member's status in the chat, always 'creator'
 * @param user Information about the user
 * @param isAnonymous True, if the user's presence in the chat is hidden
 * @param customTitle Custom title for this user
 * @see <a href="https://core.telegram.org/bots/api#chatmemberowner">ChatMemberOwner in the Bot API</a>
 */
public record ChatMemberOwner(
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
    @JsonProperty("user") User user,
    @JsonProperty("is_anonymous") boolean isAnonymous,
    @JsonProperty("custom_title") @Nullable String customTitle
) implements ChatMember {

    public ChatMemberOwner withUser(User user) {
        return new ChatMemberOwner(status, user, isAnonymous, customTitle);
    }

    public ChatMemberOwner withIsAnonymous(boolean isAnonymous) {
        return new ChatMemberOwner(status, user, isAnonymous, customTitle);
    }

    public ChatMemberOwner withCustomTitle(@Nullable String customTitle) {
        return new ChatMemberOwner(status, user, isAnonymous, customTitle);
    }
}
