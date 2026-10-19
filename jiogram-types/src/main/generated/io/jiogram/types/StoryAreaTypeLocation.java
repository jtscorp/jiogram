package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LocationAddress;
import io.jiogram.types.StoryAreaTypeType;
import org.jspecify.annotations.Nullable;

public record StoryAreaTypeLocation(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) StoryAreaTypeType type,
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("address") @Nullable LocationAddress address
) implements StoryAreaType {}
