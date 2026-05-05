package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

public record ReactionTypePaid(
    @JsonProperty("type") ReactionTypeType type
) implements ReactionType {}
