package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Refunds a successful payment in Telegram Stars. Returns True on success.
 *
 * @param userId Identifier of the user whose payment will be refunded
 * @param telegramPaymentChargeId Telegram payment identifier
 * @see <a href="https://core.telegram.org/bots/api#refundstarpayment">refundStarPayment in the Bot API</a>
 */
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

    public RefundStarPayment withUserId(long userId) {
        return new RefundStarPayment(userId, telegramPaymentChargeId);
    }

    public RefundStarPayment withTelegramPaymentChargeId(String telegramPaymentChargeId) {
        return new RefundStarPayment(userId, telegramPaymentChargeId);
    }
}
