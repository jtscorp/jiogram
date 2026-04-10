package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaPosition;
import io.jiogram.types.StoryAreaType;

public class StoryArea {
    @JsonProperty("position") private final StoryAreaPosition position;
    @JsonProperty("type") private final StoryAreaType type;

    @JsonCreator
    public StoryArea(
            @JsonProperty("position") StoryAreaPosition position,
            @JsonProperty("type") StoryAreaType type
    ) {
        this.position = position;
        this.type = type;
    }

    public StoryAreaPosition position() {
        return this.position;
    }

    public StoryAreaType type() {
        return this.type;
    }
}
