package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.LabeledPrice;
import java.util.List;

/**
 * This object represents one shipping option.
 *
 * @param id Shipping option identifier
 * @param title Option title
 * @param prices List of price portions
 * @see <a href="https://core.telegram.org/bots/api#shippingoption">ShippingOption in the Bot API</a>
 */
public record ShippingOption(
    @JsonProperty("id") String id,
    @JsonProperty("title") String title,
    @JsonProperty("prices") List<LabeledPrice> prices
) {}
