package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BotCommand {
    @JsonProperty("command") private final String command;
    @JsonProperty("description") private final String description;

    @JsonCreator
    public BotCommand(
            @JsonProperty("command") String command,
            @JsonProperty("description") String description
    ) {
        this.command = command;
        this.description = description;
    }

    public String command() {
        return this.command;
    }

    public String description() {
        return this.description;
    }
}
