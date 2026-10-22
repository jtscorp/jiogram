package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;
import java.util.Objects;

/**
 * Allows the bot to cancel or re-enable extension of a subscription paid in Telegram Stars. Returns
 * True on success.
 *
 * @see <a href="https://core.telegram.org/bots/api#edituserstarsubscription">editUserStarSubscription in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class EditUserStarSubscription implements TelegramMethod<Boolean> {

    @JsonProperty("user_id")
    private final long userId;

    @JsonProperty("telegram_payment_charge_id")
    private final String telegramPaymentChargeId;

    @JsonProperty("is_canceled")
    private final boolean isCanceled;

    /**
     * Creates a new {@code EditUserStarSubscription} instance.
     *
     * @param userId Identifier of the user whose subscription will be edited
     * @param telegramPaymentChargeId Telegram payment identifier for the subscription
     * @param isCanceled Pass True to cancel extension of the user subscription; the subscription
     *     must be active up to the end of the current subscription period. Pass False to allow the
     *     user to re-enable a subscription that was previously canceled by the bot.
     */
    @JsonCreator
    public EditUserStarSubscription(
            @JsonProperty("user_id") long userId,
            @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId,
            @JsonProperty("is_canceled") boolean isCanceled) {
        this.userId = userId;
        this.telegramPaymentChargeId = telegramPaymentChargeId;
        this.isCanceled = isCanceled;
    }

    @Override
    public String apiMethod() {
        return "editUserStarSubscription";
    }

    @Override
    public String apiReturnType() {
        return "Boolean";
    }

    /**
     * Identifier of the user whose subscription will be edited
     */
    public long userId() {
        return userId;
    }

    /**
     * Telegram payment identifier for the subscription
     */
    public String telegramPaymentChargeId() {
        return telegramPaymentChargeId;
    }

    /**
     * Pass True to cancel extension of the user subscription; the subscription must be active up to
     * the end of the current subscription period. Pass False to allow the user to re-enable a
     * subscription that was previously canceled by the bot.
     */
    public boolean isCanceled() {
        return isCanceled;
    }

    public EditUserStarSubscription withUserId(long userId) {
        return new EditUserStarSubscription(userId, telegramPaymentChargeId, isCanceled);
    }

    public EditUserStarSubscription withTelegramPaymentChargeId(String telegramPaymentChargeId) {
        return new EditUserStarSubscription(userId, telegramPaymentChargeId, isCanceled);
    }

    public EditUserStarSubscription withIsCanceled(boolean isCanceled) {
        return new EditUserStarSubscription(userId, telegramPaymentChargeId, isCanceled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EditUserStarSubscription)) {
            return false;
        }
        EditUserStarSubscription that = (EditUserStarSubscription) o;
        return this.userId == that.userId
                && Objects.equals(this.telegramPaymentChargeId, that.telegramPaymentChargeId)
                && this.isCanceled == that.isCanceled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.telegramPaymentChargeId, this.isCanceled);
    }

    @Override
    public String toString() {
        return "EditUserStarSubscription[userId=" + this.userId
                + ", telegramPaymentChargeId=" + this.telegramPaymentChargeId
                + ", isCanceled=" + this.isCanceled
                + "]";
    }
}
