package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StoryAreaTypeUniqueGift implements StoryAreaType {
    @JsonProperty("type") private final String type;
    @JsonProperty("name") private final String name;

    @JsonCreator
    public StoryAreaTypeUniqueGift(
            @JsonProperty("type") String type,
            @JsonProperty("name") String name
    ) {
        this.type = type;
        this.name = name;
    }

    public String type() {
        return this.type;
    }

    public String name() {
        return this.name;
    }
}
