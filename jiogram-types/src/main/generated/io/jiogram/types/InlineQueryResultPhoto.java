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
 * Represents a link to a photo. By default, this photo will be sent by the user with optional
 * caption. Alternatively, you can use input_message_content to send a message with the specified
 * content instead of the photo.
 *
 * @param type Type of the result, must be photo
 * @param id Unique identifier for this result, 1-64 bytes
 * @param photoUrl A valid URL of the photo. Photo must be in JPEG format. Photo size must not
 *     exceed 5MB
 * @param thumbnailUrl URL of the thumbnail for the photo
 * @param photoWidth Width of the photo
 * @param photoHeight Height of the photo
 * @param title Title for the result
 * @param description Short description of the result
 * @param caption Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the photo caption. See formatting options for more
 *     details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param showCaptionAboveMedia Pass True, if the caption must be shown above the message media
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the photo
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultphoto">InlineQueryResultPhoto in the Bot API</a>
 */
public record InlineQueryResultPhoto(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("photo_url") String photoUrl,
    @JsonProperty("thumbnail_url") String thumbnailUrl,
    @JsonProperty("photo_width") @Nullable Long photoWidth,
    @JsonProperty("photo_height") @Nullable Long photoHeight,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {}
