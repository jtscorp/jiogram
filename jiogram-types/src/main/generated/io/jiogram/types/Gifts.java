package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import java.util.List;
import java.util.Objects;

/**
 * This object represent a list of gifts.
 *
 * @see <a href="https://core.telegram.org/bots/api#gifts">Gifts in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class Gifts {

    @JsonProperty("gifts")
    private final List<Gift> gifts;

    /**
     * Creates a new {@code Gifts} instance.
     *
     * @param gifts The list of gifts
     */
    @JsonCreator
    public Gifts(
            @JsonProperty("gifts") List<Gift> gifts) {
        this.gifts = gifts;
    }

    /**
     * The list of gifts
     */
    public List<Gift> gifts() {
        return gifts;
    }

    public Gifts withGifts(List<Gift> gifts) {
        return new Gifts(gifts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Gifts)) {
            return false;
        }
        Gifts that = (Gifts) o;
        return Objects.equals(this.gifts, that.gifts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.gifts);
    }

    @Override
    public String toString() {
        return "Gifts[gifts=" + this.gifts
                + "]";
    }
}
