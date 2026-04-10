package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import org.jspecify.annotations.Nullable;

public class BusinessLocation {
    @JsonProperty("address") private final String address;
    @JsonProperty("location") @Nullable private final Location location;

    @JsonCreator
    public BusinessLocation(
            @JsonProperty("address") String address,
            @JsonProperty("location") @Nullable Location location
    ) {
        this.address = address;
        this.location = location;
    }

    public String address() {
        return this.address;
    }

    public Location location() {
        return this.location;
    }
}
