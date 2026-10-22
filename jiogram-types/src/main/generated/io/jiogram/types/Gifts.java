package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Gift;
import java.util.List;

/**
 * This object represent a list of gifts.
 *
 * @param gifts The list of gifts
 * @see <a href="https://core.telegram.org/bots/api#gifts">Gifts in the Bot API</a>
 */
public record Gifts(
    @JsonProperty("gifts") List<Gift> gifts
) {

    public Gifts withGifts(List<Gift> gifts) {
        return new Gifts(gifts);
    }
}
