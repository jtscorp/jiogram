package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputMediaType;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a video to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmediavideo">InputMediaVideo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputMediaVideo implements InputMedia {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InputMediaType type;

    @JsonProperty("media")
    private final InputFileOrString media;

    @JsonProperty("thumbnail")
    private final @Nullable InputFileOrString thumbnail;

    @JsonProperty("cover")
    private final @Nullable InputFileOrString cover;

    @JsonProperty("start_timestamp")
    private final @Nullable Long startTimestamp;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("show_caption_above_media")
    private final @Nullable Boolean showCaptionAboveMedia;

    @JsonProperty("width")
    private final @Nullable Long width;

    @JsonProperty("height")
    private final @Nullable Long height;

    @JsonProperty("duration")
    private final @Nullable Long duration;

    @JsonProperty("supports_streaming")
    private final @Nullable Boolean supportsStreaming;

    @JsonProperty("has_spoiler")
    private final @Nullable Boolean hasSpoiler;

    /**
     * Creates a new {@code InputMediaVideo} instance.
     *
     * @param type Type of the result, must be video
     * @param media File to send. Pass a file_id to send a file that exists on the Telegram servers
     *     (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass
     *     'attach://&lt;file_attach_name&gt;' to upload a new one using multipart/form-data under
     *     &lt;file_attach_name&gt; name. More information on Sending Files
     * @param thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the
     *     file is supported server-side. The thumbnail should be in JPEG format and less than 200
     *     kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is
     *     not uploaded using multipart/form-data. Thumbnails can't be reused and can be only
     *     uploaded as a new file, so you can pass 'attach://&lt;file_attach_name&gt;' if the
     *     thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. More
     *     information on Sending Files
     * @param cover Cover for the video in the message. Pass a file_id to send a file that exists on
     *     the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the
     *     Internet, or pass 'attach://&lt;file_attach_name&gt;' to upload a new one using
     *     multipart/form-data under &lt;file_attach_name&gt; name. More information on Sending
     *     Files
     * @param startTimestamp Start timestamp for the video in the message
     * @param caption Caption of the video to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the video caption. See formatting options for
     *     more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param width Video width
     * @param height Video height
     * @param duration Video duration in seconds
     * @param supportsStreaming Pass True if the uploaded video is suitable for streaming
     * @param hasSpoiler Pass True if the video needs to be covered with a spoiler animation
     */
    @JsonCreator
    public InputMediaVideo(
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
            @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler) {
        this.type = type;
        this.media = media;
        this.thumbnail = thumbnail;
        this.cover = cover;
        this.startTimestamp = startTimestamp;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.supportsStreaming = supportsStreaming;
        this.hasSpoiler = hasSpoiler;
    }

    public static InputMediaVideo of(InputFileOrString media) {
        return new InputMediaVideo(InputMediaType.VIDEO, media, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be video
     */
    public InputMediaType type() {
        return type;
    }

    /**
     * File to send. Pass a file_id to send a file that exists on the Telegram servers
     * (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass
     * 'attach://&lt;file_attach_name&gt;' to upload a new one using multipart/form-data under
     * &lt;file_attach_name&gt; name. More information on Sending Files
     */
    public InputFileOrString media() {
        return media;
    }

    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported
     * server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A
     * thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using
     * multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so
     * you can pass 'attach://&lt;file_attach_name&gt;' if the thumbnail was uploaded using
     * multipart/form-data under &lt;file_attach_name&gt;. More information on Sending Files
     */
    public @Nullable InputFileOrString thumbnail() {
        return thumbnail;
    }

    /**
     * Cover for the video in the message. Pass a file_id to send a file that exists on the Telegram
     * servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass
     * 'attach://&lt;file_attach_name&gt;' to upload a new one using multipart/form-data under
     * &lt;file_attach_name&gt; name. More information on Sending Files
     */
    public @Nullable InputFileOrString cover() {
        return cover;
    }

    /**
     * Start timestamp for the video in the message
     */
    public @Nullable Long startTimestamp() {
        return startTimestamp;
    }

    /**
     * Caption of the video to be sent, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the video caption. See formatting options for more details.
     */
    public @Nullable ParseMode parseMode() {
        return parseMode;
    }

    /**
     * List of special entities that appear in the caption, which can be specified instead of
     * parse_mode
     */
    public @Nullable List<MessageEntity> captionEntities() {
        return captionEntities;
    }

    /**
     * Pass True, if the caption must be shown above the message media
     */
    public @Nullable Boolean showCaptionAboveMedia() {
        return showCaptionAboveMedia;
    }

    /**
     * Video width
     */
    public @Nullable Long width() {
        return width;
    }

    /**
     * Video height
     */
    public @Nullable Long height() {
        return height;
    }

    /**
     * Video duration in seconds
     */
    public @Nullable Long duration() {
        return duration;
    }

    /**
     * Pass True if the uploaded video is suitable for streaming
     */
    public @Nullable Boolean supportsStreaming() {
        return supportsStreaming;
    }

    /**
     * Pass True if the video needs to be covered with a spoiler animation
     */
    public @Nullable Boolean hasSpoiler() {
        return hasSpoiler;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputMediaVideo)) {
            return false;
        }
        InputMediaVideo that = (InputMediaVideo) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.media, that.media)
                && Objects.equals(this.thumbnail, that.thumbnail)
                && Objects.equals(this.cover, that.cover)
                && Objects.equals(this.startTimestamp, that.startTimestamp)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.width, that.width)
                && Objects.equals(this.height, that.height)
                && Objects.equals(this.duration, that.duration)
                && Objects.equals(this.supportsStreaming, that.supportsStreaming)
                && Objects.equals(this.hasSpoiler, that.hasSpoiler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.media, this.thumbnail, this.cover, this.startTimestamp, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.width, this.height, this.duration, this.supportsStreaming, this.hasSpoiler);
    }

    @Override
    public String toString() {
        return "InputMediaVideo[type=" + this.type
                + ", media=" + this.media
                + ", thumbnail=" + this.thumbnail
                + ", cover=" + this.cover
                + ", startTimestamp=" + this.startTimestamp
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", width=" + this.width
                + ", height=" + this.height
                + ", duration=" + this.duration
                + ", supportsStreaming=" + this.supportsStreaming
                + ", hasSpoiler=" + this.hasSpoiler
                + "]";
    }
}
