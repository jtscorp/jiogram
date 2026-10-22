package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object contains basic information about a refunded payment.
 *
 * @param currency Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars.
 *     Currently, always 'XTR'
 * @param totalAmount Total refunded price in the smallest units of the currency (integer, not
 *     float/double). For example, for a price of US$ 1.45, total_amount = 145. See the exp
 *     parameter in currencies.json, it shows the number of digits past the decimal point for each
 *     currency (2 for the majority of currencies).
 * @param invoicePayload Bot-specified invoice payload
 * @param telegramPaymentChargeId Telegram payment identifier
 * @param providerPaymentChargeId Provider payment identifier
 * @see <a href="https://core.telegram.org/bots/api#refundedpayment">RefundedPayment in the Bot API</a>
 */
public record RefundedPayment(
    @JsonProperty("currency") String currency,
    @JsonProperty("total_amount") long totalAmount,
    @JsonProperty("invoice_payload") String invoicePayload,
    @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId,
    @JsonProperty("provider_payment_charge_id") @Nullable String providerPaymentChargeId
) {

    public static RefundedPayment of(String currency, long totalAmount, String invoicePayload, String telegramPaymentChargeId) {
        return new RefundedPayment(currency, totalAmount, invoicePayload, telegramPaymentChargeId, null);
    }

    public RefundedPayment withCurrency(String currency) {
        return new RefundedPayment(currency, totalAmount, invoicePayload, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public RefundedPayment withTotalAmount(long totalAmount) {
        return new RefundedPayment(currency, totalAmount, invoicePayload, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public RefundedPayment withInvoicePayload(String invoicePayload) {
        return new RefundedPayment(currency, totalAmount, invoicePayload, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public RefundedPayment withTelegramPaymentChargeId(String telegramPaymentChargeId) {
        return new RefundedPayment(currency, totalAmount, invoicePayload, telegramPaymentChargeId, providerPaymentChargeId);
    }

    public RefundedPayment withProviderPaymentChargeId(@Nullable String providerPaymentChargeId) {
        return new RefundedPayment(currency, totalAmount, invoicePayload, telegramPaymentChargeId, providerPaymentChargeId);
    }
}
