package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a point on the map.
 *
 * @param latitude Latitude as defined by the sender
 * @param longitude Longitude as defined by the sender
 * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500
 * @param livePeriod Time relative to the message sending date, during which the location can be
 *     updated; in seconds. For active live locations only.
 * @param heading The direction in which user is moving, in degrees; 1-360. For active live
 *     locations only.
 * @param proximityAlertRadius The maximum distance for proximity alerts about approaching another
 *     chat member, in meters. For sent live locations only.
 * @see <a href="https://core.telegram.org/bots/api#location">Location in the Bot API</a>
 */
public record Location(
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("horizontal_accuracy") @Nullable Double horizontalAccuracy,
    @JsonProperty("live_period") @Nullable Long livePeriod,
    @JsonProperty("heading") @Nullable Long heading,
    @JsonProperty("proximity_alert_radius") @Nullable Long proximityAlertRadius
) {

    public Location withLatitude(double latitude) {
        return new Location(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public Location withLongitude(double longitude) {
        return new Location(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public Location withHorizontalAccuracy(@Nullable Double horizontalAccuracy) {
        return new Location(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public Location withLivePeriod(@Nullable Long livePeriod) {
        return new Location(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public Location withHeading(@Nullable Long heading) {
        return new Location(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public Location withProximityAlertRadius(@Nullable Long proximityAlertRadius) {
        return new Location(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }
}
