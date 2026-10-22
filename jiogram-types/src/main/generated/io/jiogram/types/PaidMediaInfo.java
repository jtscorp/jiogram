package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMedia;
import java.util.List;
import java.util.Objects;

/**
 * Describes the paid media added to a message.
 *
 * @see <a href="https://core.telegram.org/bots/api#paidmediainfo">PaidMediaInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PaidMediaInfo {

    @JsonProperty("star_count")
    private final long starCount;

    @JsonProperty("paid_media")
    private final List<PaidMedia> paidMedia;

    /**
     * Creates a new {@code PaidMediaInfo} instance.
     *
     * @param starCount The number of Telegram Stars that must be paid to buy access to the media
     * @param paidMedia Information about the paid media
     */
    @JsonCreator
    public PaidMediaInfo(
            @JsonProperty("star_count") long starCount,
            @JsonProperty("paid_media") List<PaidMedia> paidMedia) {
        this.starCount = starCount;
        this.paidMedia = paidMedia;
    }

    /**
     * The number of Telegram Stars that must be paid to buy access to the media
     */
    public long starCount() {
        return starCount;
    }

    /**
     * Information about the paid media
     */
    public List<PaidMedia> paidMedia() {
        return paidMedia;
    }

    public PaidMediaInfo withStarCount(long starCount) {
        return new PaidMediaInfo(starCount, paidMedia);
    }

    public PaidMediaInfo withPaidMedia(List<PaidMedia> paidMedia) {
        return new PaidMediaInfo(starCount, paidMedia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaidMediaInfo)) {
            return false;
        }
        PaidMediaInfo that = (PaidMediaInfo) o;
        return this.starCount == that.starCount
                && Objects.equals(this.paidMedia, that.paidMedia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.starCount, this.paidMedia);
    }

    @Override
    public String toString() {
        return "PaidMediaInfo[starCount=" + this.starCount
                + ", paidMedia=" + this.paidMedia
                + "]";
    }
}
