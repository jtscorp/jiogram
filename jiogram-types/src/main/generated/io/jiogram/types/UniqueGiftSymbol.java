package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;

/**
 * This object describes the symbol shown on the pattern of a unique gift.
 *
 * @param name Name of the symbol
 * @param sticker The sticker that represents the unique gift
 * @param rarityPerMille The number of unique gifts that receive this model for every 1000 gifts
 *     upgraded
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftsymbol">UniqueGiftSymbol in the Bot API</a>
 */
public record UniqueGiftSymbol(
    @JsonProperty("name") String name,
    @JsonProperty("sticker") Sticker sticker,
    @JsonProperty("rarity_per_mille") long rarityPerMille
) {

    public UniqueGiftSymbol withName(String name) {
        return new UniqueGiftSymbol(name, sticker, rarityPerMille);
    }

    public UniqueGiftSymbol withSticker(Sticker sticker) {
        return new UniqueGiftSymbol(name, sticker, rarityPerMille);
    }

    public UniqueGiftSymbol withRarityPerMille(long rarityPerMille) {
        return new UniqueGiftSymbol(name, sticker, rarityPerMille);
    }
}
