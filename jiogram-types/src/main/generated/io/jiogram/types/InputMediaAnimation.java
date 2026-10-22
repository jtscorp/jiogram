package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputMediaType;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.
 *
 * @param type Type of the result, must be animation
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
 * @param caption Caption of the animation to be sent, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the animation caption. See formatting options for
 *     more details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
 * @param width Animation width
 * @param height Animation height
 * @param duration Animation duration in seconds
 * @param hasSpoiler Pass True if the animation needs to be covered with a spoiler animation
 * @see <a href="https://core.telegram.org/bots/api#inputmediaanimation">InputMediaAnimation in the Bot API</a>
 */
public record InputMediaAnimation(
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
    @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler
) implements InputMedia {

    public static InputMediaAnimation of(InputFileOrString media) {
        return new InputMediaAnimation(InputMediaType.ANIMATION, media, null, null, null, null, null, null, null, null, null);
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
}
