package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OrderInfo;
import org.jspecify.annotations.Nullable;

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
) {}
