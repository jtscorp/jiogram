package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

public class ReactionTypeEmoji implements ReactionType {
    @JsonProperty("type") private final ReactionTypeType type;
    @JsonProperty("emoji") private final String emoji;

    @JsonCreator
    public ReactionTypeEmoji(
            @JsonProperty("type") ReactionTypeType type,
            @JsonProperty("emoji") String emoji
    ) {
        this.type = type;
        this.emoji = emoji;
    }

    public ReactionTypeType type() {
        return this.type;
    }

    public String emoji() {
        return this.emoji;
    }
}
