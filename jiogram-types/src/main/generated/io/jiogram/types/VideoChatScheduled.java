package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VideoChatScheduled(
    @JsonProperty("start_date") long startDate
) {}
