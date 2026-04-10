package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BotName {
    @JsonProperty("name") private final String name;

    @JsonCreator
    public BotName(
            @JsonProperty("name") String name
    ) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
