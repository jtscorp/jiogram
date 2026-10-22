package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.DocumentMimeType;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to a file. By default, this file will be sent by the user with an optional
 * caption. Alternatively, you can use input_message_content to send a message with the specified
 * content instead of the file. Currently, only .PDF and .ZIP files can be sent using this method.
 *
 * @param type Type of the result, must be document
 * @param id Unique identifier for this result, 1-64 bytes
 * @param title Title for the result
 * @param caption Caption of the document to be sent, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the document caption. See formatting options for
 *     more details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param documentUrl A valid URL for the file
 * @param mimeType MIME type of the content of the file, either 'application/pdf' or
 *     'application/zip'
 * @param description Short description of the result
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the file
 * @param thumbnailUrl URL of the thumbnail (JPEG only) for the file
 * @param thumbnailWidth Thumbnail width
 * @param thumbnailHeight Thumbnail height
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultdocument">InlineQueryResultDocument in the Bot API</a>
 */
public record InlineQueryResultDocument(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("title") String title,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("document_url") String documentUrl,
    @JsonProperty("mime_type") DocumentMimeType mimeType,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent,
    @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl,
    @JsonProperty("thumbnail_width") @Nullable Long thumbnailWidth,
    @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight
) implements InlineQueryResult {}
