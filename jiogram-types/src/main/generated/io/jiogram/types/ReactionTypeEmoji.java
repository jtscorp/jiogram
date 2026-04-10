package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReactionTypeEmoji implements ReactionType {
    @JsonProperty("type") private final String type;
    @JsonProperty("emoji") private final String emoji;

    @JsonCreator
    public ReactionTypeEmoji(
            @JsonProperty("type") String type,
            @JsonProperty("emoji") String emoji
    ) {
        this.type = type;
        this.emoji = emoji;
    }

    public String type() {
        return this.type;
    }

    public String emoji() {
        return this.emoji;
    }
}
