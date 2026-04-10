package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public class ProximityAlertTriggered {
    @JsonProperty("traveler") private final User traveler;
    @JsonProperty("watcher") private final User watcher;
    @JsonProperty("distance") private final long distance;

    @JsonCreator
    public ProximityAlertTriggered(
            @JsonProperty("traveler") User traveler,
            @JsonProperty("watcher") User watcher,
            @JsonProperty("distance") long distance
    ) {
        this.traveler = traveler;
        this.watcher = watcher;
        this.distance = distance;
    }

    public User traveler() {
        return this.traveler;
    }

    public User watcher() {
        return this.watcher;
    }

    public long distance() {
        return this.distance;
    }
}
