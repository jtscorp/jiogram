package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public class ChatMemberLeft implements ChatMember {
    @JsonProperty("status") private final String status;
    @JsonProperty("user") private final User user;

    @JsonCreator
    public ChatMemberLeft(
            @JsonProperty("status") String status,
            @JsonProperty("user") User user
    ) {
        this.status = status;
        this.user = user;
    }

    public String status() {
        return this.status;
    }

    public User user() {
        return this.user;
    }
}
