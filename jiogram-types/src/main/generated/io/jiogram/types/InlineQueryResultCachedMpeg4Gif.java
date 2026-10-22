package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the
 * Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional
 * caption. Alternatively, you can use input_message_content to send a message with the specified
 * content instead of the animation.
 *
 * @param type Type of the result, must be mpeg4_gif
 * @param id Unique identifier for this result, 1-64 bytes
 * @param mpeg4FileId A valid file identifier for the MPEG4 file
 * @param title Title for the result
 * @param caption Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the caption. See formatting options for more
 *     details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the video animation
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedmpeg4gif">InlineQueryResultCachedMpeg4Gif in the Bot API</a>
 */
public record InlineQueryResultCachedMpeg4Gif(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("mpeg4_file_id") String mpeg4FileId,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {

    public static InlineQueryResultCachedMpeg4Gif of(String id, String mpeg4FileId) {
        return new InlineQueryResultCachedMpeg4Gif(InlineQueryResultType.MPEG4_GIF, id, mpeg4FileId, null, null, null, null, null, null, null);
    }

    public InlineQueryResultCachedMpeg4Gif withId(String id) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withMpeg4FileId(String mpeg4FileId) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withTitle(@Nullable String title) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withCaption(@Nullable String caption) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withShowCaptionAboveMedia(@Nullable Boolean showCaptionAboveMedia) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedMpeg4Gif withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultCachedMpeg4Gif(type, id, mpeg4FileId, title, caption, parseMode, captionEntities, showCaptionAboveMedia, replyMarkup, inputMessageContent);
    }
}
