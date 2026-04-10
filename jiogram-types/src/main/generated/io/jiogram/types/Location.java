package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class Location {
    @JsonProperty("latitude") private final double latitude;
    @JsonProperty("longitude") private final double longitude;
    @JsonProperty("horizontal_accuracy") @Nullable private final Double horizontalAccuracy;
    @JsonProperty("live_period") @Nullable private final Long livePeriod;
    @JsonProperty("heading") @Nullable private final Long heading;
    @JsonProperty("proximity_alert_radius") @Nullable private final Long proximityAlertRadius;

    @JsonCreator
    public Location(
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("horizontal_accuracy") @Nullable Double horizontalAccuracy,
            @JsonProperty("live_period") @Nullable Long livePeriod,
            @JsonProperty("heading") @Nullable Long heading,
            @JsonProperty("proximity_alert_radius") @Nullable Long proximityAlertRadius
    ) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.horizontalAccuracy = horizontalAccuracy;
        this.livePeriod = livePeriod;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

    public Double horizontalAccuracy() {
        return this.horizontalAccuracy;
    }

    public Long livePeriod() {
        return this.livePeriod;
    }

    public Long heading() {
        return this.heading;
    }

    public Long proximityAlertRadius() {
        return this.proximityAlertRadius;
    }
}
