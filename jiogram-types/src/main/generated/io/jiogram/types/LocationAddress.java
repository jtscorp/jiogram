package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes the physical address of a location.
 *
 * @see <a href="https://core.telegram.org/bots/api#locationaddress">LocationAddress in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class LocationAddress {

    @JsonProperty("country_code")
    private final String countryCode;

    @JsonProperty("state")
    private final @Nullable String state;

    @JsonProperty("city")
    private final @Nullable String city;

    @JsonProperty("street")
    private final @Nullable String street;

    /**
     * Creates a new {@code LocationAddress} instance.
     *
     * @param countryCode The two-letter ISO 3166-1 alpha-2 country code of the country where the
     *     location is located
     * @param state State of the location
     * @param city City of the location
     * @param street Street address of the location
     */
    @JsonCreator
    public LocationAddress(
            @JsonProperty("country_code") String countryCode,
            @JsonProperty("state") @Nullable String state,
            @JsonProperty("city") @Nullable String city,
            @JsonProperty("street") @Nullable String street) {
        this.countryCode = countryCode;
        this.state = state;
        this.city = city;
        this.street = street;
    }

    public static LocationAddress of(String countryCode) {
        return new LocationAddress(countryCode, null, null, null);
    }

    /**
     * The two-letter ISO 3166-1 alpha-2 country code of the country where the location is located
     */
    public String countryCode() {
        return countryCode;
    }

    /**
     * State of the location
     */
    public @Nullable String state() {
        return state;
    }

    /**
     * City of the location
     */
    public @Nullable String city() {
        return city;
    }

    /**
     * Street address of the location
     */
    public @Nullable String street() {
        return street;
    }

    public LocationAddress withCountryCode(String countryCode) {
        return new LocationAddress(countryCode, state, city, street);
    }

    public LocationAddress withState(@Nullable String state) {
        return new LocationAddress(countryCode, state, city, street);
    }

    public LocationAddress withCity(@Nullable String city) {
        return new LocationAddress(countryCode, state, city, street);
    }

    public LocationAddress withStreet(@Nullable String street) {
        return new LocationAddress(countryCode, state, city, street);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LocationAddress)) {
            return false;
        }
        LocationAddress that = (LocationAddress) o;
        return Objects.equals(this.countryCode, that.countryCode)
                && Objects.equals(this.state, that.state)
                && Objects.equals(this.city, that.city)
                && Objects.equals(this.street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.countryCode, this.state, this.city, this.street);
    }

    @Override
    public String toString() {
        return "LocationAddress[countryCode=" + this.countryCode
                + ", state=" + this.state
                + ", city=" + this.city
                + ", street=" + this.street
                + "]";
    }
}
