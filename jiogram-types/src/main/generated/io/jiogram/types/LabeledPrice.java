package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object represents a portion of the price for goods or services.
 *
 * @param label Portion label
 * @param amount Price of the product in the smallest units of the currency (integer, not
 *     float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter
 *     in currencies.json, it shows the number of digits past the decimal point for each currency (2
 *     for the majority of currencies).
 * @see <a href="https://core.telegram.org/bots/api#labeledprice">LabeledPrice in the Bot API</a>
 */
public record LabeledPrice(
    @JsonProperty("label") String label,
    @JsonProperty("amount") long amount
) {}
