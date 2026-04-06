package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Dice(
    @JsonProperty("emoji") String emoji,
    @JsonProperty("value") long value
) {}
