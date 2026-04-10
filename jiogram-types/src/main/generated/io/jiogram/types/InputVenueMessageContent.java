package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class InputVenueMessageContent implements InputMessageContent {
    @JsonProperty("latitude") private final double latitude;
    @JsonProperty("longitude") private final double longitude;
    @JsonProperty("title") private final String title;
    @JsonProperty("address") private final String address;
    @JsonProperty("foursquare_id") @Nullable private final String foursquareId;
    @JsonProperty("foursquare_type") @Nullable private final String foursquareType;
    @JsonProperty("google_place_id") @Nullable private final String googlePlaceId;
    @JsonProperty("google_place_type") @Nullable private final String googlePlaceType;

    @JsonCreator
    public InputVenueMessageContent(
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("title") String title,
            @JsonProperty("address") String address,
            @JsonProperty("foursquare_id") @Nullable String foursquareId,
            @JsonProperty("foursquare_type") @Nullable String foursquareType,
            @JsonProperty("google_place_id") @Nullable String googlePlaceId,
            @JsonProperty("google_place_type") @Nullable String googlePlaceType
    ) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

    public String title() {
        return this.title;
    }

    public String address() {
        return this.address;
    }

    public String foursquareId() {
        return this.foursquareId;
    }

    public String foursquareType() {
        return this.foursquareType;
    }

    public String googlePlaceId() {
        return this.googlePlaceId;
    }

    public String googlePlaceType() {
        return this.googlePlaceType;
    }
}
