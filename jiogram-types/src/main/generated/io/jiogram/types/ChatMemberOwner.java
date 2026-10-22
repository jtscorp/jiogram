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
 * Represents a chat member that owns the chat and has all administrator privileges.
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmemberowner">ChatMemberOwner in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ChatMemberOwner implements ChatMember {

    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private final ChatMemberType status;

    @JsonProperty("user")
    private final User user;

    @JsonProperty("is_anonymous")
    private final boolean isAnonymous;

    @JsonProperty("custom_title")
    private final @Nullable String customTitle;

    /**
     * Creates a new {@code ChatMemberOwner} instance.
     *
     * @param status The member's status in the chat, always 'creator'
     * @param user Information about the user
     * @param isAnonymous True, if the user's presence in the chat is hidden
     * @param customTitle Custom title for this user
     */
    @JsonCreator
    public ChatMemberOwner(
            @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY) ChatMemberType status,
            @JsonProperty("user") User user,
            @JsonProperty("is_anonymous") boolean isAnonymous,
            @JsonProperty("custom_title") @Nullable String customTitle) {
        this.status = status;
        this.user = user;
        this.isAnonymous = isAnonymous;
        this.customTitle = customTitle;
    }

    public static ChatMemberOwner of(User user, boolean isAnonymous) {
        return new ChatMemberOwner(ChatMemberType.CREATOR, user, isAnonymous, null);
    }

    /**
     * The member's status in the chat, always 'creator'
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
     * True, if the user's presence in the chat is hidden
     */
    public boolean isAnonymous() {
        return isAnonymous;
    }

    /**
     * Custom title for this user
     */
    public @Nullable String customTitle() {
        return customTitle;
    }

    public ChatMemberOwner withUser(User user) {
        return new ChatMemberOwner(status, user, isAnonymous, customTitle);
    }

    public ChatMemberOwner withIsAnonymous(boolean isAnonymous) {
        return new ChatMemberOwner(status, user, isAnonymous, customTitle);
    }

    public ChatMemberOwner withCustomTitle(@Nullable String customTitle) {
        return new ChatMemberOwner(status, user, isAnonymous, customTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatMemberOwner)) {
            return false;
        }
        ChatMemberOwner that = (ChatMemberOwner) o;
        return Objects.equals(this.status, that.status)
                && Objects.equals(this.user, that.user)
                && this.isAnonymous == that.isAnonymous
                && Objects.equals(this.customTitle, that.customTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.user, this.isAnonymous, this.customTitle);
    }

    @Override
    public String toString() {
        return "ChatMemberOwner[status=" + this.status
                + ", user=" + this.user
                + ", isAnonymous=" + this.isAnonymous
                + ", customTitle=" + this.customTitle
                + "]";
    }
}
