package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.List;

public class VideoChatParticipantsInvited {
    @JsonProperty("users") private final List<User> users;

    @JsonCreator
    public VideoChatParticipantsInvited(
            @JsonProperty("users") List<User> users
    ) {
        this.users = users;
    }

    public List<User> users() {
        return this.users;
    }
}
