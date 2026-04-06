package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LabeledPrice;
import java.util.List;

public record ShippingOption(
    @JsonProperty("id") String id,
    @JsonProperty("title") String title,
    @JsonProperty("prices") List<LabeledPrice> prices
) {}
