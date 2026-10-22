package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGift;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Contains the list of gifts received and owned by a user or a chat.
 *
 * @param totalCount The total number of gifts owned by the user or the chat
 * @param gifts The list of gifts
 * @param nextOffset Offset for the next request. If empty, then there are no more results
 * @see <a href="https://core.telegram.org/bots/api#ownedgifts">OwnedGifts in the Bot API</a>
 */
public record OwnedGifts(
    @JsonProperty("total_count") long totalCount,
    @JsonProperty("gifts") List<OwnedGift> gifts,
    @JsonProperty("next_offset") @Nullable String nextOffset
) {

    public static OwnedGifts of(long totalCount, List<OwnedGift> gifts) {
        return new OwnedGifts(totalCount, gifts, null);
    }

    public OwnedGifts withTotalCount(long totalCount) {
        return new OwnedGifts(totalCount, gifts, nextOffset);
    }

    public OwnedGifts withGifts(List<OwnedGift> gifts) {
        return new OwnedGifts(totalCount, gifts, nextOffset);
    }

    public OwnedGifts withNextOffset(@Nullable String nextOffset) {
        return new OwnedGifts(totalCount, gifts, nextOffset);
    }
}
