package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

/**
 * Represents a location on a map. By default, the location will be sent by the user. Alternatively,
 * you can use input_message_content to send a message with the specified content instead of the
 * location.
 *
 * @param type Type of the result, must be location
 * @param id Unique identifier for this result, 1-64 Bytes
 * @param latitude Location latitude in degrees
 * @param longitude Location longitude in degrees
 * @param title Location title
 * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500
 * @param livePeriod Period in seconds during which the location can be updated, should be between
 *     60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
 * @param heading For live locations, a direction in which the user is moving, in degrees. Must be
 *     between 1 and 360 if specified.
 * @param proximityAlertRadius For live locations, a maximum distance for proximity alerts about
 *     approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the location
 * @param thumbnailUrl Url of the thumbnail for the result
 * @param thumbnailWidth Thumbnail width
 * @param thumbnailHeight Thumbnail height
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultlocation">InlineQueryResultLocation in the Bot API</a>
 */
public record InlineQueryResultLocation(
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
    @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight
) implements InlineQueryResult {}
