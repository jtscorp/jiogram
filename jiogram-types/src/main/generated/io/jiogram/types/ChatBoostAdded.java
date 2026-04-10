package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatBoostAdded {
    @JsonProperty("boost_count") private final long boostCount;

    @JsonCreator
    public ChatBoostAdded(
            @JsonProperty("boost_count") long boostCount
    ) {
        this.boostCount = boostCount;
    }

    public long boostCount() {
        return this.boostCount;
    }
}
