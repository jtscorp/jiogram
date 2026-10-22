package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.List;

/**
 * This object represents a service message about new members invited to a video chat.
 *
 * @param users New members that were invited to the video chat
 * @see <a href="https://core.telegram.org/bots/api#videochatparticipantsinvited">VideoChatParticipantsInvited in the Bot API</a>
 */
public record VideoChatParticipantsInvited(
    @JsonProperty("users") List<User> users
) {

    public VideoChatParticipantsInvited withUsers(List<User> users) {
        return new VideoChatParticipantsInvited(users);
    }
}
