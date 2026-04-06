package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;

public record ChatLocation(
    @JsonProperty("location") Location location,
    @JsonProperty("address") String address
) {}
