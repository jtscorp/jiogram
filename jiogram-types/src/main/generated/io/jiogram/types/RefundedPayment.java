package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains basic information about a refunded payment.
 *
 * @see <a href="https://core.telegram.org/bots/api#refundedpayment">RefundedPayment in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RefundedPayment {

    @JsonProperty("currency")
    private final String currency;

    @JsonProperty("total_amount")
    private final long totalAmount;

    @JsonProperty("invoice_payload")
    private final String invoicePayload;

    @JsonProperty("telegram_payment_charge_id")
    private final String telegramPaymentChargeId;

    @JsonProperty("provider_payment_charge_id")
    private final @Nullable String providerPaymentChargeId;

    /**
     * Creates a new {@code RefundedPayment} instance.
     *
     * @param currency Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars.
     *     Currently, always 'XTR'
     * @param totalAmount Total refunded price in the smallest units of the currency (integer, not
     *     float/double). For example, for a price of US$ 1.45, total_amount = 145. See the exp
     *     parameter in currencies.json, it shows the number of digits past the decimal point for
     *     each currency (2 for the majority of currencies).
     * @param invoicePayload Bot-specified invoice payload
     * @param telegramPaymentChargeId Telegram payment identifier
     * @param providerPaymentChargeId Provider payment identifier
     */
    @JsonCreator
    public RefundedPayment(
            @JsonProperty("currency") String currency,
            @JsonProperty("total_amount") long totalAmount,
            @JsonProperty("invoice_payload") String invoicePayload,
            @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId,
            @JsonProperty("provider_payment_charge_id") @Nullable String providerPaymentChargeId) {
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.invoicePayload = invoicePayload;
        this.telegramPaymentChargeId = telegramPaymentChargeId;
        this.providerPaymentChargeId = providerPaymentChargeId;
    }

    public static RefundedPayment of(String currency, long totalAmount, String invoicePayload, String telegramPaymentChargeId) {
        return new RefundedPayment(currency, totalAmount, invoicePayload, telegramPaymentChargeId, null);
    }

    /**
     * Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars. Currently,
     * always 'XTR'
     */
    public String currency() {
        return currency;
    }

    /**
     * Total refunded price in the smallest units of the currency (integer, not float/double). For
     * example, for a price of US$ 1.45, total_amount = 145. See the exp parameter in
     * currencies.json, it shows the number of digits past the decimal point for each currency (2
     * for the majority of currencies).
     */
    public long totalAmount() {
        return totalAmount;
    }

    /**
     * Bot-specified invoice payload
     */
    public String invoicePayload() {
        return invoicePayload;
    }

    /**
     * Telegram payment identifier
     */
    public String telegramPaymentChargeId() {
        return telegramPaymentChargeId;
    }

    /**
     * Provider payment identifier
     */
    public @Nullable String providerPaymentChargeId() {
        return providerPaymentChargeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RefundedPayment)) {
            return false;
        }
        RefundedPayment that = (RefundedPayment) o;
        return Objects.equals(this.currency, that.currency)
                && this.totalAmount == that.totalAmount
                && Objects.equals(this.invoicePayload, that.invoicePayload)
                && Objects.equals(this.telegramPaymentChargeId, that.telegramPaymentChargeId)
                && Objects.equals(this.providerPaymentChargeId, that.providerPaymentChargeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currency, this.totalAmount, this.invoicePayload, this.telegramPaymentChargeId, this.providerPaymentChargeId);
    }

    @Override
    public String toString() {
        return "RefundedPayment[currency=" + this.currency
                + ", totalAmount=" + this.totalAmount
                + ", invoicePayload=" + this.invoicePayload
                + ", telegramPaymentChargeId=" + this.telegramPaymentChargeId
                + ", providerPaymentChargeId=" + this.providerPaymentChargeId
                + "]";
    }
}
