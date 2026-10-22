package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputMediaType;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Represents a video to be sent.
 *
 * @param type Type of the result, must be video
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
 * @param caption Caption of the video to be sent, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the video caption. See formatting options for more
 *     details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
 * @param width Video width
 * @param height Video height
 * @param duration Video duration in seconds
 * @param supportsStreaming Pass True if the uploaded video is suitable for streaming
 * @param hasSpoiler Pass True if the video needs to be covered with a spoiler animation
 * @see <a href="https://core.telegram.org/bots/api#inputmediavideo">InputMediaVideo in the Bot API</a>
 */
public record InputMediaVideo(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputMediaType type,
    @JsonProperty("media") InputFileOrString media,
    @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
    @JsonProperty("cover") @Nullable InputFileOrString cover,
    @JsonProperty("start_timestamp") @Nullable Long startTimestamp,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("width") @Nullable Long width,
    @JsonProperty("height") @Nullable Long height,
    @JsonProperty("duration") @Nullable Long duration,
    @JsonProperty("supports_streaming") @Nullable Boolean supportsStreaming,
    @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler
) implements InputMedia {

    public InputMediaVideo withMedia(InputFileOrString media) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withCover(@Nullable InputFileOrString cover) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withStartTimestamp(@Nullable Long startTimestamp) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withCaption(@Nullable String caption) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withParseMode(@Nullable ParseMode parseMode) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withWidth(@Nullable Long width) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withHeight(@Nullable Long height) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withDuration(@Nullable Long duration) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withSupportsStreaming(@Nullable Boolean supportsStreaming) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }

    public InputMediaVideo withHasSpoiler(@Nullable Boolean hasSpoiler) {
        return new InputMediaVideo(type, media, thumbnail, cover, startTimestamp, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, supportsStreaming, hasSpoiler);
    }
}
