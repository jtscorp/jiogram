package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyMarkup;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send point on the map. On success, the sent Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendlocation">sendLocation in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendLocation implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("latitude")
    private final double latitude;

    @JsonProperty("longitude")
    private final double longitude;

    @JsonProperty("horizontal_accuracy")
    private final @Nullable Double horizontalAccuracy;

    @JsonProperty("live_period")
    private final @Nullable Long livePeriod;

    @JsonProperty("heading")
    private final @Nullable Long heading;

    @JsonProperty("proximity_alert_radius")
    private final @Nullable Long proximityAlertRadius;

    @JsonProperty("disable_notification")
    private final @Nullable Boolean disableNotification;

    @JsonProperty("protect_content")
    private final @Nullable Boolean protectContent;

    @JsonProperty("allow_paid_broadcast")
    private final @Nullable Boolean allowPaidBroadcast;

    @JsonProperty("message_effect_id")
    private final @Nullable String messageEffectId;

    @JsonProperty("suggested_post_parameters")
    private final @Nullable SuggestedPostParameters suggestedPostParameters;

    @JsonProperty("reply_parameters")
    private final @Nullable ReplyParameters replyParameters;

    @JsonProperty("reply_markup")
    private final @Nullable ReplyMarkup replyMarkup;

    /**
     * Creates a new {@code SendLocation} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be sent; required if the message is sent to a direct messages chat
     * @param latitude Latitude of the location
     * @param longitude Longitude of the location
     * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters;
     *     0-1500
     * @param livePeriod Period in seconds during which the location will be updated (see Live
     *     Locations, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be
     *     edited indefinitely.
     * @param heading For live locations, a direction in which the user is moving, in degrees. Must
     *     be between 1 and 360 if specified.
     * @param proximityAlertRadius For live locations, a maximum distance for proximity alerts about
     *     approaching another chat member, in meters. Must be between 1 and 100000 if specified.
     * @param disableNotification Sends the message silently. Users will receive a notification with
     *     no sound.
     * @param protectContent Protects the contents of the sent message from forwarding and saving
     * @param allowPaidBroadcast Pass True to allow up to 1000 messages per second, ignoring
     *     broadcasting limits for a fee of 0.1 Telegram Stars per message. The relevant Stars will
     *     be withdrawn from the bot's balance
     * @param messageEffectId Unique identifier of the message effect to be added to the message;
     *     for private chats only
     * @param suggestedPostParameters A JSON-serialized object containing the parameters of the
     *     suggested post to send; for direct messages chats only. If the message is sent as a reply
     *     to another suggested post, then that suggested post is automatically declined.
     * @param replyParameters Description of the message to reply to
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline
     *     keyboard, custom reply keyboard, instructions to remove a reply keyboard or to force a
     *     reply from the user
     */
    @JsonCreator
    public SendLocation(
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
            @JsonProperty("reply_markup") @Nullable ReplyMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.horizontalAccuracy = horizontalAccuracy;
        this.livePeriod = livePeriod;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
        this.disableNotification = disableNotification;
        this.protectContent = protectContent;
        this.allowPaidBroadcast = allowPaidBroadcast;
        this.messageEffectId = messageEffectId;
        this.suggestedPostParameters = suggestedPostParameters;
        this.replyParameters = replyParameters;
        this.replyMarkup = replyMarkup;
    }

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

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendLocation answer(Message message, double latitude, double longitude) {
        return new SendLocation(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), latitude, longitude, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendLocation reply(Message message, double latitude, double longitude) {
        return new SendLocation(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), latitude, longitude, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
    }

    /**
     * Unique identifier of the business connection on behalf of which the message will be sent
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Unique identifier for the target chat or username of the target channel (in the format
     * &#64;channelusername)
     */
    public ChatId chatId() {
        return chatId;
    }

    /**
     * Unique identifier for the target message thread (topic) of a forum; for forum supergroups and
     * private chats of bots with forum topic mode enabled only
     */
    public @Nullable Long messageThreadId() {
        return messageThreadId;
    }

    /**
     * Identifier of the direct messages topic to which the message will be sent; required if the
     * message is sent to a direct messages chat
     */
    public @Nullable Long directMessagesTopicId() {
        return directMessagesTopicId;
    }

    /**
     * Latitude of the location
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Longitude of the location
     */
    public double longitude() {
        return longitude;
    }

    /**
     * The radius of uncertainty for the location, measured in meters; 0-1500
     */
    public @Nullable Double horizontalAccuracy() {
        return horizontalAccuracy;
    }

    /**
     * Period in seconds during which the location will be updated (see Live Locations, should be
     * between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
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
     * Sends the message silently. Users will receive a notification with no sound.
     */
    public @Nullable Boolean disableNotification() {
        return disableNotification;
    }

    /**
     * Protects the contents of the sent message from forwarding and saving
     */
    public @Nullable Boolean protectContent() {
        return protectContent;
    }

    /**
     * Pass True to allow up to 1000 messages per second, ignoring broadcasting limits for a fee of
     * 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     */
    public @Nullable Boolean allowPaidBroadcast() {
        return allowPaidBroadcast;
    }

    /**
     * Unique identifier of the message effect to be added to the message; for private chats only
     */
    public @Nullable String messageEffectId() {
        return messageEffectId;
    }

    /**
     * A JSON-serialized object containing the parameters of the suggested post to send; for direct
     * messages chats only. If the message is sent as a reply to another suggested post, then that
     * suggested post is automatically declined.
     */
    public @Nullable SuggestedPostParameters suggestedPostParameters() {
        return suggestedPostParameters;
    }

    /**
     * Description of the message to reply to
     */
    public @Nullable ReplyParameters replyParameters() {
        return replyParameters;
    }

    /**
     * Additional interface options. A JSON-serialized object for an inline keyboard, custom reply
     * keyboard, instructions to remove a reply keyboard or to force a reply from the user
     */
    public @Nullable ReplyMarkup replyMarkup() {
        return replyMarkup;
    }

    public SendLocation withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withChatId(ChatId chatId) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withLatitude(double latitude) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withLongitude(double longitude) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withHorizontalAccuracy(@Nullable Double horizontalAccuracy) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withLivePeriod(@Nullable Long livePeriod) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withHeading(@Nullable Long heading) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withProximityAlertRadius(@Nullable Long proximityAlertRadius) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withProtectContent(@Nullable Boolean protectContent) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withMessageEffectId(@Nullable String messageEffectId) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendLocation withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendLocation(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, horizontalAccuracy, livePeriod, heading, proximityAlertRadius, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendLocation)) {
            return false;
        }
        SendLocation that = (SendLocation) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Double.compare(this.latitude, that.latitude) == 0
                && Double.compare(this.longitude, that.longitude) == 0
                && Objects.equals(this.horizontalAccuracy, that.horizontalAccuracy)
                && Objects.equals(this.livePeriod, that.livePeriod)
                && Objects.equals(this.heading, that.heading)
                && Objects.equals(this.proximityAlertRadius, that.proximityAlertRadius)
                && Objects.equals(this.disableNotification, that.disableNotification)
                && Objects.equals(this.protectContent, that.protectContent)
                && Objects.equals(this.allowPaidBroadcast, that.allowPaidBroadcast)
                && Objects.equals(this.messageEffectId, that.messageEffectId)
                && Objects.equals(this.suggestedPostParameters, that.suggestedPostParameters)
                && Objects.equals(this.replyParameters, that.replyParameters)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.directMessagesTopicId, this.latitude, this.longitude, this.horizontalAccuracy, this.livePeriod, this.heading, this.proximityAlertRadius, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.suggestedPostParameters, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendLocation[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", latitude=" + this.latitude
                + ", longitude=" + this.longitude
                + ", horizontalAccuracy=" + this.horizontalAccuracy
                + ", livePeriod=" + this.livePeriod
                + ", heading=" + this.heading
                + ", proximityAlertRadius=" + this.proximityAlertRadius
                + ", disableNotification=" + this.disableNotification
                + ", protectContent=" + this.protectContent
                + ", allowPaidBroadcast=" + this.allowPaidBroadcast
                + ", messageEffectId=" + this.messageEffectId
                + ", suggestedPostParameters=" + this.suggestedPostParameters
                + ", replyParameters=" + this.replyParameters
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
