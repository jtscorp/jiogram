package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a venue.
 *
 * @see <a href="https://core.telegram.org/bots/api#venue">Venue in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Venue {

    @JsonProperty("location")
    private final Location location;

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
     * Creates a new {@code Venue} instance.
     *
     * @param location Venue location. Can't be a live location
     * @param title Name of the venue
     * @param address Address of the venue
     * @param foursquareId Foursquare identifier of the venue
     * @param foursquareType Foursquare type of the venue. (For example,
     *     'arts_entertainment/default', 'arts_entertainment/aquarium' or 'food/icecream'.)
     * @param googlePlaceId Google Places identifier of the venue
     * @param googlePlaceType Google Places type of the venue. (See supported types.)
     */
    @JsonCreator
    public Venue(
            @JsonProperty("location") Location location,
            @JsonProperty("title") String title,
            @JsonProperty("address") String address,
            @JsonProperty("foursquare_id") @Nullable String foursquareId,
            @JsonProperty("foursquare_type") @Nullable String foursquareType,
            @JsonProperty("google_place_id") @Nullable String googlePlaceId,
            @JsonProperty("google_place_type") @Nullable String googlePlaceType) {
        this.location = location;
        this.title = title;
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
    }

    public static Venue of(Location location, String title, String address) {
        return new Venue(location, title, address, null, null, null, null);
    }

    /**
     * Venue location. Can't be a live location
     */
    public Location location() {
        return location;
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
     * Foursquare identifier of the venue
     */
    public @Nullable String foursquareId() {
        return foursquareId;
    }

    /**
     * Foursquare type of the venue. (For example, 'arts_entertainment/default',
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

    public Venue withLocation(Location location) {
        return new Venue(location, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public Venue withTitle(String title) {
        return new Venue(location, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public Venue withAddress(String address) {
        return new Venue(location, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public Venue withFoursquareId(@Nullable String foursquareId) {
        return new Venue(location, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public Venue withFoursquareType(@Nullable String foursquareType) {
        return new Venue(location, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public Venue withGooglePlaceId(@Nullable String googlePlaceId) {
        return new Venue(location, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    public Venue withGooglePlaceType(@Nullable String googlePlaceType) {
        return new Venue(location, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Venue)) {
            return false;
        }
        Venue that = (Venue) o;
        return Objects.equals(this.location, that.location)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.address, that.address)
                && Objects.equals(this.foursquareId, that.foursquareId)
                && Objects.equals(this.foursquareType, that.foursquareType)
                && Objects.equals(this.googlePlaceId, that.googlePlaceId)
                && Objects.equals(this.googlePlaceType, that.googlePlaceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.location, this.title, this.address, this.foursquareId, this.foursquareType, this.googlePlaceId, this.googlePlaceType);
    }

    @Override
    public String toString() {
        return "Venue[location=" + this.location
                + ", title=" + this.title
                + ", address=" + this.address
                + ", foursquareId=" + this.foursquareId
                + ", foursquareType=" + this.foursquareType
                + ", googlePlaceId=" + this.googlePlaceId
                + ", googlePlaceType=" + this.googlePlaceType
                + "]";
    }
}
