package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalState;
import io.jiogram.types.TransactionPartnerType;
import org.jspecify.annotations.Nullable;

/**
 * Describes a withdrawal transaction with Fragment.
 *
 * @param type Type of the transaction partner, always 'fragment'
 * @param withdrawalState State of the transaction if the transaction is outgoing
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnerfragment">TransactionPartnerFragment in the Bot API</a>
 */
public record TransactionPartnerFragment(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
    @JsonProperty("withdrawal_state") @Nullable RevenueWithdrawalState withdrawalState
) implements TransactionPartner {

    public TransactionPartnerFragment withWithdrawalState(@Nullable RevenueWithdrawalState withdrawalState) {
        return new TransactionPartnerFragment(type, withdrawalState);
    }
}
