package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoChatScheduled {
    @JsonProperty("start_date") private final long startDate;

    @JsonCreator
    public VideoChatScheduled(
            @JsonProperty("start_date") long startDate
    ) {
        this.startDate = startDate;
    }

    public long startDate() {
        return this.startDate;
    }
}
