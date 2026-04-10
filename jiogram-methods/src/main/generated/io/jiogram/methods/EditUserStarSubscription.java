package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

public class EditUserStarSubscription implements TelegramMethod<Boolean> {
    @JsonProperty("user_id") private final long userId;
    @JsonProperty("telegram_payment_charge_id") private final String telegramPaymentChargeId;
    @JsonProperty("is_canceled") private final boolean isCanceled;

    @JsonCreator
    public EditUserStarSubscription(
            @JsonProperty("user_id") long userId,
            @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId,
            @JsonProperty("is_canceled") boolean isCanceled
    ) {
        this.userId = userId;
        this.telegramPaymentChargeId = telegramPaymentChargeId;
        this.isCanceled = isCanceled;
    }

    public long userId() {
        return this.userId;
    }

    public String telegramPaymentChargeId() {
        return this.telegramPaymentChargeId;
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    @Override
    public String apiMethod() {
        return "editUserStarSubscription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }
}
