package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public class ManagedBotCreated {
    @JsonProperty("bot") private final User bot;

    @JsonCreator
    public ManagedBotCreated(
            @JsonProperty("bot") User bot
    ) {
        this.bot = bot;
    }

    public User bot() {
        return this.bot;
    }
}
