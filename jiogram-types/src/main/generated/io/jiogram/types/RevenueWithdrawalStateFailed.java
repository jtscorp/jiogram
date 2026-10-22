package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.RevenueWithdrawalStateType;
import java.util.Objects;

/**
 * The withdrawal failed and the transaction was refunded.
 *
 * @see <a href="https://core.telegram.org/bots/api#revenuewithdrawalstatefailed">RevenueWithdrawalStateFailed in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class RevenueWithdrawalStateFailed implements RevenueWithdrawalState {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final RevenueWithdrawalStateType type;

    /**
     * Creates a new {@code RevenueWithdrawalStateFailed} instance.
     *
     * @param type Type of the state, always 'failed'
     */
    @JsonCreator
    public RevenueWithdrawalStateFailed(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) RevenueWithdrawalStateType type) {
        this.type = type;
    }

    public static RevenueWithdrawalStateFailed of() {
        return new RevenueWithdrawalStateFailed(RevenueWithdrawalStateType.FAILED);
    }

    /**
     * Type of the state, always 'failed'
     */
    public RevenueWithdrawalStateType type() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RevenueWithdrawalStateFailed)) {
            return false;
        }
        RevenueWithdrawalStateFailed that = (RevenueWithdrawalStateFailed) o;
        return Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @Override
    public String toString() {
        return "RevenueWithdrawalStateFailed[type=" + this.type
                + "]";
    }
}
