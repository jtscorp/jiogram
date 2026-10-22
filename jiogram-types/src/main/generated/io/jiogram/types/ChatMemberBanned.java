package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * Represents a chat member that was banned in the chat and can't return to the chat or view chat
 * messages.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberbanned">ChatMemberBanned in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatMemberBanned implements ChatMember {

    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private final ChatMemberType status;

    @JsonProperty("user")
    private final User user;

    @JsonProperty("until_date")
    private final long untilDate;

    /**
     * Creates a new {@code ChatMemberBanned} instance.
     *
     * @param status The member's status in the chat, always 'kicked'
     * @param user Information about the user
     * @param untilDate Date when restrictions will be lifted for this user; Unix time. If 0, then
     *     the user is banned forever
     */
    @JsonCreator
    public ChatMemberBanned(
            @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
            @JsonProperty("user") User user,
            @JsonProperty("until_date") long untilDate) {
        this.status = status;
        this.user = user;
        this.untilDate = untilDate;
    }

    public static ChatMemberBanned of(User user, long untilDate) {
        return new ChatMemberBanned(ChatMemberType.KICKED, user, untilDate);
    }

    /**
     * The member's status in the chat, always 'kicked'
     */
    public ChatMemberType status() {
        return status;
    }

    /**
     * Information about the user
     */
    public User user() {
        return user;
    }

    /**
     * Date when restrictions will be lifted for this user; Unix time. If 0, then the user is banned
     * forever
     */
    public long untilDate() {
        return untilDate;
    }

    public ChatMemberBanned withUser(User user) {
        return new ChatMemberBanned(status, user, untilDate);
    }

    public ChatMemberBanned withUntilDate(long untilDate) {
        return new ChatMemberBanned(status, user, untilDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatMemberBanned)) {
            return false;
        }
        ChatMemberBanned that = (ChatMemberBanned) o;
        return Objects.equals(this.status, that.status)
                && Objects.equals(this.user, that.user)
                && this.untilDate == that.untilDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.user, this.untilDate);
    }

    @Override
    public String toString() {
        return "ChatMemberBanned[status=" + this.status
                + ", user=" + this.user
                + ", untilDate=" + this.untilDate
                + "]";
    }
}
