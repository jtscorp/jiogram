package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class RefundedPayment {
    @JsonProperty("currency") private final String currency;
    @JsonProperty("total_amount") private final long totalAmount;
    @JsonProperty("invoice_payload") private final String invoicePayload;
    @JsonProperty("telegram_payment_charge_id") private final String telegramPaymentChargeId;
    @JsonProperty("provider_payment_charge_id") @Nullable private final String providerPaymentChargeId;

    @JsonCreator
    public RefundedPayment(
            @JsonProperty("currency") String currency,
            @JsonProperty("total_amount") long totalAmount,
            @JsonProperty("invoice_payload") String invoicePayload,
            @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId,
            @JsonProperty("provider_payment_charge_id") @Nullable String providerPaymentChargeId
    ) {
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.invoicePayload = invoicePayload;
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

    public String telegramPaymentChargeId() {
        return this.telegramPaymentChargeId;
    }

    public String providerPaymentChargeId() {
        return this.providerPaymentChargeId;
    }
}
