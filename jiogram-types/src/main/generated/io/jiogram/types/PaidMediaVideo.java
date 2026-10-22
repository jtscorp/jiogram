package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.PaidMediaType;
import io.jiogram.types.Video;
import java.util.Objects;

/**
 * The paid media is a video.
 *
 * @see <a href="https://core.telegram.org/bots/api#paidmediavideo">PaidMediaVideo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class PaidMediaVideo implements PaidMedia {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final PaidMediaType type;

    @JsonProperty("video")
    private final Video video;

    /**
     * Creates a new {@code PaidMediaVideo} instance.
     *
     * @param type Type of the paid media, always 'video'
     * @param video The video
     */
    @JsonCreator
    public PaidMediaVideo(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) PaidMediaType type,
            @JsonProperty("video") Video video) {
        this.type = type;
        this.video = video;
    }

    public static PaidMediaVideo of(Video video) {
        return new PaidMediaVideo(PaidMediaType.VIDEO, video);
    }

    /**
     * Type of the paid media, always 'video'
     */
    public PaidMediaType type() {
        return type;
    }

    /**
     * The video
     */
    public Video video() {
        return video;
    }

    public PaidMediaVideo withVideo(Video video) {
        return new PaidMediaVideo(type, video);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaidMediaVideo)) {
            return false;
        }
        PaidMediaVideo that = (PaidMediaVideo) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.video, that.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.video);
    }

    @Override
    public String toString() {
        return "PaidMediaVideo[type=" + this.type
                + ", video=" + this.video
                + "]";
    }
}
