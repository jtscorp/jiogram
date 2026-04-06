package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import org.jspecify.annotations.Nullable;

public record BusinessLocation(
    @JsonProperty("address") String address,
    @JsonProperty("location") @Nullable Location location
) {}
