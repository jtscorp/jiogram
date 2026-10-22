package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to edit live location messages. A location can be edited until its live_period
 * expires or editing is explicitly disabled by a call to stopMessageLiveLocation. On success, if
 * the edited message is not an inline message, the edited Message is returned, otherwise True is
 * returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#editmessagelivelocation">editMessageLiveLocation in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditMessageLiveLocation implements TelegramMethod<Message> {

    @JsonProperty("business_connection_id")
    private final @Nullable String businessConnectionId;

    @JsonProperty("chat_id")
    private final @Nullable ChatId chatId;

    @JsonProperty("message_id")
    private final @Nullable Long messageId;

    @JsonProperty("inline_message_id")
    private final @Nullable String inlineMessageId;

    @JsonProperty("latitude")
    private final double latitude;

    @JsonProperty("longitude")
    private final double longitude;

    @JsonProperty("live_period")
    private final @Nullable Long livePeriod;

    @JsonProperty("horizontal_accuracy")
    private final @Nullable Double horizontalAccuracy;

    @JsonProperty("heading")
    private final @Nullable Long heading;

    @JsonProperty("proximity_alert_radius")
    private final @Nullable Long proximityAlertRadius;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code EditMessageLiveLocation} instance.
     *
     * @param businessConnectionId Unique identifier of the business connection on behalf of which
     *     the message to be edited was sent
     * @param chatId Required if inline_message_id is not specified. Unique identifier for the
     *     target chat or username of the target channel (in the format &#64;channelusername)
     * @param messageId Required if inline_message_id is not specified. Identifier of the message to
     *     edit
     * @param inlineMessageId Required if chat_id and message_id are not specified. Identifier of
     *     the inline message
     * @param latitude Latitude of new location
     * @param longitude Longitude of new location
     * @param livePeriod New period in seconds during which the location can be updated, starting
     *     from the message send date. If 0x7FFFFFFF is specified, then the location can be updated
     *     forever. Otherwise, the new value must not exceed the current live_period by more than a
     *     day, and the live location expiration date must remain within the next 90 days. If not
     *     specified, then live_period remains unchanged
     * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters;
     *     0-1500
     * @param heading Direction in which the user is moving, in degrees. Must be between 1 and 360
     *     if specified.
     * @param proximityAlertRadius The maximum distance for proximity alerts about approaching
     *     another chat member, in meters. Must be between 1 and 100000 if specified.
     * @param replyMarkup A JSON-serialized object for a new inline keyboard.
     */
    @JsonCreator
    public EditMessageLiveLocation(
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
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.businessConnectionId = businessConnectionId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.inlineMessageId = inlineMessageId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.livePeriod = livePeriod;
        this.horizontalAccuracy = horizontalAccuracy;
        this.heading = heading;
        this.proximityAlertRadius = proximityAlertRadius;
        this.replyMarkup = replyMarkup;
    }

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

    /**
     * Unique identifier of the business connection on behalf of which the message to be edited was
     * sent
     */
    public @Nullable String businessConnectionId() {
        return businessConnectionId;
    }

    /**
     * Required if inline_message_id is not specified. Unique identifier for the target chat or
     * username of the target channel (in the format &#64;channelusername)
     */
    public @Nullable ChatId chatId() {
        return chatId;
    }

    /**
     * Required if inline_message_id is not specified. Identifier of the message to edit
     */
    public @Nullable Long messageId() {
        return messageId;
    }

    /**
     * Required if chat_id and message_id are not specified. Identifier of the inline message
     */
    public @Nullable String inlineMessageId() {
        return inlineMessageId;
    }

    /**
     * Latitude of new location
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Longitude of new location
     */
    public double longitude() {
        return longitude;
    }

    /**
     * New period in seconds during which the location can be updated, starting from the message
     * send date. If 0x7FFFFFFF is specified, then the location can be updated forever. Otherwise,
     * the new value must not exceed the current live_period by more than a day, and the live
     * location expiration date must remain within the next 90 days. If not specified, then
     * live_period remains unchanged
     */
    public @Nullable Long livePeriod() {
        return livePeriod;
    }

    /**
     * The radius of uncertainty for the location, measured in meters; 0-1500
     */
    public @Nullable Double horizontalAccuracy() {
        return horizontalAccuracy;
    }

    /**
     * Direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
     */
    public @Nullable Long heading() {
        return heading;
    }

    /**
     * The maximum distance for proximity alerts about approaching another chat member, in meters.
     * Must be between 1 and 100000 if specified.
     */
    public @Nullable Long proximityAlertRadius() {
        return proximityAlertRadius;
    }

    /**
     * A JSON-serialized object for a new inline keyboard.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    public EditMessageLiveLocation withBusinessConnectionId(@Nullable String businessConnectionId) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withChatId(@Nullable ChatId chatId) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withMessageId(@Nullable Long messageId) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withInlineMessageId(@Nullable String inlineMessageId) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withLatitude(double latitude) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withLongitude(double longitude) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withLivePeriod(@Nullable Long livePeriod) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withHorizontalAccuracy(@Nullable Double horizontalAccuracy) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withHeading(@Nullable Long heading) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withProximityAlertRadius(@Nullable Long proximityAlertRadius) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    public EditMessageLiveLocation withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new EditMessageLiveLocation(businessConnectionId, chatId, messageId, inlineMessageId, latitude, longitude, livePeriod, horizontalAccuracy, heading, proximityAlertRadius, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditMessageLiveLocation)) {
            return false;
        }
        EditMessageLiveLocation that = (EditMessageLiveLocation) o;
        return Objects.equals(this.businessConnectionId, that.businessConnectionId)
                && Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageId, that.messageId)
                && Objects.equals(this.inlineMessageId, that.inlineMessageId)
                && Double.compare(this.latitude, that.latitude) == 0
                && Double.compare(this.longitude, that.longitude) == 0
                && Objects.equals(this.livePeriod, that.livePeriod)
                && Objects.equals(this.horizontalAccuracy, that.horizontalAccuracy)
                && Objects.equals(this.heading, that.heading)
                && Objects.equals(this.proximityAlertRadius, that.proximityAlertRadius)
                && Objects.equals(this.replyMarkup, that.replyMarkup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.businessConnectionId, this.chatId, this.messageId, this.inlineMessageId, this.latitude, this.longitude, this.livePeriod, this.horizontalAccuracy, this.heading, this.proximityAlertRadius, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "EditMessageLiveLocation[businessConnectionId=" + this.businessConnectionId
                + ", chatId=" + this.chatId
                + ", messageId=" + this.messageId
                + ", inlineMessageId=" + this.inlineMessageId
                + ", latitude=" + this.latitude
                + ", longitude=" + this.longitude
                + ", livePeriod=" + this.livePeriod
                + ", horizontalAccuracy=" + this.horizontalAccuracy
                + ", heading=" + this.heading
                + ", proximityAlertRadius=" + this.proximityAlertRadius
                + ", replyMarkup=" + this.replyMarkup
                + "]";
    }
}
