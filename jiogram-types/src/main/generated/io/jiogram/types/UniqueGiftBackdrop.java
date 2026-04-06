package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UniqueGiftBackdropColors;

public record UniqueGiftBackdrop(
    @JsonProperty("name") String name,
    @JsonProperty("colors") UniqueGiftBackdropColors colors,
    @JsonProperty("rarity_per_mille") long rarityPerMille
) {}
