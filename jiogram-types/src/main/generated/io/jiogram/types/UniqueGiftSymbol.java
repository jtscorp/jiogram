package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;

public record UniqueGiftSymbol(
    @JsonProperty("name") String name,
    @JsonProperty("sticker") Sticker sticker,
    @JsonProperty("rarity_per_mille") long rarityPerMille
) {}
