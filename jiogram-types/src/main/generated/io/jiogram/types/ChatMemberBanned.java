package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;

/**
 * Represents a chat member that was banned in the chat and can't return to the chat or view chat
 * messages.
 *
 * @param status The member's status in the chat, always 'kicked'
 * @param user Information about the user
 * @param untilDate Date when restrictions will be lifted for this user; Unix time. If 0, then the
 *     user is banned forever
 * @see <a href="https://core.telegram.org/bots/api#chatmemberbanned">ChatMemberBanned in the Bot API</a>
 */
public record ChatMemberBanned(
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
    @JsonProperty("user") User user,
    @JsonProperty("until_date") long untilDate
) implements ChatMember {

    public static ChatMemberBanned of(User user, long untilDate) {
        return new ChatMemberBanned(ChatMemberType.KICKED, user, untilDate);
    }

    public ChatMemberBanned withUser(User user) {
        return new ChatMemberBanned(status, user, untilDate);
    }

    public ChatMemberBanned withUntilDate(long untilDate) {
        return new ChatMemberBanned(status, user, untilDate);
    }
}
