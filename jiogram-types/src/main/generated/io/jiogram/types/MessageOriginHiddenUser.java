package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageOriginType;

public class MessageOriginHiddenUser implements MessageOrigin {
    @JsonProperty("type") private final MessageOriginType type;
    @JsonProperty("date") private final long date;
    @JsonProperty("sender_user_name") private final String senderUserName;

    @JsonCreator
    public MessageOriginHiddenUser(
            @JsonProperty("type") MessageOriginType type,
            @JsonProperty("date") long date,
            @JsonProperty("sender_user_name") String senderUserName
    ) {
        this.type = type;
        this.date = date;
        this.senderUserName = senderUserName;
    }

    public MessageOriginType type() {
        return this.type;
    }

    public long date() {
        return this.date;
    }

    public String senderUserName() {
        return this.senderUserName;
    }
}
