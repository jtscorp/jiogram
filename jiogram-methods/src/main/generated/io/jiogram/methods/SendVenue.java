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
 * Use this method to send information about a venue. On success, the sent Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendvenue">sendVenue in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendVenue implements TelegramMethod<Message> {

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
     * Creates a new {@code SendVenue} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message will be sent
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be sent; required if the message is sent to a direct messages chat
     * @param latitude Latitude of the venue
     * @param longitude Longitude of the venue
     * @param title Name of the venue
     * @param address Address of the venue
     * @param foursquareId Foursquare identifier of the venue
     * @param foursquareType Foursquare type of the venue, if known. (For example,
     *     'arts_entertainment/default', 'arts_entertainment/aquarium' or 'food/icecream'.)
     * @param googlePlaceId Google Places identifier of the venue
     * @param googlePlaceType Google Places type of the venue. (See supported types.)
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
    public SendVenue(
            @JsonProperty("business_connection_id") @Nullable String businessConnectionId,
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("title") String title,
            @JsonProperty("address") String address,
            @JsonProperty("foursquare_id") @Nullable String foursquareId,
            @JsonProperty("foursquare_type") @Nullable String foursquareType,
            @JsonProperty("google_place_id") @Nullable String googlePlaceId,
            @JsonProperty("google_place_type") @Nullable String googlePlaceType,
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
        this.title = title;
        this.address = address;
        this.foursquareId = foursquareId;
        this.foursquareType = foursquareType;
        this.googlePlaceId = googlePlaceId;
        this.googlePlaceType = googlePlaceType;
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
        return "sendVenue";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendVenue of(ChatId chatId, double latitude, double longitude, String title, String address) {
        return new SendVenue(null, chatId, null, null, latitude, longitude, title, address, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendVenue answer(Message message, double latitude, double longitude, String title, String address) {
        return new SendVenue(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), latitude, longitude, title, address, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendVenue reply(Message message, double latitude, double longitude, String title, String address) {
        return new SendVenue(ReplyTarget.businessConnectionId(message), ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), latitude, longitude, title, address, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
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
     * Latitude of the venue
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Longitude of the venue
     */
    public double longitude() {
        return longitude;
    }

    /**
     * Name of the venue
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
     * Foursquare identifier of the venue
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

    public SendVenue withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withChatId(ChatId chatId) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withLatitude(double latitude) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withLongitude(double longitude) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withTitle(String title) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withAddress(String address) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withFoursquareId(@Nullable String foursquareId) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withFoursquareType(@Nullable String foursquareType) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withGooglePlaceId(@Nullable String googlePlaceId) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withGooglePlaceType(@Nullable String googlePlaceType) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withProtectContent(@Nullable Boolean protectContent) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withMessageEffectId(@Nullable String messageEffectId) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendVenue withReplyMarkup(@Nullable ReplyMarkup replyMarkup) {
        return new SendVenue(businessConnectionId, chatId, messageThreadId, directMessagesTopicId, latitude, longitude, title, address, foursquareId, foursquareType, googlePlaceId, googlePlaceType, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendVenue)) {
            return false;
        }
        SendVenue that = (SendVenue) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Double.compare(this.latitude, that.latitude) == 0
                && Double.compare(this.longitude, that.longitude) == 0
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.address, that.address)
                && Objects.equals(this.foursquareId, that.foursquareId)
                && Objects.equals(this.foursquareType, that.foursquareType)
                && Objects.equals(this.googlePlaceId, that.googlePlaceId)
                && Objects.equals(this.googlePlaceType, that.googlePlaceType)
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
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageThreadId, this.directMessagesTopicId, this.latitude, this.longitude, this.title, this.address, this.foursquareId, this.foursquareType, this.googlePlaceId, this.googlePlaceType, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.suggestedPostParameters, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendVenue[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", latitude=" + this.latitude
                + ", longitude=" + this.longitude
                + ", title=" + this.title
                + ", address=" + this.address
                + ", foursquareId=" + this.foursquareId
                + ", foursquareType=" + this.foursquareType
                + ", googlePlaceId=" + this.googlePlaceId
                + ", googlePlaceType=" + this.googlePlaceType
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
