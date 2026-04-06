package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record RefundStarPayment(
    @JsonProperty("user_id") long userId,
    @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "refundStarPayment";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
