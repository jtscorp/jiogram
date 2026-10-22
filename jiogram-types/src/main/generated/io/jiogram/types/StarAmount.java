package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes an amount of Telegram Stars.
 *
 * @see <a href="https://core.telegram.org/bots/api#staramount">StarAmount in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class StarAmount {

    @JsonProperty("amount")
    private final long amount;

    @JsonProperty("nanostar_amount")
    private final @Nullable Long nanostarAmount;

    /**
     * Creates a new {@code StarAmount} instance.
     *
     * @param amount Integer amount of Telegram Stars, rounded to 0; can be negative
     * @param nanostarAmount The number of 1/1000000000 shares of Telegram Stars; from -999999999 to
     *     999999999; can be negative if and only if amount is non-positive
     */
    @JsonCreator
    public StarAmount(
            @JsonProperty("amount") long amount,
            @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount) {
        this.amount = amount;
        this.nanostarAmount = nanostarAmount;
    }

    public static StarAmount of(long amount) {
        return new StarAmount(amount, null);
    }

    /**
     * Integer amount of Telegram Stars, rounded to 0; can be negative
     */
    public long amount() {
        return amount;
    }

    /**
     * The number of 1/1000000000 shares of Telegram Stars; from -999999999 to 999999999; can be
     * negative if and only if amount is non-positive
     */
    public @Nullable Long nanostarAmount() {
        return nanostarAmount;
    }

    public StarAmount withAmount(long amount) {
        return new StarAmount(amount, nanostarAmount);
    }

    public StarAmount withNanostarAmount(@Nullable Long nanostarAmount) {
        return new StarAmount(amount, nanostarAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StarAmount)) {
            return false;
        }
        StarAmount that = (StarAmount) o;
        return this.amount == that.amount
                && Objects.equals(this.nanostarAmount, that.nanostarAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.amount, this.nanostarAmount);
    }

    @Override
    public String toString() {
        return "StarAmount[amount=" + this.amount
                + ", nanostarAmount=" + this.nanostarAmount
                + "]";
    }
}
