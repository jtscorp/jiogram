package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VideoChatEnded(
    @JsonProperty("duration") long duration
) {}
