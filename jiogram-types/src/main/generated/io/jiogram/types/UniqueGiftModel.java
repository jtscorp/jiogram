package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object describes the model of a unique gift.
 *
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftmodel">UniqueGiftModel in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UniqueGiftModel {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("sticker")
    private final Sticker sticker;

    @JsonProperty("rarity_per_mille")
    private final long rarityPerMille;

    @JsonProperty("rarity")
    private final @Nullable String rarity;

    /**
     * Creates a new {@code UniqueGiftModel} instance.
     *
     * @param name Name of the model
     * @param sticker The sticker that represents the unique gift
     * @param rarityPerMille The number of unique gifts that receive this model for every 1000 gift
     *     upgrades. Always 0 for crafted gifts.
     * @param rarity Rarity of the model if it is a crafted model. Currently, can be 'uncommon',
     *     'rare', 'epic', or 'legendary'.
     */
    @JsonCreator
    public UniqueGiftModel(
            @JsonProperty("name") String name,
            @JsonProperty("sticker") Sticker sticker,
            @JsonProperty("rarity_per_mille") long rarityPerMille,
            @JsonProperty("rarity") @Nullable String rarity) {
        this.name = name;
        this.sticker = sticker;
        this.rarityPerMille = rarityPerMille;
        this.rarity = rarity;
    }

    public static UniqueGiftModel of(String name, Sticker sticker, long rarityPerMille) {
        return new UniqueGiftModel(name, sticker, rarityPerMille, null);
    }

    /**
     * Name of the model
     */
    public String name() {
        return name;
    }

    /**
     * The sticker that represents the unique gift
     */
    public Sticker sticker() {
        return sticker;
    }

    /**
     * The number of unique gifts that receive this model for every 1000 gift upgrades. Always 0 for
     * crafted gifts.
     */
    public long rarityPerMille() {
        return rarityPerMille;
    }

    /**
     * Rarity of the model if it is a crafted model. Currently, can be 'uncommon', 'rare', 'epic',
     * or 'legendary'.
     */
    public @Nullable String rarity() {
        return rarity;
    }

    public UniqueGiftModel withName(String name) {
        return new UniqueGiftModel(name, sticker, rarityPerMille, rarity);
    }

    public UniqueGiftModel withSticker(Sticker sticker) {
        return new UniqueGiftModel(name, sticker, rarityPerMille, rarity);
    }

    public UniqueGiftModel withRarityPerMille(long rarityPerMille) {
        return new UniqueGiftModel(name, sticker, rarityPerMille, rarity);
    }

    public UniqueGiftModel withRarity(@Nullable String rarity) {
        return new UniqueGiftModel(name, sticker, rarityPerMille, rarity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniqueGiftModel)) {
            return false;
        }
        UniqueGiftModel that = (UniqueGiftModel) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.sticker, that.sticker)
                && this.rarityPerMille == that.rarityPerMille
                && Objects.equals(this.rarity, that.rarity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.sticker, this.rarityPerMille, this.rarity);
    }

    @Override
    public String toString() {
        return "UniqueGiftModel[name=" + this.name
                + ", sticker=" + this.sticker
                + ", rarityPerMille=" + this.rarityPerMille
                + ", rarity=" + this.rarity
                + "]";
    }
}
