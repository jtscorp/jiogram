package io.jiogram.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.TelegramMethod;

/**
 * Allows the bot to cancel or re-enable extension of a subscription paid in Telegram Stars. Returns
 * True on success.
 *
 * @param userId Identifier of the user whose subscription will be edited
 * @param telegramPaymentChargeId Telegram payment identifier for the subscription
 * @param isCanceled Pass True to cancel extension of the user subscription; the subscription must
 *     be active up to the end of the current subscription period. Pass False to allow the user to
 *     re-enable a subscription that was previously canceled by the bot.
 * @see <a href="https://core.telegram.org/bots/api#edituserstarsubscription">editUserStarSubscription in the Bot API</a>
 */
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
