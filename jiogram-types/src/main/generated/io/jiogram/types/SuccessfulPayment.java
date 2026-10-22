package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OrderInfo;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains basic information about a successful payment. Note that if the buyer
 * initiates a chargeback with the relevant payment provider following this transaction, the funds
 * may be debited from your balance. This is outside of Telegram's control.
 *
 * @see <a href="https://core.telegram.org/bots/api#successfulpayment">SuccessfulPayment in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SuccessfulPayment {

    @JsonProperty("currency")
    private final String currency;

    @JsonProperty("total_amount")
    private final long totalAmount;

    @JsonProperty("invoice_payload")
    private final String invoicePayload;

    @JsonProperty("subscription_expiration_date")
    private final @Nullable Long subscriptionExpirationDate;

    @JsonProperty("is_recurring")
    private final @Nullable Boolean isRecurring;

    @JsonProperty("is_first_recurring")
    private final @Nullable Boolean isFirstRecurring;

    @JsonProperty("shipping_option_id")
    private final @Nullable String shippingOptionId;

    @JsonProperty("order_info")
    private final @Nullable OrderInfo orderInfo;

    @JsonProperty("telegram_payment_charge_id")
    private final String telegramPaymentChargeId;

    @JsonProperty("provider_payment_charge_id")
    private final String providerPaymentChargeId;

    /**
     * Creates a new {@code SuccessfulPayment} instance.
     *
     * @param currency Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars
     * @param totalAmount Total price in the smallest units of the currency (integer, not
     *     float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp
     *     parameter in currencies.json, it shows the number of digits past the decimal point for
     *     each currency (2 for the majority of currencies).
     * @param invoicePayload Bot-specified invoice payload
     * @param subscriptionExpirationDate Expiration date of the subscription, in Unix time; for
     *     recurring payments only
     * @param isRecurring True, if the payment is a recurring payment for a subscription
     * @param isFirstRecurring True, if the payment is the first payment for a subscription
     * @param shippingOptionId Identifier of the shipping option chosen by the user
     * @param orderInfo Order information provided by the user
     * @param telegramPaymentChargeId Telegram payment identifier
     * @param providerPaymentChargeId Provider payment identifier
     */
    @JsonCreator
    public SuccessfulPayment(
            @JsonProperty("currency") String currency,
            @JsonProperty("total_amount") long totalAmount,
            @JsonProperty("invoice_payload") String invoicePayload,
            @JsonProperty("subscription_expiration_date") @Nullable Long subscriptionExpirationDate,
            @JsonProperty("is_recurring") @Nullable Boolean isRecurring,
            @JsonProperty("is_first_recurring") @Nullable Boolean isFirstRecurring,
            @JsonProperty("shipping_option_id") @Nullable String shippingOptionId,
            @JsonProperty("order_info") @Nullable OrderInfo orderInfo,
            @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId,
            @JsonProperty("provider_payment_charge_id") String providerPaymentChargeId) {
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.invoicePayload = invoicePayload;
        this.subscriptionExpirationDate = subscriptionExpirationDate;
        this.isRecurring = isRecurring;
        this.isFirstRecurring = isFirstRecurring;
        this.shippingOptionId = shippingOptionId;
        this.orderInfo = orderInfo;
        this.telegramPaymentChargeId = telegramPaymentChargeId;
        this.providerPaymentChargeId = providerPaymentChargeId;
    }

    public static SuccessfulPayment of(String currency, long totalAmount, String invoicePayload, String telegramPaymentChargeId, String providerPaymentChargeId) {
        return new SuccessfulPayment(currency, totalAmount, invoicePayload, null, null, null, null, null, telegramPaymentChargeId, providerPaymentChargeId);
    }

    /**
     * Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars
     */
    public String currency() {
        return currency;
    }

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example,
     * for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows
     * the number of digits past the decimal point for each currency (2 for the majority of
     * currencies).
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
     * Expiration date of the subscription, in Unix time; for recurring payments only
     */
    public @Nullable Long subscriptionExpirationDate() {
        return subscriptionExpirationDate;
    }

    /**
     * True, if the payment is a recurring payment for a subscription
     */
    public @Nullable Boolean isRecurring() {
        return isRecurring;
    }

    /**
     * True, if the payment is the first payment for a subscription
     */
    public @Nullable Boolean isFirstRecurring() {
        return isFirstRecurring;
    }

    /**
     * Identifier of the shipping option chosen by the user
     */
    public @Nullable String shippingOptionId() {
        return shippingOptionId;
    }

    /**
     * Order information provided by the user
     */
    public @Nullable OrderInfo orderInfo() {
        return orderInfo;
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
    public String providerPaymentChargeId() {
        return providerPaymentChargeId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuccessfulPayment)) {
            return false;
        }
        SuccessfulPayment that = (SuccessfulPayment) o;
        return Objects.equals(this.currency, that.currency)
                && this.totalAmount == that.totalAmount
                && Objects.equals(this.invoicePayload, that.invoicePayload)
                && Objects.equals(this.subscriptionExpirationDate, that.subscriptionExpirationDate)
                && Objects.equals(this.isRecurring, that.isRecurring)
                && Objects.equals(this.isFirstRecurring, that.isFirstRecurring)
                && Objects.equals(this.shippingOptionId, that.shippingOptionId)
                && Objects.equals(this.orderInfo, that.orderInfo)
                && Objects.equals(this.telegramPaymentChargeId, that.telegramPaymentChargeId)
                && Objects.equals(this.providerPaymentChargeId, that.providerPaymentChargeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currency, this.totalAmount, this.invoicePayload, this.subscriptionExpirationDate, this.isRecurring, this.isFirstRecurring, this.shippingOptionId, this.orderInfo, this.telegramPaymentChargeId, this.providerPaymentChargeId);
    }

    @Override
    public String toString() {
        return "SuccessfulPayment[currency=" + this.currency
                + ", totalAmount=" + this.totalAmount
                + ", invoicePayload=" + this.invoicePayload
                + ", subscriptionExpirationDate=" + this.subscriptionExpirationDate
                + ", isRecurring=" + this.isRecurring
                + ", isFirstRecurring=" + this.isFirstRecurring
                + ", shippingOptionId=" + this.shippingOptionId
                + ", orderInfo=" + this.orderInfo
                + ", telegramPaymentChargeId=" + this.telegramPaymentChargeId
                + ", providerPaymentChargeId=" + this.providerPaymentChargeId
                + "]";
    }
}
