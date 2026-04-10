package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BusinessOpeningHoursInterval {
    @JsonProperty("opening_minute") private final long openingMinute;
    @JsonProperty("closing_minute") private final long closingMinute;

    @JsonCreator
    public BusinessOpeningHoursInterval(
            @JsonProperty("opening_minute") long openingMinute,
            @JsonProperty("closing_minute") long closingMinute
    ) {
        this.openingMinute = openingMinute;
        this.closingMinute = closingMinute;
    }

    public long openingMinute() {
        return this.openingMinute;
    }

    public long closingMinute() {
        return this.closingMinute;
    }
}
