package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;
import java.util.List;

public record VideoChatParticipantsInvited(
    @JsonProperty("users") List<User> users
) {}
