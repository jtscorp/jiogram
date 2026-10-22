package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object contains basic information about an invoice.
 *
 * @see <a href="https://core.telegram.org/bots/api#invoice">Invoice in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Invoice {

    @JsonProperty("title")
    private final String title;

    @JsonProperty("description")
    private final String description;

    @JsonProperty("start_parameter")
    private final String startParameter;

    @JsonProperty("currency")
    private final String currency;

    @JsonProperty("total_amount")
    private final long totalAmount;

    /**
     * Creates a new {@code Invoice} instance.
     *
     * @param title Product name
     * @param description Product description
     * @param startParameter Unique bot deep-linking parameter that can be used to generate this
     *     invoice
     * @param currency Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars
     * @param totalAmount Total price in the smallest units of the currency (integer, not
     *     float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp
     *     parameter in currencies.json, it shows the number of digits past the decimal point for
     *     each currency (2 for the majority of currencies).
     */
    @JsonCreator
    public Invoice(
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("start_parameter") String startParameter,
            @JsonProperty("currency") String currency,
            @JsonProperty("total_amount") long totalAmount) {
        this.title = title;
        this.description = description;
        this.startParameter = startParameter;
        this.currency = currency;
        this.totalAmount = totalAmount;
    }

    /**
     * Product name
     */
    public String title() {
        return title;
    }

    /**
     * Product description
     */
    public String description() {
        return description;
    }

    /**
     * Unique bot deep-linking parameter that can be used to generate this invoice
     */
    public String startParameter() {
        return startParameter;
    }

    /**
     * Three-letter ISO 4217 currency code, or 'XTR' for payments in Telegram Stars
     */
    public String currency() {
        return currency;
    }

    /**
     * Total price in the smallest units of the currency (integer, not float/double). For example,
     * for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows
     * the number of digits past the decimal point for each currency (2 for the majority of
     * currencies).
     */
    public long totalAmount() {
        return totalAmount;
    }

    public Invoice withTitle(String title) {
        return new Invoice(title, description, startParameter, currency, totalAmount);
    }

    public Invoice withDescription(String description) {
        return new Invoice(title, description, startParameter, currency, totalAmount);
    }

    public Invoice withStartParameter(String startParameter) {
        return new Invoice(title, description, startParameter, currency, totalAmount);
    }

    public Invoice withCurrency(String currency) {
        return new Invoice(title, description, startParameter, currency, totalAmount);
    }

    public Invoice withTotalAmount(long totalAmount) {
        return new Invoice(title, description, startParameter, currency, totalAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Invoice)) {
            return false;
        }
        Invoice that = (Invoice) o;
        return Objects.equals(this.title, that.title)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.startParameter, that.startParameter)
                && Objects.equals(this.currency, that.currency)
                && this.totalAmount == that.totalAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.description, this.startParameter, this.currency, this.totalAmount);
    }

    @Override
    public String toString() {
        return "Invoice[title=" + this.title
                + ", description=" + this.description
                + ", startParameter=" + this.startParameter
                + ", currency=" + this.currency
                + ", totalAmount=" + this.totalAmount
                + "]";
    }
}
