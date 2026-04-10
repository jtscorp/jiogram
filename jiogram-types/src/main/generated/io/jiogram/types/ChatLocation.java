package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;

public class ChatLocation {
    @JsonProperty("location") private final Location location;
    @JsonProperty("address") private final String address;

    @JsonCreator
    public ChatLocation(
            @JsonProperty("location") Location location,
            @JsonProperty("address") String address
    ) {
        this.location = location;
        this.address = address;
    }

    public Location location() {
        return this.location;
    }

    public String address() {
        return this.address;
    }
}
