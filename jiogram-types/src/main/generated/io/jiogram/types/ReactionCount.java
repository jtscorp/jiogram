package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionType;

public record ReactionCount(
    @JsonProperty("type") ReactionType type,
    @JsonProperty("total_count") long totalCount
) {}
