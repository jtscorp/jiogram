package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dice {
    @JsonProperty("emoji") private final String emoji;
    @JsonProperty("value") private final long value;

    @JsonCreator
    public Dice(
            @JsonProperty("emoji") String emoji,
            @JsonProperty("value") long value
    ) {
        this.emoji = emoji;
        this.value = value;
    }

    public String emoji() {
        return this.emoji;
    }

    public long value() {
        return this.value;
    }
}
