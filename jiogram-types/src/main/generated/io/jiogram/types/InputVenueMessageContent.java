package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents the content of a venue message to be sent as the result of an inline query.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputvenuemessagecontent">InputVenueMessageContent in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputVenueMessageContent implements InputMessageContent {

    @JsonProperty("latitude")
    private final double latitude;

    @JsonProperty("longitude")
    private final double longitude;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("address")
    private final String address;

    @JsonProperty("foursquare_id")
    private final @Nullable String foursquareId;

    @JsonProperty("foursquare_type")
    private final @Nullable String foursquareType;

    @JsonProperty("google_place_id")
    private final @Nullable String googlePlaceId;

    @JsonProperty("google_place_type")
    private final @Nullable String googlePlaceType;

    /**
     * Creates a new {@code InputVenueMessageContent} instance.
     *
     * @param latitude Latitude of the venue in degrees
     * @param longitude Longitude of the venue in degrees
     * @param title Name of the venue
     * @param address Address of the venue
     * @param foursquareId Foursquare identifier of the venue, if known
     * @param foursquareType Foursquare type of the venue, if known. (For example,
     *     'arts_entertainment/default', 'arts_entertainment/aquarium' or 'food/icecream'.)
     * @param googlePlaceId Google Places identifier of the venue
     * @param googlePlaceType Google Places type of the venue. (See supported types.)
     */
    @JsonCreator
    public InputVenueMessageContent(
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("title") String title,
            @JsonProperty("address") String address,
            @JsonProperty("foursquare_id") @Nullable String foursquareId,
            @JsonProperty("foursquare_type") @Nullable String foursquareType,
            @JsonProperty("google_place_id") @Nullable String googlePlaceId,
            @JsonProperty("google_place_type") @Nullable String googlePlaceType) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
    }

    public static InputVenueMessageContent of(double latitude, double longitude, String title, String address) {
        return new InputVenueMessageContent(latitude, longitude, title, address, null, null, null, null);
    }

    /**
     * Latitude of the venue in degrees
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Longitude of the venue in degrees
     */
    public double longitude() {
        return longitude;
    }

    /**
     * Name of the venue
     */
    public String title() {
        return title;
    }

    /**
     * Address of the venue
     */
    public String address() {
        return address;
    }

    /**
     * Foursquare identifier of the venue, if known
     */
    public @Nullable String foursquareId() {
        return foursquareId;
    }

    /**
     * Foursquare type of the venue, if known. (For example, 'arts_entertainment/default',
     * 'arts_entertainment/aquarium' or 'food/icecream'.)
     */
    public @Nullable String foursquareType() {
        return foursquareType;
    }

    /**
     * Google Places identifier of the venue
     */
    public @Nullable String googlePlaceId() {
        return googlePlaceId;
    }

    /**
     * Google Places type of the venue. (See supported types.)
     */
    public @Nullable String googlePlaceType() {
        return googlePlaceType;
    }

    public InputVenueMessageContent withLatitude(double latitude) {
        return new InputVenueMessageContent(latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public InputVenueMessageContent withLongitude(double longitude) {
        return new InputVenueMessageContent(latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public InputVenueMessageContent withTitle(String title) {
        return new InputVenueMessageContent(latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public InputVenueMessageContent withAddress(String address) {
        return new InputVenueMessageContent(latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public InputVenueMessageContent withFoursquareId(@Nullable String foursquareId) {
        return new InputVenueMessageContent(latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public InputVenueMessageContent withFoursquareType(@Nullable String foursquareType) {
        return new InputVenueMessageContent(latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public InputVenueMessageContent withGooglePlaceId(@Nullable String googlePlaceId) {
        return new InputVenueMessageContent(latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public InputVenueMessageContent withGooglePlaceType(@Nullable String googlePlaceType) {
        return new InputVenueMessageContent(latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputVenueMessageContent)) {
            return false;
        }
        InputVenueMessageContent that = (InputVenueMessageContent) o;
        return Double.compare(this.latitude, that.latitude) == 0
                && Double.compare(this.longitude, that.longitude) == 0
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.address, that.address)
                && Objects.equals(this.foursquareId, that.foursquareId)
                && Objects.equals(this.foursquareType, that.foursquareType)
                && Objects.equals(this.googlePlaceId, that.googlePlaceId)
                && Objects.equals(this.googlePlaceType, that.googlePlaceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.latitude, this.longitude, this.title, this.address, this.foursquareId, this.foursquareType, this.googlePlaceId, this.googlePlaceType);
    }

    @Override
    public String toString() {
        return "InputVenueMessageContent[latitude=" + this.latitude
                + ", longitude=" + this.longitude
                + ", title=" + this.title
                + ", address=" + this.address
                + ", foursquareId=" + this.foursquareId
                + ", foursquareType=" + this.foursquareType
                + ", googlePlaceId=" + this.googlePlaceId
                + ", googlePlaceType=" + this.googlePlaceType
                + "]";
    }
}
