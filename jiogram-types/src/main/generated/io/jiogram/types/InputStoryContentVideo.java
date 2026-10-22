package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputStoryContentType;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Describes a video to post as a story.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputstorycontentvideo">InputStoryContentVideo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputStoryContentVideo implements InputStoryContent {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InputStoryContentType type;

    @JsonProperty("video")
    private final InputFileOrString video;

    @JsonProperty("duration")
    private final @Nullable Double duration;

    @JsonProperty("cover_frame_timestamp")
    private final @Nullable Double coverFrameTimestamp;

    @JsonProperty("is_animation")
    private final @Nullable Boolean isAnimation;

    /**
     * Creates a new {@code InputStoryContentVideo} instance.
     *
     * @param type Type of the content, must be video
     * @param video The video to post as a story. The video must be of the size 720x1280,
     *     streamable, encoded with H.265 codec, with key frames added each second in the MPEG4
     *     format, and must not exceed 30 MB. The video can't be reused and can only be uploaded as
     *     a new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the video was uploaded
     *     using multipart/form-data under &lt;file_attach_name&gt;. More information on Sending
     *     Files
     * @param duration Precise duration of the video in seconds; 0-60
     * @param coverFrameTimestamp Timestamp in seconds of the frame that will be used as the static
     *     cover for the story. Defaults to 0.0.
     * @param isAnimation Pass True if the video has no sound
     */
    @JsonCreator
    public InputStoryContentVideo(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputStoryContentType type,
            @JsonProperty("video") InputFileOrString video,
            @JsonProperty("duration") @Nullable Double duration,
            @JsonProperty("cover_frame_timestamp") @Nullable Double coverFrameTimestamp,
            @JsonProperty("is_animation") @Nullable Boolean isAnimation) {
        this.type = type;
        this.video = video;
        this.duration = duration;
        this.coverFrameTimestamp = coverFrameTimestamp;
        this.isAnimation = isAnimation;
    }

    public static InputStoryContentVideo of(InputFileOrString video) {
        return new InputStoryContentVideo(InputStoryContentType.VIDEO, video, null, null, null);
    }

    /**
     * Type of the content, must be video
     */
    public InputStoryContentType type() {
        return type;
    }

    /**
     * The video to post as a story. The video must be of the size 720x1280, streamable, encoded
     * with H.265 codec, with key frames added each second in the MPEG4 format, and must not exceed
     * 30 MB. The video can't be reused and can only be uploaded as a new file, so you can pass
     * 'attach://&lt;file_attach_name&gt;' if the video was uploaded using multipart/form-data under
     * &lt;file_attach_name&gt;. More information on Sending Files
     */
    public InputFileOrString video() {
        return video;
    }

    /**
     * Precise duration of the video in seconds; 0-60
     */
    public @Nullable Double duration() {
        return duration;
    }

    /**
     * Timestamp in seconds of the frame that will be used as the static cover for the story.
     * Defaults to 0.0.
     */
    public @Nullable Double coverFrameTimestamp() {
        return coverFrameTimestamp;
    }

    /**
     * Pass True if the video has no sound
     */
    public @Nullable Boolean isAnimation() {
        return isAnimation;
    }

    public InputStoryContentVideo withVideo(InputFileOrString video) {
        return new InputStoryContentVideo(type, video, duration, coverFrameTimestamp, isAnimation);
    }

    public InputStoryContentVideo withDuration(@Nullable Double duration) {
        return new InputStoryContentVideo(type, video, duration, coverFrameTimestamp, isAnimation);
    }

    public InputStoryContentVideo withCoverFrameTimestamp(@Nullable Double coverFrameTimestamp) {
        return new InputStoryContentVideo(type, video, duration, coverFrameTimestamp, isAnimation);
    }

    public InputStoryContentVideo withIsAnimation(@Nullable Boolean isAnimation) {
        return new InputStoryContentVideo(type, video, duration, coverFrameTimestamp, isAnimation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputStoryContentVideo)) {
            return false;
        }
        InputStoryContentVideo that = (InputStoryContentVideo) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.video, that.video)
                && Objects.equals(this.duration, that.duration)
                && Objects.equals(this.coverFrameTimestamp, that.coverFrameTimestamp)
                && Objects.equals(this.isAnimation, that.isAnimation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.video, this.duration, this.coverFrameTimestamp, this.isAnimation);
    }

    @Override
    public String toString() {
        return "InputStoryContentVideo[type=" + this.type
                + ", video=" + this.video
                + ", duration=" + this.duration
                + ", coverFrameTimestamp=" + this.coverFrameTimestamp
                + ", isAnimation=" + this.isAnimation
                + "]";
    }
}
