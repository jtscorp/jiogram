package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import org.jspecify.annotations.Nullable;

/**
 * This object describes the model of a unique gift.
 *
 * @param name Name of the model
 * @param sticker The sticker that represents the unique gift
 * @param rarityPerMille The number of unique gifts that receive this model for every 1000 gift
 *     upgrades. Always 0 for crafted gifts.
 * @param rarity Rarity of the model if it is a crafted model. Currently, can be 'uncommon', 'rare',
 *     'epic', or 'legendary'.
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftmodel">UniqueGiftModel in the Bot API</a>
 */
public record UniqueGiftModel(
    @JsonProperty("name") String name,
    @JsonProperty("sticker") Sticker sticker,
    @JsonProperty("rarity_per_mille") long rarityPerMille,
    @JsonProperty("rarity") @Nullable String rarity
) {}
