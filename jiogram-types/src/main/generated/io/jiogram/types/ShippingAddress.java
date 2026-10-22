package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a shipping address.
 *
 * @param countryCode Two-letter ISO 3166-1 alpha-2 country code
 * @param state State, if applicable
 * @param city City
 * @param streetLine1 First line for the address
 * @param streetLine2 Second line for the address
 * @param postCode Address post code
 * @see <a href="https://core.telegram.org/bots/api#shippingaddress">ShippingAddress in the Bot API</a>
 */
public record ShippingAddress(
    @JsonProperty("country_code") String countryCode,
    @JsonProperty("state") String state,
    @JsonProperty("city") String city,
    @JsonProperty("street_line1") String streetLine1,
    @JsonProperty("street_line2") String streetLine2,
    @JsonProperty("post_code") String postCode
) {

    public ShippingAddress withCountryCode(String countryCode) {
        return new ShippingAddress(countryCode, state, city, streetLine1, streetLine2, postCode);
    }

    public ShippingAddress withState(String state) {
        return new ShippingAddress(countryCode, state, city, streetLine1, streetLine2, postCode);
    }

    public ShippingAddress withCity(String city) {
        return new ShippingAddress(countryCode, state, city, streetLine1, streetLine2, postCode);
    }

    public ShippingAddress withStreetLine1(String streetLine1) {
        return new ShippingAddress(countryCode, state, city, streetLine1, streetLine2, postCode);
    }

    public ShippingAddress withStreetLine2(String streetLine2) {
        return new ShippingAddress(countryCode, state, city, streetLine1, streetLine2, postCode);
    }

    public ShippingAddress withPostCode(String postCode) {
        return new ShippingAddress(countryCode, state, city, streetLine1, streetLine2, postCode);
    }
}
