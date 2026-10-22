package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputMediaType;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Represents a general file to be sent.
 *
 * @param type Type of the result, must be document
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
 * @param caption Caption of the document to be sent, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the document caption. See formatting options for
 *     more details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param disableContentTypeDetection Disables automatic server-side content type detection for
 *     files uploaded using multipart/form-data. Always True, if the document is sent as part of an
 *     album.
 * @see <a href="https://core.telegram.org/bots/api#inputmediadocument">InputMediaDocument in the Bot API</a>
 */
public record InputMediaDocument(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputMediaType type,
    @JsonProperty("media") InputFileOrString media,
    @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("disable_content_type_detection") @Nullable Boolean disableContentTypeDetection
) implements InputMedia {

    public static InputMediaDocument of(InputFileOrString media) {
        return new InputMediaDocument(InputMediaType.DOCUMENT, media, null, null, null, null, null);
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
}
