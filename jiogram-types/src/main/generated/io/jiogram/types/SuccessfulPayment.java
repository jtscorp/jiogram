package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OrderInfo;
import org.jspecify.annotations.Nullable;

public class SuccessfulPayment {
    @JsonProperty("currency") private final String currency;
    @JsonProperty("total_amount") private final long totalAmount;
    @JsonProperty("invoice_payload") private final String invoicePayload;
    @JsonProperty("subscription_expiration_date") @Nullable private final Long subscriptionExpirationDate;
    @JsonProperty("is_recurring") @Nullable private final Boolean isRecurring;
    @JsonProperty("is_first_recurring") @Nullable private final Boolean isFirstRecurring;
    @JsonProperty("shipping_option_id") @Nullable private final String shippingOptionId;
    @JsonProperty("order_info") @Nullable private final OrderInfo orderInfo;
    @JsonProperty("telegram_payment_charge_id") private final String telegramPaymentChargeId;
    @JsonProperty("provider_payment_charge_id") private final String providerPaymentChargeId;

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
            @JsonProperty("provider_payment_charge_id") String providerPaymentChargeId
    ) {
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

    public String currency() {
        return this.currency;
    }

    public long totalAmount() {
        return this.totalAmount;
    }

    public String invoicePayload() {
        return this.invoicePayload;
    }

    public Long subscriptionExpirationDate() {
        return this.subscriptionExpirationDate;
    }

    public Boolean isRecurring() {
        return this.isRecurring;
    }

    public Boolean isFirstRecurring() {
        return this.isFirstRecurring;
    }

    public String shippingOptionId() {
        return this.shippingOptionId;
    }

    public OrderInfo orderInfo() {
        return this.orderInfo;
    }

    public String telegramPaymentChargeId() {
        return this.telegramPaymentChargeId;
    }

    public String providerPaymentChargeId() {
        return this.providerPaymentChargeId;
    }
}
