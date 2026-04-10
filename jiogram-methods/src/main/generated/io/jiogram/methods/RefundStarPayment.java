package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class RefundStarPayment implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("telegram_payment_charge_id") private final String telegramPaymentChargeId;

    @JsonCreator
    public RefundStarPayment(
            @JsonProperty("user_id") long userId,
            @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId
    ) {
        this.userId = userId;
        this.telegramPaymentChargeId = telegramPaymentChargeId;
    }

    public long userId() {
        return this.userId;
    }

    public String telegramPaymentChargeId() {
        return this.telegramPaymentChargeId;
    }

    @Override
    public String apiMethod() {
        return "refundStarPayment";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
