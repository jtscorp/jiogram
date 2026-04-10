package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UniqueGiftBackdropColors;

public class UniqueGiftBackdrop {
    @JsonProperty("name") private final String name;
    @JsonProperty("colors") private final UniqueGiftBackdropColors colors;
    @JsonProperty("rarity_per_mille") private final long rarityPerMille;

    @JsonCreator
    public UniqueGiftBackdrop(
            @JsonProperty("name") String name,
            @JsonProperty("colors") UniqueGiftBackdropColors colors,
            @JsonProperty("rarity_per_mille") long rarityPerMille
    ) {
        this.name = name;
        this.colors = colors;
        this.rarityPerMille = rarityPerMille;
    }

    public String name() {
        return this.name;
    }

    public UniqueGiftBackdropColors colors() {
        return this.colors;
    }

    public long rarityPerMille() {
        return this.rarityPerMille;
    }
}
