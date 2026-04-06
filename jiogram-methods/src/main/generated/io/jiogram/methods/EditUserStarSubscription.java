package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public record EditUserStarSubscription(
    @JsonProperty("user_id") long userId,
    @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId,
    @JsonProperty("is_canceled") boolean isCanceled
) implements TelegramMethod<Boolean> {

    @Override
    public String apiMethod() {
        return "editUserStarSubscription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
