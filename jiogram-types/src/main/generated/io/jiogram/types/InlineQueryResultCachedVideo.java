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
 * Represents a link to a video file stored on the Telegram servers. By default, this video file
 * will be sent by the user with an optional caption. Alternatively, you can use
 * input_message_content to send a message with the specified content instead of the video.
 *
 * @param type Type of the result, must be video
 * @param id Unique identifier for this result, 1-64 bytes
 * @param videoFileId A valid file identifier for the video file
 * @param title Title for the result
 * @param description Short description of the result
 * @param caption Caption of the video to be sent, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the video caption. See formatting options for more
 *     details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the video
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedvideo">InlineQueryResultCachedVideo in the Bot API</a>
 */
public record InlineQueryResultCachedVideo(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("video_file_id") String videoFileId,
    @JsonProperty("title") String title,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {}
