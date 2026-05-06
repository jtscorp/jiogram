package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

public record ReactionTypeEmoji(
    @JsonProperty("type") ReactionTypeType type,
    @JsonProperty("emoji") String emoji
) implements ReactionType {}
