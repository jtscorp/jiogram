package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Represents the content of a location message to be sent as the result of an inline query.
 *
 * @param latitude Latitude of the location in degrees
 * @param longitude Longitude of the location in degrees
 * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500
 * @param livePeriod Period in seconds during which the location can be updated, should be between
 *     60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
 * @param heading For live locations, a direction in which the user is moving, in degrees. Must be
 *     between 1 and 360 if specified.
 * @param proximityAlertRadius For live locations, a maximum distance for proximity alerts about
 *     approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @see <a href="https://core.telegram.org/bots/api#inputlocationmessagecontent">InputLocationMessageContent in the Bot API</a>
 */
public record InputLocationMessageContent(
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("horizontal_accuracy") @Nullable Double horizontalAccuracy,
    @JsonProperty("live_period") @Nullable Long livePeriod,
    @JsonProperty("heading") @Nullable Long heading,
    @JsonProperty("proximity_alert_radius") @Nullable Long proximityAlertRadius
) implements InputMessageContent {}
