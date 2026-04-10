package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;

public class UniqueGiftSymbol {
    @JsonProperty("name") private final String name;
    @JsonProperty("sticker") private final Sticker sticker;
    @JsonProperty("rarity_per_mille") private final long rarityPerMille;

    @JsonCreator
    public UniqueGiftSymbol(
            @JsonProperty("name") String name,
            @JsonProperty("sticker") Sticker sticker,
            @JsonProperty("rarity_per_mille") long rarityPerMille
    ) {
        this.name = name;
        this.sticker = sticker;
        this.rarityPerMille = rarityPerMille;
    }

    public String name() {
        return this.name;
    }

    public Sticker sticker() {
        return this.sticker;
    }

    public long rarityPerMille() {
        return this.rarityPerMille;
    }
}
