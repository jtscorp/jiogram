package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use
 * input_message_content to send a message with the specified content instead of the venue.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultvenue">InlineQueryResultVenue in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultVenue implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("latitude")
    private final double latitude;

    @JsonProperty("longitude")
    private final double longitude;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("address")
    private final String address;

    @JsonProperty("foursquare_id")
    private final @Nullable String foursquareId;

    @JsonProperty("foursquare_type")
    private final @Nullable String foursquareType;

    @JsonProperty("google_place_id")
    private final @Nullable String googlePlaceId;

    @JsonProperty("google_place_type")
    private final @Nullable String googlePlaceType;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    @JsonProperty("thumbnail_url")
    private final @Nullable String thumbnailUrl;

    @JsonProperty("thumbnail_width")
    private final @Nullable Long thumbnailWidth;

    @JsonProperty("thumbnail_height")
    private final @Nullable Long thumbnailHeight;

    /**
     * Creates a new {@code InlineQueryResultVenue} instance.
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
     */
    @JsonCreator
    public InlineQueryResultVenue(
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
            @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight) {
        this.type = type;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public static InlineQueryResultVenue of(String id, double latitude, double longitude, String title, String address) {
        return new InlineQueryResultVenue(InlineQueryResultType.VENUE, id, latitude, longitude, title, address, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be venue
     */
    public InlineQueryResultType type() {
        return type;
    }

    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    public String id() {
        return id;
    }

    /**
     * Latitude of the venue location in degrees
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Longitude of the venue location in degrees
     */
    public double longitude() {
        return longitude;
    }

    /**
     * Title of the venue
     */
    public String title() {
        return title;
    }

    /**
     * Address of the venue
     */
    public String address() {
        return address;
    }

    /**
     * Foursquare identifier of the venue if known
     */
    public @Nullable String foursquareId() {
        return foursquareId;
    }

    /**
     * Foursquare type of the venue, if known. (For example, 'arts_entertainment/default',
     * 'arts_entertainment/aquarium' or 'food/icecream'.)
     */
    public @Nullable String foursquareType() {
        return foursquareType;
    }

    /**
     * Google Places identifier of the venue
     */
    public @Nullable String googlePlaceId() {
        return googlePlaceId;
    }

    /**
     * Google Places type of the venue. (See supported types.)
     */
    public @Nullable String googlePlaceType() {
        return googlePlaceType;
    }

    /**
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * Content of the message to be sent instead of the venue
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    /**
     * Url of the thumbnail for the result
     */
    public @Nullable String thumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Thumbnail width
     */
    public @Nullable Long thumbnailWidth() {
        return thumbnailWidth;
    }

    /**
     * Thumbnail height
     */
    public @Nullable Long thumbnailHeight() {
        return thumbnailHeight;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultVenue)) {
            return false;
        }
        InlineQueryResultVenue that = (InlineQueryResultVenue) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Double.compare(this.latitude, that.latitude) == 0
                && Double.compare(this.longitude, that.longitude) == 0
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.address, that.address)
                && Objects.equals(this.foursquareId, that.foursquareId)
                && Objects.equals(this.foursquareType, that.foursquareType)
                && Objects.equals(this.googlePlaceId, that.googlePlaceId)
                && Objects.equals(this.googlePlaceType, that.googlePlaceType)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent)
                && Objects.equals(this.thumbnailUrl, that.thumbnailUrl)
                && Objects.equals(this.thumbnailWidth, that.thumbnailWidth)
                && Objects.equals(this.thumbnailHeight, that.thumbnailHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.latitude, this.longitude, this.title, this.address, this.foursquareId, this.foursquareType, this.googlePlaceId, this.googlePlaceType, this.replyMarkup, this.inputMessageContent, this.thumbnailUrl, this.thumbnailWidth, this.thumbnailHeight);
    }

    @Override
    public String toString() {
        return "InlineQueryResultVenue[type=" + this.type
                + ", id=" + this.id
                + ", latitude=" + this.latitude
                + ", longitude=" + this.longitude
                + ", title=" + this.title
                + ", address=" + this.address
                + ", foursquareId=" + this.foursquareId
                + ", foursquareType=" + this.foursquareType
                + ", googlePlaceId=" + this.googlePlaceId
                + ", googlePlaceType=" + this.googlePlaceType
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + ", thumbnailUrl=" + this.thumbnailUrl
                + ", thumbnailWidth=" + this.thumbnailWidth
                + ", thumbnailHeight=" + this.thumbnailHeight
                + "]";
    }
}
