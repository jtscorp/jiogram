package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.LabeledPrice;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send invoices. On success, the sent Message is returned.
 *
 * @see <a href="https://core.telegram.org/bots/api#sendinvoice">sendInvoice in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SendInvoice implements TelegramMethod<Message> {

    @JsonProperty("chat_id")
    private final ChatId chatId;

    @JsonProperty("message_thread_id")
    private final @Nullable Long messageThreadId;

    @JsonProperty("direct_messages_topic_id")
    private final @Nullable Long directMessagesTopicId;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("description")
    private final String description;

    @JsonProperty("payload")
    private final String payload;

    @JsonProperty("provider_token")
    private final @Nullable String providerToken;

    @JsonProperty("currency")
    private final String currency;

    @JsonProperty("prices")
    private final List<LabeledPrice> prices;

    @JsonProperty("max_tip_amount")
    private final @Nullable Long maxTipAmount;

    @JsonProperty("suggested_tip_amounts")
    private final @Nullable List<Long> suggestedTipAmounts;

    @JsonProperty("start_parameter")
    private final @Nullable String startParameter;

    @JsonProperty("provider_data")
    private final @Nullable String providerData;

    @JsonProperty("photo_url")
    private final @Nullable String photoUrl;

    @JsonProperty("photo_size")
    private final @Nullable Long photoSize;

    @JsonProperty("photo_width")
    private final @Nullable Long photoWidth;

    @JsonProperty("photo_height")
    private final @Nullable Long photoHeight;

    @JsonProperty("need_name")
    private final @Nullable Boolean needName;

    @JsonProperty("need_phone_number")
    private final @Nullable Boolean needPhoneNumber;

    @JsonProperty("need_email")
    private final @Nullable Boolean needEmail;

    @JsonProperty("need_shipping_address")
    private final @Nullable Boolean needShippingAddress;

    @JsonProperty("send_phone_number_to_provider")
    private final @Nullable Boolean sendPhoneNumberToProvider;

    @JsonProperty("send_email_to_provider")
    private final @Nullable Boolean sendEmailToProvider;

    @JsonProperty("is_flexible")
    private final @Nullable Boolean isFlexible;

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
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    /**
     * Creates a new {@code SendInvoice} instance.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the
     *     format &#64;channelusername)
     * @param messageThreadId Unique identifier for the target message thread (topic) of a forum;
     *     for forum supergroups and private chats of bots with forum topic mode enabled only
     * @param directMessagesTopicId Identifier of the direct messages topic to which the message
     *     will be sent; required if the message is sent to a direct messages chat
     * @param title Product name, 1-32 characters
     * @param description Product description, 1-255 characters
     * @param payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the
     *     user, use it for your internal processes.
     * @param providerToken Payment provider token, obtained via &#64;BotFather. Pass an empty
     *     string for payments in Telegram Stars.
     * @param currency Three-letter ISO 4217 currency code, see more on currencies. Pass 'XTR' for
     *     payments in Telegram Stars.
     * @param prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax,
     *     discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for
     *     payments in Telegram Stars.
     * @param maxTipAmount The maximum accepted amount for tips in the smallest units of the
     *     currency (integer, not float/double). For example, for a maximum tip of US$ 1.45 pass
     *     max_tip_amount = 145. See the exp parameter in currencies.json, it shows the number of
     *     digits past the decimal point for each currency (2 for the majority of currencies).
     *     Defaults to 0. Not supported for payments in Telegram Stars.
     * @param suggestedTipAmounts A JSON-serialized array of suggested amounts of tips in the
     *     smallest units of the currency (integer, not float/double). At most 4 suggested tip
     *     amounts can be specified. The suggested tip amounts must be positive, passed in a
     *     strictly increased order and must not exceed max_tip_amount.
     * @param startParameter Unique deep-linking parameter. If left empty, forwarded copies of the
     *     sent message will have a Pay button, allowing multiple users to pay directly from the
     *     forwarded message, using the same invoice. If non-empty, forwarded copies of the sent
     *     message will have a URL button with a deep link to the bot (instead of a Pay button),
     *     with the value used as the start parameter
     * @param providerData JSON-serialized data about the invoice, which will be shared with the
     *     payment provider. A detailed description of required fields should be provided by the
     *     payment provider.
     * @param photoUrl URL of the product photo for the invoice. Can be a photo of the goods or a
     *     marketing image for a service. People like it better when they see what they are paying
     *     for.
     * @param photoSize Photo size in bytes
     * @param photoWidth Photo width
     * @param photoHeight Photo height
     * @param needName Pass True if you require the user's full name to complete the order. Ignored
     *     for payments in Telegram Stars.
     * @param needPhoneNumber Pass True if you require the user's phone number to complete the
     *     order. Ignored for payments in Telegram Stars.
     * @param needEmail Pass True if you require the user's email address to complete the order.
     *     Ignored for payments in Telegram Stars.
     * @param needShippingAddress Pass True if you require the user's shipping address to complete
     *     the order. Ignored for payments in Telegram Stars.
     * @param sendPhoneNumberToProvider Pass True if the user's phone number should be sent to the
     *     provider. Ignored for payments in Telegram Stars.
     * @param sendEmailToProvider Pass True if the user's email address should be sent to the
     *     provider. Ignored for payments in Telegram Stars.
     * @param isFlexible Pass True if the final price depends on the shipping method. Ignored for
     *     payments in Telegram Stars.
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
     * @param replyMarkup A JSON-serialized object for an inline keyboard. If empty, one 'Pay total
     *     price' button will be shown. If not empty, the first button must be a Pay button.
     */
    @JsonCreator
    public SendInvoice(
            @JsonProperty("chat_id") ChatId chatId,
            @JsonProperty("message_thread_id") @Nullable Long messageThreadId,
            @JsonProperty("direct_messages_topic_id") @Nullable Long directMessagesTopicId,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("payload") String payload,
            @JsonProperty("provider_token") @Nullable String providerToken,
            @JsonProperty("currency") String currency,
            @JsonProperty("prices") List<LabeledPrice> prices,
            @JsonProperty("max_tip_amount") @Nullable Long maxTipAmount,
            @JsonProperty("suggested_tip_amounts") @Nullable List<Long> suggestedTipAmounts,
            @JsonProperty("start_parameter") @Nullable String startParameter,
            @JsonProperty("provider_data") @Nullable String providerData,
            @JsonProperty("photo_url") @Nullable String photoUrl,
            @JsonProperty("photo_size") @Nullable Long photoSize,
            @JsonProperty("photo_width") @Nullable Long photoWidth,
            @JsonProperty("photo_height") @Nullable Long photoHeight,
            @JsonProperty("need_name") @Nullable Boolean needName,
            @JsonProperty("need_phone_number") @Nullable Boolean needPhoneNumber,
            @JsonProperty("need_email") @Nullable Boolean needEmail,
            @JsonProperty("need_shipping_address") @Nullable Boolean needShippingAddress,
            @JsonProperty("send_phone_number_to_provider") @Nullable Boolean sendPhoneNumberToProvider,
            @JsonProperty("send_email_to_provider") @Nullable Boolean sendEmailToProvider,
            @JsonProperty("is_flexible") @Nullable Boolean isFlexible,
            @JsonProperty("disable_notification") @Nullable Boolean disableNotification,
            @JsonProperty("protect_content") @Nullable Boolean protectContent,
            @JsonProperty("allow_paid_broadcast") @Nullable Boolean allowPaidBroadcast,
            @JsonProperty("message_effect_id") @Nullable String messageEffectId,
            @JsonProperty("suggested_post_parameters") @Nullable SuggestedPostParameters suggestedPostParameters,
            @JsonProperty("reply_parameters") @Nullable ReplyParameters replyParameters,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup) {
        this.chatId = chatId;
        this.messageThreadId = messageThreadId;
        this.directMessagesTopicId = directMessagesTopicId;
        this.title = title;
        this.description = description;
        this.payload = payload;
        this.providerToken = providerToken;
        this.currency = currency;
        this.prices = prices;
        this.maxTipAmount = maxTipAmount;
        this.suggestedTipAmounts = suggestedTipAmounts;
        this.startParameter = startParameter;
        this.providerData = providerData;
        this.photoUrl = photoUrl;
        this.photoSize = photoSize;
        this.photoWidth = photoWidth;
        this.photoHeight = photoHeight;
        this.needName = needName;
        this.needPhoneNumber = needPhoneNumber;
        this.needEmail = needEmail;
        this.needShippingAddress = needShippingAddress;
        this.sendPhoneNumberToProvider = sendPhoneNumberToProvider;
        this.sendEmailToProvider = sendEmailToProvider;
        this.isFlexible = isFlexible;
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
        return "sendInvoice";
    }

    @Override
    public String apiReturnType() {
        return "Message";
    }

    public static SendInvoice of(ChatId chatId, String title, String description, String payload, String currency, List<LabeledPrice> prices) {
        return new SendInvoice(chatId, null, null, title, description, payload, null, currency, prices, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Sends to the chat of {@code message}, and to its forum topic, business connection or direct
     * messages topic when it came from one.
     */
    public static SendInvoice answer(Message message, String title, String description, String payload, String currency, List<LabeledPrice> prices) {
        return new SendInvoice(ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), title, description, payload, null, currency, prices, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Like {@code answer}, as a reply to {@code message}.
     */
    public static SendInvoice reply(Message message, String title, String description, String payload, String currency, List<LabeledPrice> prices) {
        return new SendInvoice(ReplyTarget.chatId(message), ReplyTarget.messageThreadId(message), ReplyTarget.directMessagesTopicId(message), title, description, payload, null, currency, prices, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ReplyTarget.replyTo(message), null);
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
     * Product name, 1-32 characters
     */
    public String title() {
        return title;
    }

    /**
     * Product description, 1-255 characters
     */
    public String description() {
        return description;
    }

    /**
     * Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use it for
     * your internal processes.
     */
    public String payload() {
        return payload;
    }

    /**
     * Payment provider token, obtained via &#64;BotFather. Pass an empty string for payments in
     * Telegram Stars.
     */
    public @Nullable String providerToken() {
        return providerToken;
    }

    /**
     * Three-letter ISO 4217 currency code, see more on currencies. Pass 'XTR' for payments in
     * Telegram Stars.
     */
    public String currency() {
        return currency;
    }

    /**
     * Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount,
     * delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in
     * Telegram Stars.
     */
    public List<LabeledPrice> prices() {
        return prices;
    }

    /**
     * The maximum accepted amount for tips in the smallest units of the currency (integer, not
     * float/double). For example, for a maximum tip of US$ 1.45 pass max_tip_amount = 145. See the
     * exp parameter in currencies.json, it shows the number of digits past the decimal point for
     * each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments
     * in Telegram Stars.
     */
    public @Nullable Long maxTipAmount() {
        return maxTipAmount;
    }

    /**
     * A JSON-serialized array of suggested amounts of tips in the smallest units of the currency
     * (integer, not float/double). At most 4 suggested tip amounts can be specified. The suggested
     * tip amounts must be positive, passed in a strictly increased order and must not exceed
     * max_tip_amount.
     */
    public @Nullable List<Long> suggestedTipAmounts() {
        return suggestedTipAmounts;
    }

    /**
     * Unique deep-linking parameter. If left empty, forwarded copies of the sent message will have
     * a Pay button, allowing multiple users to pay directly from the forwarded message, using the
     * same invoice. If non-empty, forwarded copies of the sent message will have a URL button with
     * a deep link to the bot (instead of a Pay button), with the value used as the start parameter
     */
    public @Nullable String startParameter() {
        return startParameter;
    }

    /**
     * JSON-serialized data about the invoice, which will be shared with the payment provider. A
     * detailed description of required fields should be provided by the payment provider.
     */
    public @Nullable String providerData() {
        return providerData;
    }

    /**
     * URL of the product photo for the invoice. Can be a photo of the goods or a marketing image
     * for a service. People like it better when they see what they are paying for.
     */
    public @Nullable String photoUrl() {
        return photoUrl;
    }

    /**
     * Photo size in bytes
     */
    public @Nullable Long photoSize() {
        return photoSize;
    }

    /**
     * Photo width
     */
    public @Nullable Long photoWidth() {
        return photoWidth;
    }

    /**
     * Photo height
     */
    public @Nullable Long photoHeight() {
        return photoHeight;
    }

    /**
     * Pass True if you require the user's full name to complete the order. Ignored for payments in
     * Telegram Stars.
     */
    public @Nullable Boolean needName() {
        return needName;
    }

    /**
     * Pass True if you require the user's phone number to complete the order. Ignored for payments
     * in Telegram Stars.
     */
    public @Nullable Boolean needPhoneNumber() {
        return needPhoneNumber;
    }

    /**
     * Pass True if you require the user's email address to complete the order. Ignored for payments
     * in Telegram Stars.
     */
    public @Nullable Boolean needEmail() {
        return needEmail;
    }

    /**
     * Pass True if you require the user's shipping address to complete the order. Ignored for
     * payments in Telegram Stars.
     */
    public @Nullable Boolean needShippingAddress() {
        return needShippingAddress;
    }

    /**
     * Pass True if the user's phone number should be sent to the provider. Ignored for payments in
     * Telegram Stars.
     */
    public @Nullable Boolean sendPhoneNumberToProvider() {
        return sendPhoneNumberToProvider;
    }

    /**
     * Pass True if the user's email address should be sent to the provider. Ignored for payments in
     * Telegram Stars.
     */
    public @Nullable Boolean sendEmailToProvider() {
        return sendEmailToProvider;
    }

    /**
     * Pass True if the final price depends on the shipping method. Ignored for payments in Telegram
     * Stars.
     */
    public @Nullable Boolean isFlexible() {
        return isFlexible;
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
     * A JSON-serialized object for an inline keyboard. If empty, one 'Pay total price' button will
     * be shown. If not empty, the first button must be a Pay button.
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    public SendInvoice withChatId(ChatId chatId) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withMessageThreadId(@Nullable Long messageThreadId) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withDirectMessagesTopicId(@Nullable Long directMessagesTopicId) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withTitle(String title) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withDescription(String description) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withPayload(String payload) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withProviderToken(@Nullable String providerToken) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withCurrency(String currency) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withPrices(List<LabeledPrice> prices) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withMaxTipAmount(@Nullable Long maxTipAmount) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withSuggestedTipAmounts(@Nullable List<Long> suggestedTipAmounts) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withStartParameter(@Nullable String startParameter) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withProviderData(@Nullable String providerData) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withPhotoUrl(@Nullable String photoUrl) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withPhotoSize(@Nullable Long photoSize) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withPhotoWidth(@Nullable Long photoWidth) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withPhotoHeight(@Nullable Long photoHeight) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withNeedName(@Nullable Boolean needName) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withNeedPhoneNumber(@Nullable Boolean needPhoneNumber) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withNeedEmail(@Nullable Boolean needEmail) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withNeedShippingAddress(@Nullable Boolean needShippingAddress) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withSendPhoneNumberToProvider(@Nullable Boolean sendPhoneNumberToProvider) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withSendEmailToProvider(@Nullable Boolean sendEmailToProvider) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withIsFlexible(@Nullable Boolean isFlexible) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withDisableNotification(@Nullable Boolean disableNotification) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withProtectContent(@Nullable Boolean protectContent) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withAllowPaidBroadcast(@Nullable Boolean allowPaidBroadcast) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withMessageEffectId(@Nullable String messageEffectId) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withSuggestedPostParameters(@Nullable SuggestedPostParameters suggestedPostParameters) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withReplyParameters(@Nullable ReplyParameters replyParameters) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    public SendInvoice withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new SendInvoice(chatId, messageThreadId, directMessagesTopicId, title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, startParameter, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible, disableNotification, protectContent, allowPaidBroadcast, messageEffectId, suggestedPostParameters, replyParameters, replyMarkup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SendInvoice)) {
            return false;
        }
        SendInvoice that = (SendInvoice) o;
        return Objects.equals(this.chatId, that.chatId)
                && Objects.equals(this.messageThreadId, that.messageThreadId)
                && Objects.equals(this.directMessagesTopicId, that.directMessagesTopicId)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.payload, that.payload)
                && Objects.equals(this.providerToken, that.providerToken)
                && Objects.equals(this.currency, that.currency)
                && Objects.equals(this.prices, that.prices)
                && Objects.equals(this.maxTipAmount, that.maxTipAmount)
                && Objects.equals(this.suggestedTipAmounts, that.suggestedTipAmounts)
                && Objects.equals(this.startParameter, that.startParameter)
                && Objects.equals(this.providerData, that.providerData)
                && Objects.equals(this.photoUrl, that.photoUrl)
                && Objects.equals(this.photoSize, that.photoSize)
                && Objects.equals(this.photoWidth, that.photoWidth)
                && Objects.equals(this.photoHeight, that.photoHeight)
                && Objects.equals(this.needName, that.needName)
                && Objects.equals(this.needPhoneNumber, that.needPhoneNumber)
                && Objects.equals(this.needEmail, that.needEmail)
                && Objects.equals(this.needShippingAddress, that.needShippingAddress)
                && Objects.equals(this.sendPhoneNumberToProvider, that.sendPhoneNumberToProvider)
                && Objects.equals(this.sendEmailToProvider, that.sendEmailToProvider)
                && Objects.equals(this.isFlexible, that.isFlexible)
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
        return Objects.hash(this.chatId, this.messageThreadId, this.directMessagesTopicId, this.title, this.description, this.payload, this.providerToken, this.currency, this.prices, this.maxTipAmount, this.suggestedTipAmounts, this.startParameter, this.providerData, this.photoUrl, this.photoSize, this.photoWidth, this.photoHeight, this.needName, this.needPhoneNumber, this.needEmail, this.needShippingAddress, this.sendPhoneNumberToProvider, this.sendEmailToProvider, this.isFlexible, this.disableNotification, this.protectContent, this.allowPaidBroadcast, this.messageEffectId, this.suggestedPostParameters, this.replyParameters, this.replyMarkup);
    }

    @Override
    public String toString() {
        return "SendInvoice[chatId=" + this.chatId
                + ", messageThreadId=" + this.messageThreadId
                + ", directMessagesTopicId=" + this.directMessagesTopicId
                + ", title=" + this.title
                + ", description=" + this.description
                + ", payload=" + this.payload
                + ", providerToken=" + this.providerToken
                + ", currency=" + this.currency
                + ", prices=" + this.prices
                + ", maxTipAmount=" + this.maxTipAmount
                + ", suggestedTipAmounts=" + this.suggestedTipAmounts
                + ", startParameter=" + this.startParameter
                + ", providerData=" + this.providerData
                + ", photoUrl=" + this.photoUrl
                + ", photoSize=" + this.photoSize
                + ", photoWidth=" + this.photoWidth
                + ", photoHeight=" + this.photoHeight
                + ", needName=" + this.needName
                + ", needPhoneNumber=" + this.needPhoneNumber
                + ", needEmail=" + this.needEmail
                + ", needShippingAddress=" + this.needShippingAddress
                + ", sendPhoneNumberToProvider=" + this.sendPhoneNumberToProvider
                + ", sendEmailToProvider=" + this.sendEmailToProvider
                + ", isFlexible=" + this.isFlexible
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
