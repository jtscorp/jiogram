package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a shipping address.
 *
 * @see <a href="https://core.telegram.org/bots/api#shippingaddress">ShippingAddress in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ShippingAddress {

    @JsonProperty("country_code")
    private final String countryCode;

    @JsonProperty("state")
    private final String state;

    @JsonProperty("city")
    private final String city;

    @JsonProperty("street_line1")
    private final String streetLine1;

    @JsonProperty("street_line2")
    private final String streetLine2;

    @JsonProperty("post_code")
    private final String postCode;

    /**
     * Creates a new {@code ShippingAddress} instance.
     *
     * @param countryCode Two-letter ISO 3166-1 alpha-2 country code
     * @param state State, if applicable
     * @param city City
     * @param streetLine1 First line for the address
     * @param streetLine2 Second line for the address
     * @param postCode Address post code
     */
    @JsonCreator
    public ShippingAddress(
            @JsonProperty("country_code") String countryCode,
            @JsonProperty("state") String state,
            @JsonProperty("city") String city,
            @JsonProperty("street_line1") String streetLine1,
            @JsonProperty("street_line2") String streetLine2,
            @JsonProperty("post_code") String postCode) {
        this.countryCode = countryCode;
        this.state = state;
        this.city = city;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.postCode = postCode;
    }

    /**
     * Two-letter ISO 3166-1 alpha-2 country code
     */
    public String countryCode() {
        return countryCode;
    }

    /**
     * State, if applicable
     */
    public String state() {
        return state;
    }

    /**
     * City
     */
    public String city() {
        return city;
    }

    /**
     * First line for the address
     */
    public String streetLine1() {
        return streetLine1;
    }

    /**
     * Second line for the address
     */
    public String streetLine2() {
        return streetLine2;
    }

    /**
     * Address post code
     */
    public String postCode() {
        return postCode;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShippingAddress)) {
            return false;
        }
        ShippingAddress that = (ShippingAddress) o;
        return Objects.equals(this.countryCode, that.countryCode)
                && Objects.equals(this.state, that.state)
                && Objects.equals(this.city, that.city)
                && Objects.equals(this.streetLine1, that.streetLine1)
                && Objects.equals(this.streetLine2, that.streetLine2)
                && Objects.equals(this.postCode, that.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.countryCode, this.state, this.city, this.streetLine1, this.streetLine2, this.postCode);
    }

    @Override
    public String toString() {
        return "ShippingAddress[countryCode=" + this.countryCode
                + ", state=" + this.state
                + ", city=" + this.city
                + ", streetLine1=" + this.streetLine1
                + ", streetLine2=" + this.streetLine2
                + ", postCode=" + this.postCode
                + "]";
    }
}
