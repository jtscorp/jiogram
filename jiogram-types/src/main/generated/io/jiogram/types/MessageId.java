package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageId {
    @JsonProperty("message_id") private final long messageId;

    @JsonCreator
    public MessageId(
            @JsonProperty("message_id") long messageId
    ) {
        this.messageId = messageId;
    }

    public long messageId() {
        return this.messageId;
    }
}
