package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.StoryAreaTypeType;

public class StoryAreaTypeLink implements StoryAreaType {
    @JsonProperty("type") private final StoryAreaTypeType type;
    @JsonProperty("url") private final String url;

    @JsonCreator
    public StoryAreaTypeLink(
            @JsonProperty("type") StoryAreaTypeType type,
            @JsonProperty("url") String url
    ) {
        this.type = type;
        this.url = url;
    }

    public StoryAreaTypeType type() {
        return this.type;
    }

    public String url() {
        return this.url;
    }
}
