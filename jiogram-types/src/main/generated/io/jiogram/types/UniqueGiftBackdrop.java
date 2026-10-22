package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UniqueGiftBackdropColors;

/**
 * This object describes the backdrop of a unique gift.
 *
 * @param name Name of the backdrop
 * @param colors Colors of the backdrop
 * @param rarityPerMille The number of unique gifts that receive this backdrop for every 1000 gifts
 *     upgraded
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftbackdrop">UniqueGiftBackdrop in the Bot API</a>
 */
public record UniqueGiftBackdrop(
    @JsonProperty("name") String name,
    @JsonProperty("colors") UniqueGiftBackdropColors colors,
    @JsonProperty("rarity_per_mille") long rarityPerMille
) {}
