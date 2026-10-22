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
 * Represents a location on a map. By default, the location will be sent by the user. Alternatively,
 * you can use input_message_content to send a message with the specified content instead of the
 * location.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultlocation">InlineQueryResultLocation in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultLocation implements InlineQueryResult {

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

    @JsonProperty("horizontal_accuracy")
    private final @Nullable Double horizontalAccuracy;

    @JsonProperty("live_period")
    private final @Nullable Long livePeriod;

    @JsonProperty("heading")
    private final @Nullable Long heading;

    @JsonProperty("proximity_alert_radius")
    private final @Nullable Long proximityAlertRadius;

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
     * Creates a new {@code InlineQueryResultLocation} instance.
     *
     * @param type Type of the result, must be location
     * @param id Unique identifier for this result, 1-64 Bytes
     * @param latitude Location latitude in degrees
     * @param longitude Location longitude in degrees
     * @param title Location title
     * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters;
     *     0-1500
     * @param livePeriod Period in seconds during which the location can be updated, should be
     *     between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
     * @param heading For live locations, a direction in which the user is moving, in degrees. Must
     *     be between 1 and 360 if specified.
     * @param proximityAlertRadius For live locations, a maximum distance for proximity alerts about
     *     approaching another chat member, in meters. Must be between 1 and 100000 if specified.
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the location
     * @param thumbnailUrl Url of the thumbnail for the result
     * @param thumbnailWidth Thumbnail width
     * @param thumbnailHeight Thumbnail height
     */
    @JsonCreator
    public InlineQueryResultLocation(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("title") String title,
            @JsonProperty("horizontal_accuracy") @Nullable Double horizontalAccuracy,
            @JsonProperty("live_period") @Nullable Long livePeriod,
            @JsonProperty("heading") @Nullable Long heading,
            @JsonProperty("proximity_alert_radius") @Nullable Long proximityAlertRadius,
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
        this.horizontalAccuracy = horizontalAccuracy;
        this.livePeriod = livePeriod;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public static InlineQueryResultLocation of(String id, double latitude, double longitude, String title) {
        return new InlineQueryResultLocation(InlineQueryResultType.LOCATION, id, latitude, longitude, title, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be location
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
     * Location latitude in degrees
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Location longitude in degrees
     */
    public double longitude() {
        return longitude;
    }

    /**
     * Location title
     */
    public String title() {
        return title;
    }

    /**
     * The radius of uncertainty for the location, measured in meters; 0-1500
     */
    public @Nullable Double horizontalAccuracy() {
        return horizontalAccuracy;
    }

    /**
     * Period in seconds during which the location can be updated, should be between 60 and 86400,
     * or 0x7FFFFFFF for live locations that can be edited indefinitely.
     */
    public @Nullable Long livePeriod() {
        return livePeriod;
    }

    /**
     * For live locations, a direction in which the user is moving, in degrees. Must be between 1
     * and 360 if specified.
     */
    public @Nullable Long heading() {
        return heading;
    }

    /**
     * For live locations, a maximum distance for proximity alerts about approaching another chat
     * member, in meters. Must be between 1 and 100000 if specified.
     */
    public @Nullable Long proximityAlertRadius() {
        return proximityAlertRadius;
    }

    /**
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * Content of the message to be sent instead of the location
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

    public InlineQueryResultLocation withId(String id) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withLatitude(double latitude) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withLongitude(double longitude) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withTitle(String title) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withHorizontalAccuracy(@Nullable Double horizontalAccuracy) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withLivePeriod(@Nullable Long livePeriod) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withHeading(@Nullable Long heading) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withProximityAlertRadius(@Nullable Long proximityAlertRadius) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withThumbnailUrl(@Nullable String thumbnailUrl) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withThumbnailWidth(@Nullable Long thumbnailWidth) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultLocation withThumbnailHeight(@Nullable Long thumbnailHeight) {
        return new InlineQueryResultLocation(type, id, latitude, longitude, title, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultLocation)) {
            return false;
        }
        InlineQueryResultLocation that = (InlineQueryResultLocation) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Double.compare(this.latitude, that.latitude) == 0
                && Double.compare(this.longitude, that.longitude) == 0
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.horizontalAccuracy, that.horizontalAccuracy)
                && Objects.equals(this.livePeriod, that.livePeriod)
                && Objects.equals(this.heading, that.heading)
                && Objects.equals(this.proximityAlertRadius, that.proximityAlertRadius)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent)
                && Objects.equals(this.thumbnailUrl, that.thumbnailUrl)
                && Objects.equals(this.thumbnailWidth, that.thumbnailWidth)
                && Objects.equals(this.thumbnailHeight, that.thumbnailHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.latitude, this.longitude, this.title, this.horizontalAccuracy, this.livePeriod, this.heading, this.proximityAlertRadius, this.replyMarkup, this.inputMessageContent, this.thumbnailUrl, this.thumbnailWidth, this.thumbnailHeight);
    }

    @Override
    public String toString() {
        return "InlineQueryResultLocation[type=" + this.type
                + ", id=" + this.id
                + ", latitude=" + this.latitude
                + ", longitude=" + this.longitude
                + ", title=" + this.title
                + ", horizontalAccuracy=" + this.horizontalAccuracy
                + ", livePeriod=" + this.livePeriod
                + ", heading=" + this.heading
                + ", proximityAlertRadius=" + this.proximityAlertRadius
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + ", thumbnailUrl=" + this.thumbnailUrl
                + ", thumbnailWidth=" + this.thumbnailWidth
                + ", thumbnailHeight=" + this.thumbnailHeight
                + "]";
    }
}
