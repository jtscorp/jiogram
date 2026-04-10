package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class Birthdate {
    @JsonProperty("day") private final long day;
    @JsonProperty("month") private final long month;
    @JsonProperty("year") @Nullable private final Long year;

    @JsonCreator
    public Birthdate(
            @JsonProperty("day") long day,
            @JsonProperty("month") long month,
            @JsonProperty("year") @Nullable Long year
    ) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public long day() {
        return this.day;
    }

    public long month() {
        return this.month;
    }

    public Long year() {
        return this.year;
    }
}
