package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoChatEnded {
    @JsonProperty("duration") private final long duration;

    @JsonCreator
    public VideoChatEnded(
            @JsonProperty("duration") long duration
    ) {
        this.duration = duration;
    }

    public long duration() {
        return this.duration;
    }
}
