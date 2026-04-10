package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LabeledPrice;
import java.util.List;

public class ShippingOption {
    @JsonProperty("id") private final String id;
    @JsonProperty("title") private final String title;
    @JsonProperty("prices") private final List<LabeledPrice> prices;

    @JsonCreator
    public ShippingOption(
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("prices") List<LabeledPrice> prices
    ) {
        this.id = id;
        this.title = title;
        this.prices = prices;
    }

    public String id() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public List<LabeledPrice> prices() {
        return this.prices;
    }
}
