package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;

public class InaccessibleMessage implements MaybeInaccessibleMessage {
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("message_id") private final long messageId;
    @JsonProperty("date") private final long date;

    @JsonCreator
    public InaccessibleMessage(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("message_id") long messageId,
            @JsonProperty("date") long date
    ) {
        this.chat = chat;
        this.messageId = messageId;
        this.date = date;
    }

    public Chat chat() {
        return this.chat;
    }

    public long messageId() {
        return this.messageId;
    }

    public long date() {
        return this.date;
    }
}
