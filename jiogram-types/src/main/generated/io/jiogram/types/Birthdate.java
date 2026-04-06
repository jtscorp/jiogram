package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record Birthdate(
    @JsonProperty("day") long day,
    @JsonProperty("month") long month,
    @JsonProperty("year") @Nullable Long year
) {}
