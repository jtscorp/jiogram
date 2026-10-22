package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LabeledPrice;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Represents the content of an invoice message to be sent as the result of an inline query.
 *
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
 * @param suggestedTipAmounts A JSON-serialized array of suggested amounts of tip in the smallest
 *     units of the currency (integer, not float/double). At most 4 suggested tip amounts can be
 *     specified. The suggested tip amounts must be positive, passed in a strictly increased order
 *     and must not exceed max_tip_amount.
 * @param providerData A JSON-serialized object for data about the invoice, which will be shared
 *     with the payment provider. A detailed description of the required fields should be provided
 *     by the payment provider.
 * @param photoUrl URL of the product photo for the invoice. Can be a photo of the goods or a
 *     marketing image for a service.
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
 * @see <a href="https://core.telegram.org/bots/api#inputinvoicemessagecontent">InputInvoiceMessageContent in the Bot API</a>
 */
public record InputInvoiceMessageContent(
    @JsonProperty("title") String title,
    @JsonProperty("description") String description,
    @JsonProperty("payload") String payload,
    @JsonProperty("provider_token") @Nullable String providerToken,
    @JsonProperty("currency") String currency,
    @JsonProperty("prices") List<LabeledPrice> prices,
    @JsonProperty("max_tip_amount") @Nullable Long maxTipAmount,
    @JsonProperty("suggested_tip_amounts") @Nullable List<Long> suggestedTipAmounts,
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
    @JsonProperty("is_flexible") @Nullable Boolean isFlexible
) implements InputMessageContent {

    public static InputInvoiceMessageContent of(String title, String description, String payload, String currency, List<LabeledPrice> prices) {
        return new InputInvoiceMessageContent(title, description, payload, null, currency, prices, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public InputInvoiceMessageContent withTitle(String title) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withDescription(String description) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withPayload(String payload) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withProviderToken(@Nullable String providerToken) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withCurrency(String currency) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withPrices(List<LabeledPrice> prices) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withMaxTipAmount(@Nullable Long maxTipAmount) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withSuggestedTipAmounts(@Nullable List<Long> suggestedTipAmounts) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withProviderData(@Nullable String providerData) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withPhotoUrl(@Nullable String photoUrl) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withPhotoSize(@Nullable Long photoSize) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withPhotoWidth(@Nullable Long photoWidth) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withPhotoHeight(@Nullable Long photoHeight) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withNeedName(@Nullable Boolean needName) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withNeedPhoneNumber(@Nullable Boolean needPhoneNumber) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withNeedEmail(@Nullable Boolean needEmail) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withNeedShippingAddress(@Nullable Boolean needShippingAddress) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withSendPhoneNumberToProvider(@Nullable Boolean sendPhoneNumberToProvider) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withSendEmailToProvider(@Nullable Boolean sendEmailToProvider) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }

    public InputInvoiceMessageContent withIsFlexible(@Nullable Boolean isFlexible) {
        return new InputInvoiceMessageContent(title, description, payload, providerToken, currency, prices, maxTipAmount, suggestedTipAmounts, providerData, photoUrl, photoSize, photoWidth, photoHeight, needName, needPhoneNumber, needEmail, needShippingAddress, sendPhoneNumberToProvider, sendEmailToProvider, isFlexible);
    }
}
