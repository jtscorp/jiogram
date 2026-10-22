package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents the content of a location message to be sent as the result of an inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputlocationmessagecontent">InputLocationMessageContent in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputLocationMessageContent implements InputMessageContent {

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
     * Creates a new {@code InputLocationMessageContent} instance.
     *
     * @param latitude Latitude of the location in degrees
     * @param longitude Longitude of the location in degrees
     * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters;
     *     0-1500
     * @param livePeriod Period in seconds during which the location can be updated, should be
     *     between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
     * @param heading For live locations, a direction in which the user is moving, in degrees. Must
     *     be between 1 and 360 if specified.
     * @param proximityAlertRadius For live locations, a maximum distance for proximity alerts about
     *     approaching another chat member, in meters. Must be between 1 and 100000 if specified.
     */
    @JsonCreator
    public InputLocationMessageContent(
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

    public static InputLocationMessageContent of(double latitude, double longitude) {
        return new InputLocationMessageContent(latitude, longitude, null, null, null, null);
    }

    /**
     * Latitude of the location in degrees
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Longitude of the location in degrees
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
     * Period in seconds during which the location can be updated, should be between 60 and 86400,
     * or 0x7FFFFFFF for live locations that can be edited indefinitely.
     */
    public @Nullable Long livePeriod() {
        return livePeriod;
    }

    /**
     * For live locations, a direction in which the user is moving, in degrees. Must be between 1
     * and 360 if specified.
     */
    public @Nullable Long heading() {
        return heading;
    }

    /**
     * For live locations, a maximum distance for proximity alerts about approaching another chat
     * member, in meters. Must be between 1 and 100000 if specified.
     */
    public @Nullable Long proximityAlertRadius() {
        return proximityAlertRadius;
    }

    public InputLocationMessageContent withLatitude(double latitude) {
        return new InputLocationMessageContent(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public InputLocationMessageContent withLongitude(double longitude) {
        return new InputLocationMessageContent(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public InputLocationMessageContent withHorizontalAccuracy(@Nullable Double horizontalAccuracy) {
        return new InputLocationMessageContent(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public InputLocationMessageContent withLivePeriod(@Nullable Long livePeriod) {
        return new InputLocationMessageContent(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public InputLocationMessageContent withHeading(@Nullable Long heading) {
        return new InputLocationMessageContent(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    public InputLocationMessageContent withProximityAlertRadius(@Nullable Long proximityAlertRadius) {
        return new InputLocationMessageContent(latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputLocationMessageContent)) {
            return false;
        }
        InputLocationMessageContent that = (InputLocationMessageContent) o;
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
        return "InputLocationMessageContent[latitude=" + this.latitude
                + ", longitude=" + this.longitude
                + ", horizontalAccuracy=" + this.horizontalAccuracy
                + ", livePeriod=" + this.livePeriod
                + ", heading=" + this.heading
                + ", proximityAlertRadius=" + this.proximityAlertRadius
                + "]";
    }
}
