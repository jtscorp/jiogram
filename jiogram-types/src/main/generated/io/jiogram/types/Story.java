package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Chat;

public class Story {
    @JsonProperty("chat") private final Chat chat;
    @JsonProperty("id") private final long id;

    @JsonCreator
    public Story(
            @JsonProperty("chat") Chat chat,
            @JsonProperty("id") long id
    ) {
        this.chat = chat;
        this.id = id;
    }

    public Chat chat() {
        return this.chat;
    }

    public long id() {
        return this.id;
    }
}
