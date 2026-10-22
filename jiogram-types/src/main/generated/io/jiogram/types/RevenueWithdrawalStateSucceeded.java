package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;

/**
 * The withdrawal succeeded.
 *
 * @param type Type of the state, always 'succeeded'
 * @param date Date the withdrawal was completed in Unix time
 * @param url An HTTPS URL that can be used to see transaction details
 * @see <a href="https://core.telegram.org/bots/api#revenuewithdrawalstatesucceeded">RevenueWithdrawalStateSucceeded in the Bot API</a>
 */
public record RevenueWithdrawalStateSucceeded(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) RevenueWithdrawalStateType type,
    @JsonProperty("date") long date,
    @JsonProperty("url") String url
) implements RevenueWithdrawalState {

    public RevenueWithdrawalStateSucceeded withDate(long date) {
        return new RevenueWithdrawalStateSucceeded(type, date, url);
    }

    public RevenueWithdrawalStateSucceeded withUrl(String url) {
        return new RevenueWithdrawalStateSucceeded(type, date, url);
    }
}
