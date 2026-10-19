package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

public record ReactionTypeEmoji(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) ReactionTypeType type,
    @JsonProperty("emoji") String emoji
) implements ReactionType {}
