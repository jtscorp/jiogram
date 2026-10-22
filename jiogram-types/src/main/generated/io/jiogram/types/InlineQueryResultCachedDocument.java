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
 * Represents a link to a file stored on the Telegram servers. By default, this file will be sent by
 * the user with an optional caption. Alternatively, you can use input_message_content to send a
 * message with the specified content instead of the file.
 *
 * @param type Type of the result, must be document
 * @param id Unique identifier for this result, 1-64 bytes
 * @param title Title for the result
 * @param documentFileId A valid file identifier for the file
 * @param description Short description of the result
 * @param caption Caption of the document to be sent, 0-1024 characters after entities parsing
 * @param parseMode Mode for parsing entities in the document caption. See formatting options for
 *     more details.
 * @param captionEntities List of special entities that appear in the caption, which can be
 *     specified instead of parse_mode
 * @param replyMarkup Inline keyboard attached to the message
 * @param inputMessageContent Content of the message to be sent instead of the file
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcacheddocument">InlineQueryResultCachedDocument in the Bot API</a>
 */
public record InlineQueryResultCachedDocument(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("title") String title,
    @JsonProperty("document_file_id") String documentFileId,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {

    public InlineQueryResultCachedDocument withId(String id) {
        return new InlineQueryResultCachedDocument(type, id, title, documentFileId, description, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedDocument withTitle(String title) {
        return new InlineQueryResultCachedDocument(type, id, title, documentFileId, description, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedDocument withDocumentFileId(String documentFileId) {
        return new InlineQueryResultCachedDocument(type, id, title, documentFileId, description, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedDocument withDescription(@Nullable String description) {
        return new InlineQueryResultCachedDocument(type, id, title, documentFileId, description, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedDocument withCaption(@Nullable String caption) {
        return new InlineQueryResultCachedDocument(type, id, title, documentFileId, description, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedDocument withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultCachedDocument(type, id, title, documentFileId, description, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedDocument withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultCachedDocument(type, id, title, documentFileId, description, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedDocument withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultCachedDocument(type, id, title, documentFileId, description, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }

    public InlineQueryResultCachedDocument withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultCachedDocument(type, id, title, documentFileId, description, caption, parseMode, captionEntities, replyMarkup, inputMessageContent);
    }
}
