package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to a file stored on the Telegram servers. By default, this file will be sent by
 * the user with an optional caption. Alternatively, you can use input_message_content to send a
 * message with the specified content instead of the file.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultcacheddocument">InlineQueryResultCachedDocument in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultCachedDocument implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("document_file_id")
    private final String documentFileId;

    @JsonProperty("description")
    private final @Nullable String description;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    /**
     * Creates a new {@code InlineQueryResultCachedDocument} instance.
     *
     * @param type Type of the result, must be document
     * @param id Unique identifier for this result, 1-64 bytes
     * @param title Title for the result
     * @param documentFileId A valid file identifier for the file
     * @param description Short description of the result
     * @param caption Caption of the document to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the document caption. See formatting options
     *     for more details.
     * @param captionEntities List of special entities that appear in the caption, which can be
     *     specified instead of parse_mode
     * @param replyMarkup Inline keyboard attached to the message
     * @param inputMessageContent Content of the message to be sent instead of the file
     */
    @JsonCreator
    public InlineQueryResultCachedDocument(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("document_file_id") String documentFileId,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent) {
        this.type = type;
        this.id = id;
        this.title = title;
        this.documentFileId = documentFileId;
        this.description = description;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public static InlineQueryResultCachedDocument of(String id, String title, String documentFileId) {
        return new InlineQueryResultCachedDocument(InlineQueryResultType.DOCUMENT, id, title, documentFileId, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be document
     */
    public InlineQueryResultType type() {
        return type;
    }

    /**
     * Unique identifier for this result, 1-64 bytes
     */
    public String id() {
        return id;
    }

    /**
     * Title for the result
     */
    public String title() {
        return title;
    }

    /**
     * A valid file identifier for the file
     */
    public String documentFileId() {
        return documentFileId;
    }

    /**
     * Short description of the result
     */
    public @Nullable String description() {
        return description;
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
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * Content of the message to be sent instead of the file
     */
    public @Nullable InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultCachedDocument)) {
            return false;
        }
        InlineQueryResultCachedDocument that = (InlineQueryResultCachedDocument) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.documentFileId, that.documentFileId)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.title, this.documentFileId, this.description, this.caption, this.parseMode, this.captionEntities, this.replyMarkup, this.inputMessageContent);
    }

    @Override
    public String toString() {
        return "InlineQueryResultCachedDocument[type=" + this.type
                + ", id=" + this.id
                + ", title=" + this.title
                + ", documentFileId=" + this.documentFileId
                + ", description=" + this.description
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + "]";
    }
}
