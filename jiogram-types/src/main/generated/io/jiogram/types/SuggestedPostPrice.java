package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Describes the price of a suggested post.
 *
 * @see <a href="https://core.telegram.org/bots/api#suggestedpostprice">SuggestedPostPrice in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class SuggestedPostPrice {

    @JsonProperty("currency")
    private final String currency;

    @JsonProperty("amount")
    private final long amount;

    /**
     * Creates a new {@code SuggestedPostPrice} instance.
     *
     * @param currency Currency in which the post will be paid. Currently, must be one of 'XTR' for
     *     Telegram Stars or 'TON' for toncoins
     * @param amount The amount of the currency that will be paid for the post in the smallest units
     *     of the currency, i.e. Telegram Stars or nanotoncoins. Currently, price in Telegram Stars
     *     must be between 5 and 100000, and price in nanotoncoins must be between 10000000 and
     *     10000000000000.
     */
    @JsonCreator
    public SuggestedPostPrice(
            @JsonProperty("currency") String currency,
            @JsonProperty("amount") long amount) {
        this.currency = currency;
        this.amount = amount;
    }

    /**
     * Currency in which the post will be paid. Currently, must be one of 'XTR' for Telegram Stars
     * or 'TON' for toncoins
     */
    public String currency() {
        return currency;
    }

    /**
     * The amount of the currency that will be paid for the post in the smallest units of the
     * currency, i.e. Telegram Stars or nanotoncoins. Currently, price in Telegram Stars must be
     * between 5 and 100000, and price in nanotoncoins must be between 10000000 and 10000000000000.
     */
    public long amount() {
        return amount;
    }

    public SuggestedPostPrice withCurrency(String currency) {
        return new SuggestedPostPrice(currency, amount);
    }

    public SuggestedPostPrice withAmount(long amount) {
        return new SuggestedPostPrice(currency, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestedPostPrice)) {
            return false;
        }
        SuggestedPostPrice that = (SuggestedPostPrice) o;
        return Objects.equals(this.currency, that.currency)
                && this.amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currency, this.amount);
    }

    @Override
    public String toString() {
        return "SuggestedPostPrice[currency=" + this.currency
                + ", amount=" + this.amount
                + "]";
    }
}
