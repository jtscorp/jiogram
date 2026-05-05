package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageOriginType;
import io.jiogram.types.User;

public class MessageOriginUser implements MessageOrigin {
    @JsonProperty("type") private final MessageOriginType type;
    @JsonProperty("date") private final long date;
    @JsonProperty("sender_user") private final User senderUser;

    @JsonCreator
    public MessageOriginUser(
            @JsonProperty("type") MessageOriginType type,
            @JsonProperty("date") long date,
            @JsonProperty("sender_user") User senderUser
    ) {
        this.type = type;
        this.date = date;
        this.senderUser = senderUser;
    }

    public MessageOriginType type() {
        return this.type;
    }

    public long date() {
        return this.date;
    }

    public User senderUser() {
        return this.senderUser;
    }
}
