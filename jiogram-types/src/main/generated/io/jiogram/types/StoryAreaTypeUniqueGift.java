package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;

public class StoryAreaTypeUniqueGift implements StoryAreaType {
    @JsonProperty("type") private final StoryAreaTypeType type;
    @JsonProperty("name") private final String name;

    @JsonCreator
    public StoryAreaTypeUniqueGift(
            @JsonProperty("type") StoryAreaTypeType type,
            @JsonProperty("name") String name
    ) {
        this.type = type;
        this.name = name;
    }

    public StoryAreaTypeType type() {
        return this.type;
    }

    public String name() {
        return this.name;
    }
}
