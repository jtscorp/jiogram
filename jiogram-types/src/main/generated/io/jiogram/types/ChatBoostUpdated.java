package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatBoost;

public class ChatBoostUpdated {
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("boost") private final ChatBoost boost;

    @JsonCreator
    public ChatBoostUpdated(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("boost") ChatBoost boost
    ) {
        this.chat = chat;
        this.boost = boost;
    }

    public Chat chat() {
        return this.chat;
    }

    public ChatBoost boost() {
        return this.boost;
    }
}
