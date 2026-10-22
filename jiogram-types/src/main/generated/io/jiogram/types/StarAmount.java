package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Describes an amount of Telegram Stars.
 *
 * @param amount Integer amount of Telegram Stars, rounded to 0; can be negative
 * @param nanostarAmount The number of 1/1000000000 shares of Telegram Stars; from -999999999 to
 *     999999999; can be negative if and only if amount is non-positive
 * @see <a href="https://core.telegram.org/bots/api#staramount">StarAmount in the Bot API</a>
 */
public record StarAmount(
    @JsonProperty("amount") long amount,
    @JsonProperty("nanostar_amount") @Nullable Long nanostarAmount
) {

    public static StarAmount of(long amount) {
        return new StarAmount(amount, null);
    }

    public StarAmount withAmount(long amount) {
        return new StarAmount(amount, nanostarAmount);
    }

    public StarAmount withNanostarAmount(@Nullable Long nanostarAmount) {
        return new StarAmount(amount, nanostarAmount);
    }
}
