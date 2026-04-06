package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BusinessOpeningHoursInterval(
    @JsonProperty("opening_minute") long openingMinute,
    @JsonProperty("closing_minute") long closingMinute
) {}
