package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

/**
 * Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use
 * input_message_content to send a message with the specified content instead of the venue.
 *
 * @param type Type of the result, must be venue
 * @param id Unique identifier for this result, 1-64 Bytes
 * @param latitude Latitude of the venue location in degrees
 * @param longitude Longitude of the venue location in degrees
 * @param title Title of the venue
 * @param address Address of the venue
 * @param foursquareId Foursquare identifier of the venue if known
 * @param foursquareType Foursquare type of the venue, if known. (For example,
 *     'arts_entertainment/default', 'arts_entertainment/aquarium' or 'food/icecream'.)
 * @param googlePlaceId Google Places identifier of the venue
 * @param googlePlaceType Google Places type of the venue. (See supported types.)
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the venue
 * @param thumbnailUrl Url of the thumbnail for the result
 * @param thumbnailWidth Thumbnail width
 * @param thumbnailHeight Thumbnail height
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultvenue">InlineQueryResultVenue in the Bot API</a>
 */
public record InlineQueryResultVenue(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("title") String title,
    @JsonProperty("address") String address,
    @JsonProperty("foursquare_id") @Nullable String foursquareId,
    @JsonProperty("foursquare_type") @Nullable String foursquareType,
    @JsonProperty("google_place_id") @Nullable String googlePlaceId,
    @JsonProperty("google_place_type") @Nullable String googlePlaceType,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent,
    @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl,
    @JsonProperty("thumbnail_width") @Nullable Long thumbnailWidth,
    @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight
) implements InlineQueryResult {

    public InlineQueryResultVenue withId(String id) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withLatitude(double latitude) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withLongitude(double longitude) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withTitle(String title) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withAddress(String address) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withFoursquareId(@Nullable String foursquareId) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withFoursquareType(@Nullable String foursquareType) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withGooglePlaceId(@Nullable String googlePlaceId) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withGooglePlaceType(@Nullable String googlePlaceType) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withThumbnailUrl(@Nullable String thumbnailUrl) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withThumbnailWidth(@Nullable Long thumbnailWidth) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultVenue withThumbnailHeight(@Nullable Long thumbnailHeight) {
        return new InlineQueryResultVenue(type, id, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }
}
