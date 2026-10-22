package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.UniqueGiftBackdropColors;
import java.util.Objects;

/**
 * This object describes the backdrop of a unique gift.
 *
 * @see <a href="https://core.telegram.org/bots/api#uniquegiftbackdrop">UniqueGiftBackdrop in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class UniqueGiftBackdrop {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("colors")
    private final UniqueGiftBackdropColors colors;

    @JsonProperty("rarity_per_mille")
    private final long rarityPerMille;

    /**
     * Creates a new {@code UniqueGiftBackdrop} instance.
     *
     * @param name Name of the backdrop
     * @param colors Colors of the backdrop
     * @param rarityPerMille The number of unique gifts that receive this backdrop for every 1000
     *     gifts upgraded
     */
    @JsonCreator
    public UniqueGiftBackdrop(
            @JsonProperty("name") String name,
            @JsonProperty("colors") UniqueGiftBackdropColors colors,
            @JsonProperty("rarity_per_mille") long rarityPerMille) {
        this.name = name;
        this.colors = colors;
        this.rarityPerMille = rarityPerMille;
    }

    /**
     * Name of the backdrop
     */
    public String name() {
        return name;
    }

    /**
     * Colors of the backdrop
     */
    public UniqueGiftBackdropColors colors() {
        return colors;
    }

    /**
     * The number of unique gifts that receive this backdrop for every 1000 gifts upgraded
     */
    public long rarityPerMille() {
        return rarityPerMille;
    }

    public UniqueGiftBackdrop withName(String name) {
        return new UniqueGiftBackdrop(name, colors, rarityPerMille);
    }

    public UniqueGiftBackdrop withColors(UniqueGiftBackdropColors colors) {
        return new UniqueGiftBackdrop(name, colors, rarityPerMille);
    }

    public UniqueGiftBackdrop withRarityPerMille(long rarityPerMille) {
        return new UniqueGiftBackdrop(name, colors, rarityPerMille);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UniqueGiftBackdrop)) {
            return false;
        }
        UniqueGiftBackdrop that = (UniqueGiftBackdrop) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.colors, that.colors)
                && this.rarityPerMille == that.rarityPerMille;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.colors, this.rarityPerMille);
    }

    @Override
    public String toString() {
        return "UniqueGiftBackdrop[name=" + this.name
                + ", colors=" + this.colors
                + ", rarityPerMille=" + this.rarityPerMille
                + "]";
    }
}
