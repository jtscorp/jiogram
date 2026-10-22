package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a point on the map.
 *
 * @see <a href="https://core.telegram.org/bots/api#location">Location in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Location {

    @JsonProperty("latitude")
    private final double latitude;

    @JsonProperty("longitude")
    private final double longitude;

    @JsonProperty("horizontal_accuracy")
    private final @Nullable Double horizontalAccuracy;

    @JsonProperty("live_period")
    private final @Nullable Long livePeriod;

    @JsonProperty("heading")
    private final @Nullable Long heading;

    @JsonProperty("proximity_alert_radius")
    private final @Nullable Long proximityAlertRadius;

    /**
     * Creates a new {@code Location} instance.
     *
     * @param latitude Latitude as defined by the sender
     * @param longitude Longitude as defined by the sender
     * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters;
     *     0-1500
     * @param livePeriod Time relative to the message sending date, during which the location can be
     *     updated; in seconds. For active live locations only.
     * @param heading The direction in which user is moving, in degrees; 1-360. For active live
     *     locations only.
     * @param proximityAlertRadius The maximum distance for proximity alerts about approaching
     *     another chat member, in meters. For sent live locations only.
     */
    @JsonCreator
    public Location(
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("horizontal_accuracy") @Nullable Double horizontalAccuracy,
            @JsonProperty("live_period") @Nullable Long livePeriod,
            @JsonProperty("heading") @Nullable Long heading,
            @JsonProperty("proximity_alert_radius") @Nullable Long proximityAlertRadius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.horizontalAccuracy = horizontalAccuracy;
        this.livePeriod = livePeriod;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
    }

    public static Location of(double latitude, double longitude) {
        return new Location(latitude, longitude, null, null, null, null);
    }

    /**
     * Latitude as defined by the sender
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Longitude as defined by the sender
     */
    public double longitude() {
        return longitude;
    }

    /**
     * The radius of uncertainty for the location, measured in meters; 0-1500
     */
    public @Nullable Double horizontalAccuracy() {
        return horizontalAccuracy;
    }

    /**
     * Time relative to the message sending date, during which the location can be updated; in
     * seconds. For active live locations only.
     */
    public @Nullable Long livePeriod() {
        return livePeriod;
    }

    /**
     * The direction in which user is moving, in degrees; 1-360. For active live locations only.
     */
    public @Nullable Long heading() {
        return heading;
    }

    /**
     * The maximum distance for proximity alerts about approaching another chat member, in meters.
     * For sent live locations only.
     */
    public @Nullable Long proximityAlertRadius() {
        return proximityAlertRadius;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Location)) {
            return false;
        }
        Location that = (Location) o;
        return Double.compare(this.latitude, that.latitude) == 0
                && Double.compare(this.longitude, that.longitude) == 0
                && Objects.equals(this.horizontalAccuracy, that.horizontalAccuracy)
                && Objects.equals(this.livePeriod, that.livePeriod)
                && Objects.equals(this.heading, that.heading)
                && Objects.equals(this.proximityAlertRadius, that.proximityAlertRadius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.latitude, this.longitude, this.horizontalAccuracy, this.livePeriod, this.heading, this.proximityAlertRadius);
    }

    @Override
    public String toString() {
        return "Location[latitude=" + this.latitude
                + ", longitude=" + this.longitude
                + ", horizontalAccuracy=" + this.horizontalAccuracy
                + ", livePeriod=" + this.livePeriod
                + ", heading=" + this.heading
                + ", proximityAlertRadius=" + this.proximityAlertRadius
                + "]";
    }
}
