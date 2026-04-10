package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StoryAreaTypeLink implements StoryAreaType {
    @JsonProperty("type") private final String type;
    @JsonProperty("url") private final String url;

    @JsonCreator
    public StoryAreaTypeLink(
            @JsonProperty("type") String type,
            @JsonProperty("url") String url
    ) {
        this.type = type;
        this.url = url;
    }

    public String type() {
        return this.type;
    }

    public String url() {
        return this.url;
    }
}
