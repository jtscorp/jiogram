package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a portion of the price for goods or services.
 *
 * @see <a href="https://core.telegram.org/bots/api#labeledprice">LabeledPrice in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class LabeledPrice {

    @JsonProperty("label")
    private final String label;

    @JsonProperty("amount")
    private final long amount;

    /**
     * Creates a new {@code LabeledPrice} instance.
     *
     * @param label Portion label
     * @param amount Price of the product in the smallest units of the currency (integer, not
     *     float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp
     *     parameter in currencies.json, it shows the number of digits past the decimal point for
     *     each currency (2 for the majority of currencies).
     */
    @JsonCreator
    public LabeledPrice(
            @JsonProperty("label") String label,
            @JsonProperty("amount") long amount) {
        this.label = label;
        this.amount = amount;
    }

    /**
     * Portion label
     */
    public String label() {
        return label;
    }

    /**
     * Price of the product in the smallest units of the currency (integer, not float/double). For
     * example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json,
     * it shows the number of digits past the decimal point for each currency (2 for the majority of
     * currencies).
     */
    public long amount() {
        return amount;
    }

    public LabeledPrice withLabel(String label) {
        return new LabeledPrice(label, amount);
    }

    public LabeledPrice withAmount(long amount) {
        return new LabeledPrice(label, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LabeledPrice)) {
            return false;
        }
        LabeledPrice that = (LabeledPrice) o;
        return Objects.equals(this.label, that.label)
                && this.amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.label, this.amount);
    }

    @Override
    public String toString() {
        return "LabeledPrice[label=" + this.label
                + ", amount=" + this.amount
                + "]";
    }
}
