package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BotDescription {
    @JsonProperty("description") private final String description;

    @JsonCreator
    public BotDescription(
            @JsonProperty("description") String description
    ) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
