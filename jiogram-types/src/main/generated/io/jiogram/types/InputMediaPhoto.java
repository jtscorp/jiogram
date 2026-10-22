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
 * Represents a photo to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmediaphoto">InputMediaPhoto in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputMediaPhoto implements InputMedia {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InputMediaType type;

    @JsonProperty("media")
    private final InputFileOrString media;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("show_caption_above_media")
    private final @Nullable Boolean showCaptionAboveMedia;

    @JsonProperty("has_spoiler")
    private final @Nullable Boolean hasSpoiler;

    /**
     * Creates a new {@code InputMediaPhoto} instance.
     *
     * @param type Type of the result, must be photo
     * @param media File to send. Pass a file_id to send a file that exists on the Telegram servers
     *     (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass
     *     'attach://&lt;file_attach_name&gt;' to upload a new one using multipart/form-data under
     *     &lt;file_attach_name&gt; name. More information on Sending Files
     * @param caption Caption of the photo to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the photo caption. See formatting options for
     *     more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
     * @param hasSpoiler Pass True if the photo needs to be covered with a spoiler animation
     */
    @JsonCreator
    public InputMediaPhoto(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputMediaType type,
            @JsonProperty("media") InputFileOrString media,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler) {
        this.type = type;
        this.media = media;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.hasSpoiler = hasSpoiler;
    }

    public static InputMediaPhoto of(InputFileOrString media) {
        return new InputMediaPhoto(InputMediaType.PHOTO, media, null, null, null, null, null);
    }

    /**
     * Type of the result, must be photo
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
     * Caption of the photo to be sent, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the photo caption. See formatting options for more details.
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
     * Pass True if the photo needs to be covered with a spoiler animation
     */
    public @Nullable Boolean hasSpoiler() {
        return hasSpoiler;
    }

    public InputMediaPhoto withMedia(InputFileOrString media) {
        return new InputMediaPhoto(type, media, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler);
    }

    public InputMediaPhoto withCaption(@Nullable String caption) {
        return new InputMediaPhoto(type, media, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler);
    }

    public InputMediaPhoto withParseMode(@Nullable ParseMode parseMode) {
        return new InputMediaPhoto(type, media, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler);
    }

    public InputMediaPhoto withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InputMediaPhoto(type, media, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler);
    }

    public InputMediaPhoto withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InputMediaPhoto(type, media, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler);
    }

    public InputMediaPhoto withHasSpoiler(@Nullable Boolean hasSpoiler) {
        return new InputMediaPhoto(type, media, caption, parseMode, captionEntities, showCaptionAboveMedia, hasSpoiler);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputMediaPhoto)) {
            return false;
        }
        InputMediaPhoto that = (InputMediaPhoto) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.media, that.media)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.showCaptionAboveMedia, that.showCaptionAboveMedia)
                && Objects.equals(this.hasSpoiler, that.hasSpoiler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.media, this.caption, this.parseMode, this.captionEntities, this.showCaptionAboveMedia, this.hasSpoiler);
    }

    @Override
    public String toString() {
        return "InputMediaPhoto[type=" + this.type
                + ", media=" + this.media
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", showCaptionAboveMedia=" + this.showCaptionAboveMedia
                + ", hasSpoiler=" + this.hasSpoiler
                + "]";
    }
}
