package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatBoostSource;

public class ChatBoostRemoved {
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("boost_id") private final String boostId;
    @JsonProperty("remove_date") private final long removeDate;
    @JsonProperty("source") private final ChatBoostSource source;

    @JsonCreator
    public ChatBoostRemoved(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("boost_id") String boostId,
            @JsonProperty("remove_date") long removeDate,
            @JsonProperty("source") ChatBoostSource source
    ) {
        this.chat = chat;
        this.boostId = boostId;
        this.removeDate = removeDate;
        this.source = source;
    }

    public Chat chat() {
        return this.chat;
    }

    public String boostId() {
        return this.boostId;
    }

    public long removeDate() {
        return this.removeDate;
    }

    public ChatBoostSource source() {
        return this.source;
    }
}
