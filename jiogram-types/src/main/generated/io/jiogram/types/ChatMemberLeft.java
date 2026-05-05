package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;

public class ChatMemberLeft implements ChatMember {
    @JsonProperty("status") private final ChatMemberType status;
    @JsonProperty("user") private final User user;

    @JsonCreator
    public ChatMemberLeft(
            @JsonProperty("status") ChatMemberType status,
            @JsonProperty("user") User user
    ) {
        this.status = status;
        this.user = user;
    }

    public ChatMemberType status() {
        return this.status;
    }

    public User user() {
        return this.user;
    }
}
