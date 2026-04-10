package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageAutoDeleteTimerChanged {
    @JsonProperty("message_auto_delete_time") private final long messageAutoDeleteTime;

    @JsonCreator
    public MessageAutoDeleteTimerChanged(
            @JsonProperty("message_auto_delete_time") long messageAutoDeleteTime
    ) {
        this.messageAutoDeleteTime = messageAutoDeleteTime;
    }

    public long messageAutoDeleteTime() {
        return this.messageAutoDeleteTime;
    }
}
