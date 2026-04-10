package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingAddress {
    @JsonProperty("country_code") private final String countryCode;
    @JsonProperty("state") private final String state;
    @JsonProperty("city") private final String city;
    @JsonProperty("street_line1") private final String streetLine1;
    @JsonProperty("street_line2") private final String streetLine2;
    @JsonProperty("post_code") private final String postCode;

    @JsonCreator
    public ShippingAddress(
            @JsonProperty("country_code") String countryCode,
            @JsonProperty("state") String state,
            @JsonProperty("city") String city,
            @JsonProperty("street_line1") String streetLine1,
            @JsonProperty("street_line2") String streetLine2,
            @JsonProperty("post_code") String postCode
    ) {
        this.countryCode = countryCode;
        this.state = state;
        this.city = city;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.postCode = postCode;
    }

    public String countryCode() {
        return this.countryCode;
    }

    public String state() {
        return this.state;
    }

    public String city() {
        return this.city;
    }

    public String streetLine1() {
        return this.streetLine1;
    }

    public String streetLine2() {
        return this.streetLine2;
    }

    public String postCode() {
        return this.postCode;
    }
}
