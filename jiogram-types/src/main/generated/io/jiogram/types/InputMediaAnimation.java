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
 * Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmediaanimation">InputMediaAnimation in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputMediaAnimation implements InputMedia {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InputMediaType type;

    @JsonProperty("media")
    private final InputFileOrString media;

    @JsonProperty("thumbnail")
    private final @Nullable InputFileOrString thumbnail;

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

    @JsonProperty("has_spoiler")
    private final @Nullable Boolean hasSpoiler;

    /**
     * Creates a new {@code InputMediaAnimation} instance.
     *
     * @param type Type of the result, must be animation
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
     * @param caption Caption of the animation to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the animation caption. See formatting options
     *     for more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param width Animation width
     * @param height Animation height
     * @param duration Animation duration in seconds
     * @param hasSpoiler Pass True if the animation needs to be covered with a spoiler animation
     */
    @JsonCreator
    public InputMediaAnimation(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputMediaType type,
            @JsonProperty("media") InputFileOrString media,
            @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("duration") @Nullable Long duration,
            @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler) {
        this.type = type;
        this.media = media;
        this.thumbnail = thumbnail;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.hasSpoiler = hasSpoiler;
    }

    public static InputMediaAnimation of(InputFileOrString media) {
        return new InputMediaAnimation(InputMediaType.ANIMATION, media, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be animation
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
     * Caption of the animation to be sent, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the animation caption. See formatting options for more details.
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
     * Animation width
     */
    public @Nullable Long width() {
        return width;
    }

    /**
     * Animation height
     */
    public @Nullable Long height() {
        return height;
    }

    /**
     * Animation duration in seconds
     */
    public @Nullable Long duration() {
        return duration;
    }

    /**
     * Pass True if the animation needs to be covered with a spoiler animation
     */
    public @Nullable Boolean hasSpoiler() {
        return hasSpoiler;
    }

    public InputMediaAnimation withMedia(InputFileOrString media) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    public InputMediaAnimation withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    public InputMediaAnimation withCaption(@Nullable String caption) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    public InputMediaAnimation withParseMode(@Nullable ParseMode parseMode) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    public InputMediaAnimation withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    public InputMediaAnimation withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    public InputMediaAnimation withWidth(@Nullable Long width) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    public InputMediaAnimation withHeight(@Nullable Long height) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    public InputMediaAnimation withDuration(@Nullable Long duration) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    public InputMediaAnimation withHasSpoiler(@Nullable Boolean hasSpoiler) {
        return new InputMediaAnimation(type, media, thumbnail, caption, parseMode, captionEntities, showCaptionAboveMedia, width, height, duration, hasSpoiler);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputMediaAnimation)) {
            return false;
        }
        InputMediaAnimation that = (InputMediaAnimation) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.media, that.media)
                && Objects.equals(this.thumbnail, that.thumbnail)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.width, that.width)
                && Objects.equals(this.height, that.height)
                && Objects.equals(this.duration, that.duration)
                && Objects.equals(this.hasSpoiler, that.hasSpoiler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.media, this.thumbnail, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.width, this.height, this.duration, this.hasSpoiler);
    }

    @Override
    public String toString() {
        return "InputMediaAnimation[type=" + this.type
                + ", media=" + this.media
                + ", thumbnail=" + this.thumbnail
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", width=" + this.width
                + ", height=" + this.height
                + ", duration=" + this.duration
                + ", hasSpoiler=" + this.hasSpoiler
                + "]";
    }
}
