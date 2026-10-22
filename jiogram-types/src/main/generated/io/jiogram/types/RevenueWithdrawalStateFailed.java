package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;

/**
 * The withdrawal failed and the transaction was refunded.
 *
 * @param type Type of the state, always 'failed'
 * @see <a href="https://core.telegram.org/bots/api#revenuewithdrawalstatefailed">RevenueWithdrawalStateFailed in the Bot API</a>
 */
public record RevenueWithdrawalStateFailed(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) RevenueWithdrawalStateType type
) implements RevenueWithdrawalState {

    public static RevenueWithdrawalStateFailed of() {
        return new RevenueWithdrawalStateFailed(RevenueWithdrawalStateType.FAILED);
    }
}
