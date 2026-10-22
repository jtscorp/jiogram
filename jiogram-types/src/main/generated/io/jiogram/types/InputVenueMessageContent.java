package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Represents the content of a venue message to be sent as the result of an inline query.
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
 * @see <a href="https://core.telegram.org/bots/api#inputvenuemessagecontent">InputVenueMessageContent in the Bot API</a>
 */
public record InputVenueMessageContent(
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("title") String title,
    @JsonProperty("address") String address,
    @JsonProperty("foursquare_id") @Nullable String foursquareId,
    @JsonProperty("foursquare_type") @Nullable String foursquareType,
    @JsonProperty("google_place_id") @Nullable String googlePlaceId,
    @JsonProperty("google_place_type") @Nullable String googlePlaceType
) implements InputMessageContent {}
