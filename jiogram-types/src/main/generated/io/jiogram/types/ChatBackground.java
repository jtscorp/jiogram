package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.BackgroundType;

public class ChatBackground {
    @JsonProperty("type") private final BackgroundType type;

    @JsonCreator
    public ChatBackground(
            @JsonProperty("type") BackgroundType type
    ) {
        this.type = type;
    }

    public BackgroundType type() {
        return this.type;
    }
}
