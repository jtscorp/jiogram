package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BotShortDescription {
    @JsonProperty("short_description") private final String shortDescription;

    @JsonCreator
    public BotShortDescription(
            @JsonProperty("short_description") String shortDescription
    ) {
        this.shortDescription = shortDescription;
    }

    public String shortDescription() {
        return this.shortDescription;
    }
}
