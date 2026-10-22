package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Sticker;
import java.util.Objects;

/**
 * This object describes the symbol shown on the pattern of a unique gift.
 *
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftsymbol">UniqueGiftSymbol in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UniqueGiftSymbol {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("sticker")
    private final Sticker sticker;

    @JsonProperty("rarity_per_mille")
    private final long rarityPerMille;

    /**
     * Creates a new {@code UniqueGiftSymbol} instance.
     *
     * @param name Name of the symbol
     * @param sticker The sticker that represents the unique gift
     * @param rarityPerMille The number of unique gifts that receive this model for every 1000 gifts
     *     upgraded
     */
    @JsonCreator
    public UniqueGiftSymbol(
            @JsonProperty("name") String name,
            @JsonProperty("sticker") Sticker sticker,
            @JsonProperty("rarity_per_mille") long rarityPerMille) {
        this.name = name;
        this.sticker = sticker;
        this.rarityPerMille = rarityPerMille;
    }

    /**
     * Name of the symbol
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
     * The number of unique gifts that receive this model for every 1000 gifts upgraded
     */
    public long rarityPerMille() {
        return rarityPerMille;
    }

    public UniqueGiftSymbol withName(String name) {
        return new UniqueGiftSymbol(name, sticker, rarityPerMille);
    }

    public UniqueGiftSymbol withSticker(Sticker sticker) {
        return new UniqueGiftSymbol(name, sticker, rarityPerMille);
    }

    public UniqueGiftSymbol withRarityPerMille(long rarityPerMille) {
        return new UniqueGiftSymbol(name, sticker, rarityPerMille);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniqueGiftSymbol)) {
            return false;
        }
        UniqueGiftSymbol that = (UniqueGiftSymbol) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.sticker, that.sticker)
                && this.rarityPerMille == that.rarityPerMille;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.sticker, this.rarityPerMille);
    }

    @Override
    public String toString() {
        return "UniqueGiftSymbol[name=" + this.name
                + ", sticker=" + this.sticker
                + ", rarityPerMille=" + this.rarityPerMille
                + "]";
    }
}
