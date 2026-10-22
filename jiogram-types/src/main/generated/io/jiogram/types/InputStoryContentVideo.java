package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputStoryContentType;
import org.jspecify.annotations.Nullable;

/**
 * Describes a video to post as a story.
 *
 * @param type Type of the content, must be video
 * @param video The video to post as a story. The video must be of the size 720x1280, streamable,
 *     encoded with H.265 codec, with key frames added each second in the MPEG4 format, and must not
 *     exceed 30 MB. The video can't be reused and can only be uploaded as a new file, so you can
 *     pass 'attach://&lt;file_attach_name&gt;' if the video was uploaded using multipart/form-data
 *     under &lt;file_attach_name&gt;. More information on Sending Files
 * @param duration Precise duration of the video in seconds; 0-60
 * @param coverFrameTimestamp Timestamp in seconds of the frame that will be used as the static
 *     cover for the story. Defaults to 0.0.
 * @param isAnimation Pass True if the video has no sound
 * @see <a href="https://core.telegram.org/bots/api#inputstorycontentvideo">InputStoryContentVideo in the Bot API</a>
 */
public record InputStoryContentVideo(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputStoryContentType type,
    @JsonProperty("video") InputFileOrString video,
    @JsonProperty("duration") @Nullable Double duration,
    @JsonProperty("cover_frame_timestamp") @Nullable Double coverFrameTimestamp,
    @JsonProperty("is_animation") @Nullable Boolean isAnimation
) implements InputStoryContent {}
