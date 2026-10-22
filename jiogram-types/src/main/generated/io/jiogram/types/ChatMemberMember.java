package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a chat member that has no additional privileges or restrictions.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmembermember">ChatMemberMember in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatMemberMember implements ChatMember {

    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private final ChatMemberType status;

    @JsonProperty("tag")
    private final @Nullable String tag;

    @JsonProperty("user")
    private final User user;

    @JsonProperty("until_date")
    private final @Nullable Long untilDate;

    /**
     * Creates a new {@code ChatMemberMember} instance.
     *
     * @param status The member's status in the chat, always 'member'
     * @param tag Tag of the member
     * @param user Information about the user
     * @param untilDate Date when the user's subscription will expire; Unix time
     */
    @JsonCreator
    public ChatMemberMember(
            @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
            @JsonProperty("tag") @Nullable String tag,
            @JsonProperty("user") User user,
            @JsonProperty("until_date") @Nullable Long untilDate) {
        this.status = status;
        this.tag = tag;
        this.user = user;
        this.untilDate = untilDate;
    }

    public static ChatMemberMember of(User user) {
        return new ChatMemberMember(ChatMemberType.MEMBER, null, user, null);
    }

    /**
     * The member's status in the chat, always 'member'
     */
    public ChatMemberType status() {
        return status;
    }

    /**
     * Tag of the member
     */
    public @Nullable String tag() {
        return tag;
    }

    /**
     * Information about the user
     */
    public User user() {
        return user;
    }

    /**
     * Date when the user's subscription will expire; Unix time
     */
    public @Nullable Long untilDate() {
        return untilDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatMemberMember)) {
            return false;
        }
        ChatMemberMember that = (ChatMemberMember) o;
        return Objects.equals(this.status, that.status)
                && Objects.equals(this.tag, that.tag)
                && Objects.equals(this.user, that.user)
                && Objects.equals(this.untilDate, that.untilDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.tag, this.user, this.untilDate);
    }

    @Override
    public String toString() {
        return "ChatMemberMember[status=" + this.status
                + ", tag=" + this.tag
                + ", user=" + this.user
                + ", untilDate=" + this.untilDate
                + "]";
    }
}
