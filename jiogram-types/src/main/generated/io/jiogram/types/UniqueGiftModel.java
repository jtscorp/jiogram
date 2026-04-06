package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import org.jspecify.annotations.Nullable;

public record UniqueGiftModel(
    @JsonProperty("name") String name,
    @JsonProperty("sticker") Sticker sticker,
    @JsonProperty("rarity_per_mille") long rarityPerMille,
    @JsonProperty("rarity") @Nullable String rarity
) {}
