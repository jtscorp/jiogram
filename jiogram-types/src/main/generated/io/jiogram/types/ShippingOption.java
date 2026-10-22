package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LabeledPrice;
import java.util.List;
import java.util.Objects;

/**
 * This object represents one shipping option.
 *
 * @see <a href="https://core.telegram.org/bots/api#shippingoption">ShippingOption in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ShippingOption {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("prices")
    private final List<LabeledPrice> prices;

    /**
     * Creates a new {@code ShippingOption} instance.
     *
     * @param id Shipping option identifier
     * @param title Option title
     * @param prices List of price portions
     */
    @JsonCreator
    public ShippingOption(
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("prices") List<LabeledPrice> prices) {
        this.id = id;
        this.title = title;
        this.prices = prices;
    }

    /**
     * Shipping option identifier
     */
    public String id() {
        return id;
    }

    /**
     * Option title
     */
    public String title() {
        return title;
    }

    /**
     * List of price portions
     */
    public List<LabeledPrice> prices() {
        return prices;
    }

    public ShippingOption withId(String id) {
        return new ShippingOption(id, title, prices);
    }

    public ShippingOption withTitle(String title) {
        return new ShippingOption(id, title, prices);
    }

    public ShippingOption withPrices(List<LabeledPrice> prices) {
        return new ShippingOption(id, title, prices);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShippingOption)) {
            return false;
        }
        ShippingOption that = (ShippingOption) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.prices, that.prices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.prices);
    }

    @Override
    public String toString() {
        return "ShippingOption[id=" + this.id
                + ", title=" + this.title
                + ", prices=" + this.prices
                + "]";
    }
}
