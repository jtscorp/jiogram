package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Location;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a venue.
 *
 * @param location Venue location. Can't be a live location
 * @param title Name of the venue
 * @param address Address of the venue
 * @param foursquareId Foursquare identifier of the venue
 * @param foursquareType Foursquare type of the venue. (For example, 'arts_entertainment/default',
 *     'arts_entertainment/aquarium' or 'food/icecream'.)
 * @param googlePlaceId Google Places identifier of the venue
 * @param googlePlaceType Google Places type of the venue. (See supported types.)
 * @see <a href="https://core.telegram.org/bots/api#venue">Venue in the Bot API</a>
 */
public record Venue(
    @JsonProperty("location") Location location,
    @JsonProperty("title") String title,
    @JsonProperty("address") String address,
    @JsonProperty("foursquare_id") @Nullable String foursquareId,
    @JsonProperty("foursquare_type") @Nullable String foursquareType,
    @JsonProperty("google_place_id") @Nullable String googlePlaceId,
    @JsonProperty("google_place_type") @Nullable String googlePlaceType
) {}
