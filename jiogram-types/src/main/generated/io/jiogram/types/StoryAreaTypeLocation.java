package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LocationAddress;
import io.jiogram.types.StoryAreaTypeType;
import org.jspecify.annotations.Nullable;

public class StoryAreaTypeLocation implements StoryAreaType {
    @JsonProperty("type") private final StoryAreaTypeType type;
    @JsonProperty("latitude") private final double latitude;
    @JsonProperty("longitude") private final double longitude;
    @JsonProperty("address") @Nullable private final LocationAddress address;

    @JsonCreator
    public StoryAreaTypeLocation(
            @JsonProperty("type") StoryAreaTypeType type,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("address") @Nullable LocationAddress address
    ) {
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public StoryAreaTypeType type() {
        return this.type;
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

    public LocationAddress address() {
        return this.address;
    }
}
