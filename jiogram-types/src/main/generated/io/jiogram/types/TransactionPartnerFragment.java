package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalState;
import io.jiogram.types.TransactionPartnerType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a withdrawal transaction with Fragment.
 *
 * @see <a href="https://core.telegram.org/bots/api#transactionpartnerfragment">TransactionPartnerFragment in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class TransactionPartnerFragment implements TransactionPartner {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final TransactionPartnerType type;

    @JsonProperty("withdrawal_state")
    private final @Nullable RevenueWithdrawalState withdrawalState;

    /**
     * Creates a new {@code TransactionPartnerFragment} instance.
     *
     * @param type Type of the transaction partner, always 'fragment'
     * @param withdrawalState State of the transaction if the transaction is outgoing
     */
    @JsonCreator
    public TransactionPartnerFragment(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) TransactionPartnerType type,
            @JsonProperty("withdrawal_state") @Nullable RevenueWithdrawalState withdrawalState) {
        this.type = type;
        this.withdrawalState = withdrawalState;
    }

    public static TransactionPartnerFragment of() {
        return new TransactionPartnerFragment(TransactionPartnerType.FRAGMENT, null);
    }

    /**
     * Type of the transaction partner, always 'fragment'
     */
    public TransactionPartnerType type() {
        return type;
    }

    /**
     * State of the transaction if the transaction is outgoing
     */
    public @Nullable RevenueWithdrawalState withdrawalState() {
        return withdrawalState;
    }

    public TransactionPartnerFragment withWithdrawalState(@Nullable RevenueWithdrawalState withdrawalState) {
        return new TransactionPartnerFragment(type, withdrawalState);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransactionPartnerFragment)) {
            return false;
        }
        TransactionPartnerFragment that = (TransactionPartnerFragment) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.withdrawalState, that.withdrawalState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.withdrawalState);
    }

    @Override
    public String toString() {
        return "TransactionPartnerFragment[type=" + this.type
                + ", withdrawalState=" + this.withdrawalState
                + "]";
    }
}
