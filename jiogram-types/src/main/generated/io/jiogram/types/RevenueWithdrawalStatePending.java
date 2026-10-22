package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;

/**
 * The withdrawal is in progress.
 *
 * @param type Type of the state, always 'pending'
 * @see <a href="https://core.telegram.org/bots/api#revenuewithdrawalstatepending">RevenueWithdrawalStatePending in the Bot API</a>
 */
public record RevenueWithdrawalStatePending(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) RevenueWithdrawalStateType type
) implements RevenueWithdrawalState {

    public static RevenueWithdrawalStatePending of() {
        return new RevenueWithdrawalStatePending(RevenueWithdrawalStateType.PENDING);
    }
}
