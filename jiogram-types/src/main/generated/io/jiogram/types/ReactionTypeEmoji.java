package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReactionTypeEmoji(
    @JsonProperty("type") String type,
    @JsonProperty("emoji") String emoji
) implements ReactionType {}
