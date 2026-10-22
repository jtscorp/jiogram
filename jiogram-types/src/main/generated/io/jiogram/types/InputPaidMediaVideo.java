package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputPaidMediaType;
import org.jspecify.annotations.Nullable;

/**
 * The paid media to send is a video.
 *
 * @param type Type of the media, must be video
 * @param media File to send. Pass a file_id to send a file that exists on the Telegram servers
 *     (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass
 *     'attach://&lt;file_attach_name&gt;' to upload a new one using multipart/form-data under
 *     &lt;file_attach_name&gt; name. More information on Sending Files
 * @param thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file
 *     is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in
 *     size. A thumbnail's width and height should not exceed 320. Ignored if the file is not
 *     uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a
 *     new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the thumbnail was uploaded
 *     using multipart/form-data under &lt;file_attach_name&gt;. More information on Sending Files
 * @param cover Cover for the video in the message. Pass a file_id to send a file that exists on the
 *     Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the
 *     Internet, or pass 'attach://&lt;file_attach_name&gt;' to upload a new one using
 *     multipart/form-data under &lt;file_attach_name&gt; name. More information on Sending Files
 * @param startTimestamp Start timestamp for the video in the message
 * @param width Video width
 * @param height Video height
 * @param duration Video duration in seconds
 * @param supportsStreaming Pass True if the uploaded video is suitable for streaming
 * @see <a href="https://core.telegram.org/bots/api#inputpaidmediavideo">InputPaidMediaVideo in the Bot API</a>
 */
public record InputPaidMediaVideo(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputPaidMediaType type,
    @JsonProperty("media") InputFileOrString media,
    @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
    @JsonProperty("cover") @Nullable InputFileOrString cover,
    @JsonProperty("start_timestamp") @Nullable Long startTimestamp,
    @JsonProperty("width") @Nullable Long width,
    @JsonProperty("height") @Nullable Long height,
    @JsonProperty("duration") @Nullable Long duration,
    @JsonProperty("supports_streaming") @Nullable Boolean supportsStreaming
) implements InputPaidMedia {

    public InputPaidMediaVideo withMedia(InputFileOrString media) {
        return new InputPaidMediaVideo(type, media, thumbnail, cover, startTimestamp, width, height, duration, supportsStreaming);
    }

    public InputPaidMediaVideo withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new InputPaidMediaVideo(type, media, thumbnail, cover, startTimestamp, width, height, duration, supportsStreaming);
    }

    public InputPaidMediaVideo withCover(@Nullable InputFileOrString cover) {
        return new InputPaidMediaVideo(type, media, thumbnail, cover, startTimestamp, width, height, duration, supportsStreaming);
    }

    public InputPaidMediaVideo withStartTimestamp(@Nullable Long startTimestamp) {
        return new InputPaidMediaVideo(type, media, thumbnail, cover, startTimestamp, width, height, duration, supportsStreaming);
    }

    public InputPaidMediaVideo withWidth(@Nullable Long width) {
        return new InputPaidMediaVideo(type, media, thumbnail, cover, startTimestamp, width, height, duration, supportsStreaming);
    }

    public InputPaidMediaVideo withHeight(@Nullable Long height) {
        return new InputPaidMediaVideo(type, media, thumbnail, cover, startTimestamp, width, height, duration, supportsStreaming);
    }

    public InputPaidMediaVideo withDuration(@Nullable Long duration) {
        return new InputPaidMediaVideo(type, media, thumbnail, cover, startTimestamp, width, height, duration, supportsStreaming);
    }

    public InputPaidMediaVideo withSupportsStreaming(@Nullable Boolean supportsStreaming) {
        return new InputPaidMediaVideo(type, media, thumbnail, cover, startTimestamp, width, height, duration, supportsStreaming);
    }
}
