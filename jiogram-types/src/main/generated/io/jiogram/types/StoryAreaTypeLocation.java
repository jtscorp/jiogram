package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LocationAddress;
import org.jspecify.annotations.Nullable;

public record StoryAreaTypeLocation(
    @JsonProperty("type") String type,
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("address") @Nullable LocationAddress address
) implements StoryAreaType {}
