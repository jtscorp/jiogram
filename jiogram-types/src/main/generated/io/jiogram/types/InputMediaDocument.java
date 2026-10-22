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
 * Represents a general file to be sent.
 *
 * @see <a href="https://core.telegram.org/bots/api#inputmediadocument">InputMediaDocument in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InputMediaDocument implements InputMedia {

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

    @JsonProperty("disable_content_type_detection")
    private final @Nullable Boolean disableContentTypeDetection;

    /**
     * Creates a new {@code InputMediaDocument} instance.
     *
     * @param type Type of the result, must be document
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
     * @param caption Caption of the document to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the document caption. See formatting options
     *     for more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param disableContentTypeDetection Disables automatic server-side content type detection for
     *     files uploaded using multipart/form-data. Always True, if the document is sent as part of
     *     an album.
     */
    @JsonCreator
    public InputMediaDocument(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputMediaType type,
            @JsonProperty("media") InputFileOrString media,
            @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("disable_content_type_detection") @Nullable Boolean disableContentTypeDetection) {
        this.type = type;
        this.media = media;
        this.thumbnail = thumbnail;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.disableContentTypeDetection = disableContentTypeDetection;
    }

    public static InputMediaDocument of(InputFileOrString media) {
        return new InputMediaDocument(InputMediaType.DOCUMENT, media, null, null, null, null, null);
    }

    /**
     * Type of the result, must be document
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
     * Caption of the document to be sent, 0-1024 characters after entities parsing
     */
    public @Nullable String caption() {
        return caption;
    }

    /**
     * Mode for parsing entities in the document caption. See formatting options for more details.
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
     * Disables automatic server-side content type detection for files uploaded using
     * multipart/form-data. Always True, if the document is sent as part of an album.
     */
    public @Nullable Boolean disableContentTypeDetection() {
        return disableContentTypeDetection;
    }

    public InputMediaDocument withMedia(InputFileOrString media) {
        return new InputMediaDocument(type, media, thumbnail, caption, parseMode, captionEntities, disableContentTypeDetection);
    }

    public InputMediaDocument withThumbnail(@Nullable InputFileOrString thumbnail) {
        return new InputMediaDocument(type, media, thumbnail, caption, parseMode, captionEntities, disableContentTypeDetection);
    }

    public InputMediaDocument withCaption(@Nullable String caption) {
        return new InputMediaDocument(type, media, thumbnail, caption, parseMode, captionEntities, disableContentTypeDetection);
    }

    public InputMediaDocument withParseMode(@Nullable ParseMode parseMode) {
        return new InputMediaDocument(type, media, thumbnail, caption, parseMode, captionEntities, disableContentTypeDetection);
    }

    public InputMediaDocument withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InputMediaDocument(type, media, thumbnail, caption, parseMode, captionEntities, disableContentTypeDetection);
    }

    public InputMediaDocument withDisableContentTypeDetection(@Nullable Boolean disableContentTypeDetection) {
        return new InputMediaDocument(type, media, thumbnail, caption, parseMode, captionEntities, disableContentTypeDetection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InputMediaDocument)) {
            return false;
        }
        InputMediaDocument that = (InputMediaDocument) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.media, that.media)
                && Objects.equals(this.thumbnail, that.thumbnail)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.disableContentTypeDetection, that.disableContentTypeDetection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.media, this.thumbnail, this.caption, this.parseMode, this.captionEntities, this.disableContentTypeDetection);
    }

    @Override
    public String toString() {
        return "InputMediaDocument[type=" + this.type
                + ", media=" + this.media
                + ", thumbnail=" + this.thumbnail
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", disableContentTypeDetection=" + this.disableContentTypeDetection
                + "]";
    }
}
