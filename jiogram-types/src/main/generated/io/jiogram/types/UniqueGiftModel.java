package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import org.jspecify.annotations.Nullable;

public class UniqueGiftModel {
    @JsonProperty("name") private final String name;
    @JsonProperty("sticker") private final Sticker sticker;
    @JsonProperty("rarity_per_mille") private final long rarityPerMille;
    @JsonProperty("rarity") @Nullable private final String rarity;

    @JsonCreator
    public UniqueGiftModel(
            @JsonProperty("name") String name,
            @JsonProperty("sticker") Sticker sticker,
            @JsonProperty("rarity_per_mille") long rarityPerMille,
            @JsonProperty("rarity") @Nullable String rarity
    ) {
        this.name = name;
        this.sticker = sticker;
        this.rarityPerMille = rarityPerMille;
        this.rarity = rarity;
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

    public String rarity() {
        return this.rarity;
    }
}
