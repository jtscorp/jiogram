package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReactionTypePaid(
    @JsonProperty("type") String type
) implements ReactionType {}
