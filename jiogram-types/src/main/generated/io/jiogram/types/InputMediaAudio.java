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
 * Represents an audio file to be treated as music to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmediaaudio">InputMediaAudio in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputMediaAudio implements InputMedia {

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

    @JsonProperty("duration")
    private final @Nullable Long duration;

    @JsonProperty("performer")
    private final @Nullable String performer;

    @JsonProperty("title")
    private final @Nullable String title;

    /**
     * Creates a new {@code InputMediaAudio} instance.
     *
     * @param type Type of the result, must be audio
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
     * @param caption Caption of the audio to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the audio caption. See formatting options for
     *     more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param duration Duration of the audio in seconds
     * @param performer Performer of the audio
     * @param title Title of the audio
     */
    @JsonCreator
    public InputMediaAudio(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputMediaType type,
            @JsonProperty("media") InputFileOrString media,
            @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("duration") @Nullable Long duration,
            @JsonProperty("performer") @Nullable String performer,
            @JsonProperty("title") @Nullable String title) {
        this.type = type;
        this.media = media;
        this.thumbnail = thumbnail;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
    }

    public static InputMediaAudio of(InputFileOrString media) {
        return new InputMediaAudio(InputMediaType.AUDIO, media, null, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be audio
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
     * Caption of the audio to be sent, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the audio caption. See formatting options for more details.
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
     * Duration of the audio in seconds
     */
    public @Nullable Long duration() {
        return duration;
    }

    /**
     * Performer of the audio
     */
    public @Nullable String performer() {
        return performer;
    }

    /**
     * Title of the audio
     */
    public @Nullable String title() {
        return title;
    }

    public InputMediaAudio withMedia(InputFileOrString media) {
        return new InputMediaAudio(type, media, thumbnail, caption, parseMode, captionEntities, duration, performer, title);
    }

    public InputMediaAudio withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new InputMediaAudio(type, media, thumbnail, caption, parseMode, captionEntities, duration, performer, title);
    }

    public InputMediaAudio withCaption(@Nullable String caption) {
        return new InputMediaAudio(type, media, thumbnail, caption, parseMode, captionEntities, duration, performer, title);
    }

    public InputMediaAudio withParseMode(@Nullable ParseMode parseMode) {
        return new InputMediaAudio(type, media, thumbnail, caption, parseMode, captionEntities, duration, performer, title);
    }

    public InputMediaAudio withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InputMediaAudio(type, media, thumbnail, caption, parseMode, captionEntities, duration, performer, title);
    }

    public InputMediaAudio withDuration(@Nullable Long duration) {
        return new InputMediaAudio(type, media, thumbnail, caption, parseMode, captionEntities, duration, performer, title);
    }

    public InputMediaAudio withPerformer(@Nullable String performer) {
        return new InputMediaAudio(type, media, thumbnail, caption, parseMode, captionEntities, duration, performer, title);
    }

    public InputMediaAudio withTitle(@Nullable String title) {
        return new InputMediaAudio(type, media, thumbnail, caption, parseMode, captionEntities, duration, performer, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputMediaAudio)) {
            return false;
        }
        InputMediaAudio that = (InputMediaAudio) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.media, that.media)
                && Objects.equals(this.thumbnail, that.thumbnail)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.duration, that.duration)
                && Objects.equals(this.performer, that.performer)
                && Objects.equals(this.title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.media, this.thumbnail, this.caption, this.parseMode, this.captionEntities, this.duration, this.performer, this.title);
    }

    @Override
    public String toString() {
        return "InputMediaAudio[type=" + this.type
                + ", media=" + this.media
                + ", thumbnail=" + this.thumbnail
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", duration=" + this.duration
                + ", performer=" + this.performer
                + ", title=" + this.title
                + "]";
    }
}
