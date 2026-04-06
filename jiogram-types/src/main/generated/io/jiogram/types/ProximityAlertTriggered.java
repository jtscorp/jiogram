package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.User;

public record ProximityAlertTriggered(
    @JsonProperty("traveler") User traveler,
    @JsonProperty("watcher") User watcher,
    @JsonProperty("distance") long distance
) {}
