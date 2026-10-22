package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMedia;
import java.util.List;

/**
 * Describes the paid media added to a message.
 *
 * @param starCount The number of Telegram Stars that must be paid to buy access to the media
 * @param paidMedia Information about the paid media
 * @see <a href="https://core.telegram.org/bots/api#paidmediainfo">PaidMediaInfo in the Bot API</a>
 */
public record PaidMediaInfo(
    @JsonProperty("star_count") long starCount,
    @JsonProperty("paid_media") List<PaidMedia> paidMedia
) {

    public PaidMediaInfo withStarCount(long starCount) {
        return new PaidMediaInfo(starCount, paidMedia);
    }

    public PaidMediaInfo withPaidMedia(List<PaidMedia> paidMedia) {
        return new PaidMediaInfo(starCount, paidMedia);
    }
}
