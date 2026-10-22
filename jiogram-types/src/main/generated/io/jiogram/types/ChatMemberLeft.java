package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import java.util.Objects;

/**
 * Represents a chat member that isn't currently a member of the chat, but may join it themselves.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberleft">ChatMemberLeft in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatMemberLeft implements ChatMember {

    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private final ChatMemberType status;

    @JsonProperty("user")
    private final User user;

    /**
     * Creates a new {@code ChatMemberLeft} instance.
     *
     * @param status The member's status in the chat, always 'left'
     * @param user Information about the user
     */
    @JsonCreator
    public ChatMemberLeft(
            @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
            @JsonProperty("user") User user) {
        this.status = status;
        this.user = user;
    }

    public static ChatMemberLeft of(User user) {
        return new ChatMemberLeft(ChatMemberType.LEFT, user);
    }

    /**
     * The member's status in the chat, always 'left'
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

    public ChatMemberLeft withUser(User user) {
        return new ChatMemberLeft(status, user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatMemberLeft)) {
            return false;
        }
        ChatMemberLeft that = (ChatMemberLeft) o;
        return Objects.equals(this.status, that.status)
                && Objects.equals(this.user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.user);
    }

    @Override
    public String toString() {
        return "ChatMemberLeft[status=" + this.status
                + ", user=" + this.user
                + "]";
    }
}
