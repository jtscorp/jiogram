package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public class ManagedBotUpdated {
    @JsonProperty("user") private final User user;
    @JsonProperty("bot") private final User bot;

    @JsonCreator
    public ManagedBotUpdated(
            @JsonProperty("user") User user,
            @JsonProperty("bot") User bot
    ) {
        this.user = user;
        this.bot = bot;
    }

    public User user() {
        return this.user;
    }

    public User bot() {
        return this.bot;
    }
}
