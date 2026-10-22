package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit live location messages. A location can be edited until its live_period
 * expires or editing is explicitly disabled by a call to stopMessageLiveLocation. On success, if
 * the edited message is not an inline message, the edited Message is returned, otherwise True is
 * returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message to be edited was sent
 * @param chatId Required if inline_message_id is not specified. Unique identifier for the target
 *     chat or username of the target channel (in the format &#64;channelusername)
 * @param messageId Required if inline_message_id is not specified. Identifier of the message to
 *     edit
 * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of the
 *     inline message
 * @param latitude Latitude of new location
 * @param longitude Longitude of new location
 * @param livePeriod New period in seconds during which the location can be updated, starting from
 *     the message send date. If 0x7FFFFFFF is specified, then the location can be updated forever.
 *     Otherwise, the new value must not exceed the current live_period by more than a day, and the
 *     live location expiration date must remain within the next 90 days. If not specified, then
 *     live_period remains unchanged
 * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500
 * @param heading Direction in which the user is moving, in degrees. Must be between 1 and 360 if
 *     specified.
 * @param proximityAlertRadius The maximum distance for proximity alerts about approaching another
 *     chat member, in meters. Must be between 1 and 100000 if specified.
 * @param replyMarkup A JSON-serialized object for a new inline keyboard.
 * @see <a href="https://core.telegram.org/bots/api#editmessagelivelocation">editMessageLiveLocation in the Bot API</a>
 */
public record EditMessageLiveLocation(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") @Nullable ChatId chatId,
    @JsonProperty("message_id") @Nullable Long messageId,
    @JsonProperty("inline_message_id") @Nullable String inlineMessageId,
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("live_period") @Nullable Long livePeriod,
    @JsonProperty("horizontal_accuracy") @Nullable Double horizontalAccuracy,
    @JsonProperty("heading") @Nullable Long heading,
    @JsonProperty("proximity_alert_radius") @Nullable Long proximityAlertRadius,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "editMessageLiveLocation";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static EditMessageLiveLocation of(double latitude, double longitude) {
        return new EditMessageLiveLocation(null, null, null, null, latitude, longitude, null, null, null, null, null);
    }
}
