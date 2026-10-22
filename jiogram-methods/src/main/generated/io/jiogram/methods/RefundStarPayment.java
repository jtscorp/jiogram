package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Refunds a successful payment in Telegram Stars. Returns True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#refundstarpayment">refundStarPayment in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RefundStarPayment implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("telegram_payment_charge_id")
    private final String telegramPaymentChargeId;

    /**
     * Creates a new {@code RefundStarPayment} instance.
     *
     * @param userId Identifier of the user whose payment will be refunded
     * @param telegramPaymentChargeId Telegram payment identifier
     */
    @JsonCreator
    public RefundStarPayment(
            @JsonProperty("user_id") long userId,
            @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId) {
        this.userId = userId;
        this.telegramPaymentChargeId = telegramPaymentChargeId;
    }

    @Override
    public String apiMethod() {
        return "refundStarPayment";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Identifier of the user whose payment will be refunded
     */
    public long userId() {
        return userId;
    }

    /**
     * Telegram payment identifier
     */
    public String telegramPaymentChargeId() {
        return telegramPaymentChargeId;
    }

    public RefundStarPayment withUserId(long userId) {
        return new RefundStarPayment(userId, telegramPaymentChargeId);
    }

    public RefundStarPayment withTelegramPaymentChargeId(String telegramPaymentChargeId) {
        return new RefundStarPayment(userId, telegramPaymentChargeId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RefundStarPayment)) {
            return false;
        }
        RefundStarPayment that = (RefundStarPayment) o;
        return this.userId == that.userId
                && Objects.equals(this.telegramPaymentChargeId, that.telegramPaymentChargeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.telegramPaymentChargeId);
    }

    @Override
    public String toString() {
        return "RefundStarPayment[userId=" + this.userId
                + ", telegramPaymentChargeId=" + this.telegramPaymentChargeId
                + "]";
    }
}
