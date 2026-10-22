package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import io.jiogram.types.Video;

/**
 * The paid media is a video.
 *
 * @param type Type of the paid media, always 'video'
 * @param video The video
 * @see <a href="https://core.telegram.org/bots/api#paidmediavideo">PaidMediaVideo in the Bot API</a>
 */
public record PaidMediaVideo(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) PaidMediaType type,
    @JsonProperty("video") Video video
) implements PaidMedia {

    public PaidMediaVideo withVideo(Video video) {
        return new PaidMediaVideo(type, video);
    }
}
