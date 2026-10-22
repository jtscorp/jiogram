package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyMarkup;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send point on the map. On success, the sent Message is returned.
 *
 * @param businessConnectionId Unique identifier of the business connection on behalf of which the
 *     message will be sent
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the message will be
 *     sent; required if the message is sent to a direct messages chat
 * @param latitude Latitude of the location
 * @param longitude Longitude of the location
 * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500
 * @param livePeriod Period in seconds during which the location will be updated (see Live
 *     Locations, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be
 *     edited indefinitely.
 * @param heading For live locations, a direction in which the user is moving, in degrees. Must be
 *     between 1 and 360 if specified.
 * @param proximityAlertRadius For live locations, a maximum distance for proximity alerts about
 *     approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @param disableNotification Sends the message silently. Users will receive a notification with no
 *     sound.
 * @param protectContent Protects the contents of the sent message from forwarding and saving
 * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
 *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will be
 *     withdrawn from the bot's balance
 * @param messageEffectId Unique identifier of the message effect to be added to the message; for
 *     private chats only
 * @param suggestedPostParameters A JSON-serialized object containing the parameters of the
 *     suggested post to send; for direct messages chats only. If the message is sent as a reply to
 *     another suggested post, then that suggested post is automatically declined.
 * @param replyParameters Description of the message to reply to
 * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard,
 *     custom reply keyboard, instructions to remove a reply keyboard or to force a reply from the
 *     user
 * @see <a href="https://core.telegram.org/bots/api#sendlocation">sendLocation in the Bot API</a>
 */
public record SendLocation(
    @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
    @JsonProperty("chat_id") ChatId chatId,
    @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
    @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
    @JsonProperty("latitude") double latitude,
    @JsonProperty("longitude") double longitude,
    @JsonProperty("horizontal_accuracy") @Nullable Double horizontalAccuracy,
    @JsonProperty("live_period") @Nullable Long livePeriod,
    @JsonProperty("heading") @Nullable Long heading,
    @JsonProperty("proximity_alert_radius") @Nullable Long proximityAlertRadius,
    @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
    @JsonProperty("protect_content") @Nullable Boolean protectContent,
    @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
    @JsonProperty("message_effect_id") @Nullable String messageEffectId,
    @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
    @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
    @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup
) implements TelegramMethod<Message> {

    @Override
    public String apiMethod() {
        return "sendLocation";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendLocation of(ChatId chatId, double latitude, double longitude) {
        return new SendLocation(null, chatId, null, null, latitude, longitude, null, null, null, null, null, null, null, null, null, null, null);
    }
}
