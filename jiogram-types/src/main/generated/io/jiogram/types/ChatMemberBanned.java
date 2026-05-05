package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatMemberType;
import io.jiogram.types.User;

public class ChatMemberBanned implements ChatMember {
    @JsonProperty("status") private final ChatMemberType status;
    @JsonProperty("user") private final User user;
    @JsonProperty("until_date") private final long untilDate;

    @JsonCreator
    public ChatMemberBanned(
            @JsonProperty("status") ChatMemberType status,
            @JsonProperty("user") User user,
            @JsonProperty("until_date") long untilDate
    ) {
        this.status = status;
        this.user = user;
        this.untilDate = untilDate;
    }

    public ChatMemberType status() {
        return this.status;
    }

    public User user() {
        return this.user;
    }

    public long untilDate() {
        return this.untilDate;
    }
}
