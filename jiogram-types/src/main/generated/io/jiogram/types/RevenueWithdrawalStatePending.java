package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;
import java.util.Objects;

/**
 * The withdrawal is in progress.
 *
 * @see <a href="https://core.telegram.org/bots/api#revenuewithdrawalstatepending">RevenueWithdrawalStatePending in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RevenueWithdrawalStatePending implements RevenueWithdrawalState {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final RevenueWithdrawalStateType type;

    /**
     * Creates a new {@code RevenueWithdrawalStatePending} instance.
     *
     * @param type Type of the state, always 'pending'
     */
    @JsonCreator
    public RevenueWithdrawalStatePending(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) RevenueWithdrawalStateType type) {
        this.type = type;
    }

    public static RevenueWithdrawalStatePending of() {
        return new RevenueWithdrawalStatePending(RevenueWithdrawalStateType.PENDING);
    }

    /**
     * Type of the state, always 'pending'
     */
    public RevenueWithdrawalStateType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RevenueWithdrawalStatePending)) {
            return false;
        }
        RevenueWithdrawalStatePending that = (RevenueWithdrawalStatePending) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "RevenueWithdrawalStatePending[type=" + this.type
                + "]";
    }
}
