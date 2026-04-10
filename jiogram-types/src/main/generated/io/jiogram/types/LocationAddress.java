package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class LocationAddress {
    @JsonProperty("country_code") private final String countryCode;
    @JsonProperty("state") @Nullable private final String state;
    @JsonProperty("city") @Nullable private final String city;
    @JsonProperty("street") @Nullable private final String street;

    @JsonCreator
    public LocationAddress(
            @JsonProperty("country_code") String countryCode,
            @JsonProperty("state") @Nullable String state,
            @JsonProperty("city") @Nullable String city,
            @JsonProperty("street") @Nullable String street
    ) {
        this.countryCode = countryCode;
        this.state = state;
        this.city = city;
        this.street = street;
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

    public String street() {
        return this.street;
    }
}
