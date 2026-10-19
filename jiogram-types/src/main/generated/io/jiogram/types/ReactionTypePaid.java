package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionTypeType;

public record ReactionTypePaid(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) ReactionTypeType type
) implements ReactionType {}
