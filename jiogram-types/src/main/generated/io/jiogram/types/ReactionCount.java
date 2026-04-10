package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ReactionType;

public class ReactionCount {
    @JsonProperty("type") private final ReactionType type;
    @JsonProperty("total_count") private final long totalCount;

    @JsonCreator
    public ReactionCount(
            @JsonProperty("type") ReactionType type,
            @JsonProperty("total_count") long totalCount
    ) {
        this.type = type;
        this.totalCount = totalCount;
    }

    public ReactionType type() {
        return this.type;
    }

    public long totalCount() {
        return this.totalCount;
    }
}
