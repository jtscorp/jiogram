package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.OwnedGift;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Contains the list of gifts received and owned by a user or a chat.
 *
 * @see <a href="https://core.telegram.org/bots/api#ownedgifts">OwnedGifts in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class OwnedGifts {

    @JsonProperty("total_count")
    private final long totalCount;

    @JsonProperty("gifts")
    private final List<OwnedGift> gifts;

    @JsonProperty("next_offset")
    private final @Nullable String nextOffset;

    /**
     * Creates a new {@code OwnedGifts} instance.
     *
     * @param totalCount The total number of gifts owned by the user or the chat
     * @param gifts The list of gifts
     * @param nextOffset Offset for the next request. If empty, then there are no more results
     */
    @JsonCreator
    public OwnedGifts(
            @JsonProperty("total_count") long totalCount,
            @JsonProperty("gifts") List<OwnedGift> gifts,
            @JsonProperty("next_offset") @Nullable String nextOffset) {
        this.totalCount = totalCount;
        this.gifts = gifts;
        this.nextOffset = nextOffset;
    }

    public static OwnedGifts of(long totalCount, List<OwnedGift> gifts) {
        return new OwnedGifts(totalCount, gifts, null);
    }

    /**
     * The total number of gifts owned by the user or the chat
     */
    public long totalCount() {
        return totalCount;
    }

    /**
     * The list of gifts
     */
    public List<OwnedGift> gifts() {
        return gifts;
    }

    /**
     * Offset for the next request. If empty, then there are no more results
     */
    public @Nullable String nextOffset() {
        return nextOffset;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OwnedGifts)) {
            return false;
        }
        OwnedGifts that = (OwnedGifts) o;
        return this.totalCount == that.totalCount
                && Objects.equals(this.gifts, that.gifts)
                && Objects.equals(this.nextOffset, that.nextOffset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.totalCount, this.gifts, this.nextOffset);
    }

    @Override
    public String toString() {
        return "OwnedGifts[totalCount=" + this.totalCount
                + ", gifts=" + this.gifts
                + ", nextOffset=" + this.nextOffset
                + "]";
    }
}
