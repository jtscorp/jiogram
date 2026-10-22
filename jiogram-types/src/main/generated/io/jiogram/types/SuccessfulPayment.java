package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OrderInfo;
import org.jspecify.annotations.Nullable;

/**
 * This object contains basic information about a successful payment. Note that if the buyer
 * initiates a chargeback with the relevant payment provider following this transaction, the funds
 * may be debited from your balance. This is outside of Telegram's control.
 *
 * @param currency Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars
 * @param totalAmount Total price in the smallest units of the currency (integer, not float/double).
 *     For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in
 *     currencies.json, it shows the number of digits past the decimal point for each currency (2
 *     for the majority of currencies).
 * @param invoicePayload Bot-specified invoice payload
 * @param subscriptionExpirationDate Expiration date of the subscription, in Unix time; for
 *     recurring payments only
 * @param isRecurring True, if the payment is a recurring payment for a subscription
 * @param isFirstRecurring True, if the payment is the first payment for a subscription
 * @param shippingOptionId Identifier of the shipping option chosen by the user
 * @param orderInfo Order information provided by the user
 * @param telegramPaymentChargeId Telegram payment identifier
 * @param providerPaymentChargeId Provider payment identifier
 * @see <a href="https://core.telegram.org/bots/api#successfulpayment">SuccessfulPayment in the Bot API</a>
 */
public record SuccessfulPayment(
    @JsonProperty("currency") String currency,
    @JsonProperty("total_amount") long totalAmount,
    @JsonProperty("invoice_payload") String invoicePayload,
    @JsonProperty("subscription_expiration_date") @Nullable Long subscriptionExpirationDate,
    @JsonProperty("is_recurring") @Nullable Boolean isRecurring,
    @JsonProperty("is_first_recurring") @Nullable Boolean isFirstRecurring,
    @JsonProperty("shipping_option_id") @Nullable String shippingOptionId,
    @JsonProperty("order_info") @Nullable OrderInfo orderInfo,
    @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId,
    @JsonProperty("provider_payment_charge_id") String providerPaymentChargeId
) {

    public SuccessfulPayment withCurrency(String currency) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public SuccessfulPayment withTotalAmount(long totalAmount) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public SuccessfulPayment withInvoicePayload(String invoicePayload) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public SuccessfulPayment withSubscriptionExpirationDate(@Nullable Long subscriptionExpirationDate) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public SuccessfulPayment withIsRecurring(@Nullable Boolean isRecurring) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public SuccessfulPayment withIsFirstRecurring(@Nullable Boolean isFirstRecurring) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public SuccessfulPayment withShippingOptionId(@Nullable String shippingOptionId) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public SuccessfulPayment withOrderInfo(@Nullable OrderInfo orderInfo) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public SuccessfulPayment withTelegramPaymentChargeId(String telegramPaymentChargeId) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public SuccessfulPayment withProviderPaymentChargeId(String providerPaymentChargeId) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, subscriptionExpirationDate, isRecurring, isFirstRecurring, shippingOptionId, orderInfo, telegramPaymentChargeId, providerPaymentChargeId);
    }
}
