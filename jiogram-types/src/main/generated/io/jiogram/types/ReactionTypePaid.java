package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

public class ReactionTypePaid implements ReactionType {
    @JsonProperty("type") private final ReactionTypeType type;

    @JsonCreator
    public ReactionTypePaid(
            @JsonProperty("type") ReactionTypeType type
    ) {
        this.type = type;
    }

    public ReactionTypeType type() {
        return this.type;
    }
}
