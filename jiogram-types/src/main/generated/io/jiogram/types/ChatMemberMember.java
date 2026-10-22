package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * Represents a chat member that has no additional privileges or restrictions.
 *
 * @param status The member's status in the chat, always 'member'
 * @param tag Tag of the member
 * @param user Information about the user
 * @param untilDate Date when the user's subscription will expire; Unix time
 * @see <a href="https://core.telegram.org/bots/api#chatmembermember">ChatMemberMember in the Bot API</a>
 */
public record ChatMemberMember(
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
    @JsonProperty("tag") @Nullable String tag,
    @JsonProperty("user") User user,
    @JsonProperty("until_date") @Nullable Long untilDate
) implements ChatMember {

    public static ChatMemberMember of(User user) {
        return new ChatMemberMember(ChatMemberType.MEMBER, null, user, null);
    }

    public ChatMemberMember withTag(@Nullable String tag) {
        return new ChatMemberMember(status, tag, user, untilDate);
    }

    public ChatMemberMember withUser(User user) {
        return new ChatMemberMember(status, tag, user, untilDate);
    }

    public ChatMemberMember withUntilDate(@Nullable Long untilDate) {
        return new ChatMemberMember(status, tag, user, untilDate);
    }
}
