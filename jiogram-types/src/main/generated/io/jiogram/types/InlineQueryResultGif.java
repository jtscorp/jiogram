package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.ThumbnailMimeType;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the
 * user with optional caption. Alternatively, you can use input_message_content to send a message
 * with the specified content instead of the animation.
 *
 * @param type Type of the result, must be gif
 * @param id Unique identifier for this result, 1-64 bytes
 * @param gifUrl A valid URL for the GIF file
 * @param gifWidth Width of the GIF
 * @param gifHeight Height of the GIF
 * @param gifDuration Duration of the GIF in seconds
 * @param thumbnailUrl URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
 * @param thumbnailMimeType MIME type of the thumbnail, must be one of 'image/jpeg', 'image/gif', or
 *     'video/mp4'. Defaults to 'image/jpeg'
 * @param title Title for the result
 * @param caption Caption of the GIF file to be sent, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the caption. See formatting options for more
 *     details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the GIF animation
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultgif">InlineQueryResultGif in the Bot API</a>
 */
public record InlineQueryResultGif(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("gif_url") String gifUrl,
    @JsonProperty("gif_width") @Nullable Long gifWidth,
    @JsonProperty("gif_height") @Nullable Long gifHeight,
    @JsonProperty("gif_duration") @Nullable Long gifDuration,
    @JsonProperty("thumbnail_url") String thumbnailUrl,
    @JsonProperty("thumbnail_mime_type") @Nullable ThumbnailMimeType thumbnailMimeType,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {

    public InlineQueryResultGif withId(String id) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withGifUrl(String gifUrl) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withGifWidth(@Nullable Long gifWidth) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withGifHeight(@Nullable Long gifHeight) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withGifDuration(@Nullable Long gifDuration) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withThumbnailUrl(String thumbnailUrl) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withThumbnailMimeType(@Nullable ThumbnailMimeType thumbnailMimeType) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withTitle(@Nullable String title) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withCaption(@Nullable String caption) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultGif withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultGif(type, id, gifUrl, gifWidth, gifHeight, gifDuration, thumbnailUrl, thumbnailMimeType, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }
}
