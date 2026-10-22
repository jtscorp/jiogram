package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.LabeledPrice;
import io.jiogram.types.Message;
import io.jiogram.types.ReplyParameters;
import io.jiogram.types.SuggestedPostParameters;
import io.jiogram.types.TelegramMethod;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Use this method to send invoices. On success, the sent Message is returned.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel (in the
 *     format &#64;channelusername)
 * @param messageThreadId Unique identifier for the target message thread (topic) of a forum; for
 *     forum supergroups and private chats of bots with forum topic mode enabled only
 * @param directMessagesTopicId Identifier of the direct messages topic to which the message will be
 *     sent; required if the message is sent to a direct messages chat
 * @param title Product name, 1-32 characters
 * @param description Product description, 1-255 characters
 * @param payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user,
 *     use it for your internal processes.
 * @param providerToken Payment provider token, obtained via &#64;BotFather. Pass an empty string
 *     for payments in Telegram Stars.
 * @param currency Three-letter ISO 4217 currency code, see more on currencies. Pass 'XTR' for
 *     payments in Telegram Stars.
 * @param prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax,
 *     discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for
 *     payments in Telegram Stars.
 * @param maxTipAmount The maximum accepted amount for tips in the smallest units of the currency
 *     (integer, not float/double). For example, for a maximum tip of US$ 1.45 pass max_tip_amount =
 *     145. See the exp parameter in currencies.json, it shows the number of digits past the decimal
 *     point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for
 *     payments in Telegram Stars.
 * @param suggestedTipAmounts A JSON-serialized array of suggested amounts of tips in the smallest
 *     units of the currency (integer, not float/double). At most 4 suggested tip amounts can be
 *     specified. The suggested tip amounts must be positive, passed in a strictly increased order
 *     and must not exceed max_tip_amount.
 * @param startParameter Unique deep-linking parameter. If left empty, forwarded copies of the sent
 *     message will have a Pay button, allowing multiple users to pay directly from the forwarded
 *     message, using the same invoice. If non-empty, forwarded copies of the sent message will have
 *     a URL button with a deep link to the bot (instead of a Pay button), with the value used as
 *     the start parameter
 * @param providerData JSON-serialized data about the invoice, which will be shared with the payment
 *     provider. A detailed description of required fields should be provided by the payment
 *     provider.
 * @param photoUrl URL of the product photo for the invoice. Can be a photo of the goods or a
 *     marketing image for a service. People like it better when they see what they are paying for.
 * @param photoSize Photo size in bytes
 * @param photoWidth Photo width
 * @param photoHeight Photo height
 * @param needName Pass True if you require the user's full name to complete the order. Ignored for
 *     payments in Telegram Stars.
 * @param needPhoneNumber Pass True if you require the user's phone number to complete the order.
 *     Ignored for payments in Telegram Stars.
 * @param needEmail Pass True if you require the user's email address to complete the order. Ignored
 *     for payments in Telegram Stars.
 * @param needShippingAddress Pass True if you require the user's shipping address to complete the
 *     order. Ignored for payments in Telegram Stars.
 * @param sendPhoneNumberToProvider Pass True if the user's phone number should be sent to the
 *     provider. Ignored for payments in Telegram Stars.
 * @param sendEmailToProvider Pass True if the user's email address should be sent to the provider.
 *     Ignored for payments in Telegram Stars.
 * @param isFlexible Pass True if the final price depends on the shipping method. Ignored for
 *     payments in Telegram Stars.
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
 * @param replyMarkup A JSON-serialized object for an inline keyboard. If empty, one 'Pay total
 *     price' button will be shown. If not empty, the first button must be a Pay button.
 * @see <a href="https://core.telegram.org/bots/api#sendinvoice">sendInvoice in the Bot API</a>
 */
public record SendInvoice(
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
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup
) implements TelegramMethod<Message> {

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
}
