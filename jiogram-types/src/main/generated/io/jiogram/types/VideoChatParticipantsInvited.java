package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.List;
import java.util.Objects;

/**
 * This object represents a service message about new members invited to a video chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#videochatparticipantsinvited">VideoChatParticipantsInvited in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class VideoChatParticipantsInvited {

    @JsonProperty("users")
    private final List<User> users;

    /**
     * Creates a new {@code VideoChatParticipantsInvited} instance.
     *
     * @param users New members that were invited to the video chat
     */
    @JsonCreator
    public VideoChatParticipantsInvited(
            @JsonProperty("users") List<User> users) {
        this.users = users;
    }

    /**
     * New members that were invited to the video chat
     */
    public List<User> users() {
        return users;
    }

    public VideoChatParticipantsInvited withUsers(List<User> users) {
        return new VideoChatParticipantsInvited(users);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VideoChatParticipantsInvited)) {
            return false;
        }
        VideoChatParticipantsInvited that = (VideoChatParticipantsInvited) o;
        return Objects.equals(this.users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.users);
    }

    @Override
    public String toString() {
        return "VideoChatParticipantsInvited[users=" + this.users
                + "]";
    }
}
