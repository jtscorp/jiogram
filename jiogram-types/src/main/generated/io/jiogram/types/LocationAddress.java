package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Describes the physical address of a location.
 *
 * @param countryCode The two-letter ISO 3166-1 alpha-2 country code of the country where the
 *     location is located
 * @param state State of the location
 * @param city City of the location
 * @param street Street address of the location
 * @see <a href="https://core.telegram.org/bots/api#locationaddress">LocationAddress in the Bot API</a>
 */
public record LocationAddress(
    @JsonProperty("country_code") String countryCode,
    @JsonProperty("state") @Nullable String state,
    @JsonProperty("city") @Nullable String city,
    @JsonProperty("street") @Nullable String street
) {

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
}
