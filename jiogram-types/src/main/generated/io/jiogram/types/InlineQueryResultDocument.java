package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.DocumentMimeType;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to a file. By default, this file will be sent by the user with an optional
 * caption. Alternatively, you can use input_message_content to send a message with the specified
 * content instead of the file. Currently, only .PDF and .ZIP files can be sent using this method.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultdocument">InlineQueryResultDocument in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultDocument implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("caption")
    private final @Nullable String caption;

    @JsonProperty("parse_mode")
    private final @Nullable ParseMode parseMode;

    @JsonProperty("caption_entities")
    private final @Nullable List<MessageEntity> captionEntities;

    @JsonProperty("document_url")
    private final String documentUrl;

    @JsonProperty("mime_type")
    private final DocumentMimeType mimeType;

    @JsonProperty("description")
    private final @Nullable String description;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("input_message_content")
    private final @Nullable InputMessageContent inputMessageContent;

    @JsonProperty("thumbnail_url")
    private final @Nullable String thumbnailUrl;

    @JsonProperty("thumbnail_width")
    private final @Nullable Long thumbnailWidth;

    @JsonProperty("thumbnail_height")
    private final @Nullable Long thumbnailHeight;

    /**
     * Creates a new {@code InlineQueryResultDocument} instance.
     *
     * @param type Type of the result, must be document
     * @param id Unique identifier for this result, 1-64 bytes
     * @param title Title for the result
     * @param caption Caption of the document to be sent, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the document caption. See formatting options
     *     for more details.
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
     */
    @JsonCreator
    public InlineQueryResultDocument(
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
            @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight) {
        this.type = type;
        this.id = id;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.documentUrl = documentUrl;
        this.mimeType = mimeType;
        this.description = description;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public static InlineQueryResultDocument of(String id, String title, String documentUrl, DocumentMimeType mimeType) {
        return new InlineQueryResultDocument(InlineQueryResultType.DOCUMENT, id, title, null, null, null, documentUrl, mimeType, null, null, null, null, null, null);
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
     * A valid URL for the file
     */
    public String documentUrl() {
        return documentUrl;
    }

    /**
     * MIME type of the content of the file, either 'application/pdf' or 'application/zip'
     */
    public DocumentMimeType mimeType() {
        return mimeType;
    }

    /**
     * Short description of the result
     */
    public @Nullable String description() {
        return description;
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

    /**
     * URL of the thumbnail (JPEG only) for the file
     */
    public @Nullable String thumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Thumbnail width
     */
    public @Nullable Long thumbnailWidth() {
        return thumbnailWidth;
    }

    /**
     * Thumbnail height
     */
    public @Nullable Long thumbnailHeight() {
        return thumbnailHeight;
    }

    public InlineQueryResultDocument withId(String id) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withTitle(String title) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withCaption(@Nullable String caption) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withParseMode(@Nullable ParseMode parseMode) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withDocumentUrl(String documentUrl) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withMimeType(DocumentMimeType mimeType) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withDescription(@Nullable String description) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withInputMessageContent(@Nullable InputMessageContent inputMessageContent) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withThumbnailUrl(@Nullable String thumbnailUrl) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withThumbnailWidth(@Nullable Long thumbnailWidth) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultDocument withThumbnailHeight(@Nullable Long thumbnailHeight) {
        return new InlineQueryResultDocument(type, id, title, caption, parseMode, captionEntities, documentUrl, mimeType, description, replyMarkup, inputMessageContent, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultDocument)) {
            return false;
        }
        InlineQueryResultDocument that = (InlineQueryResultDocument) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.caption, that.caption)
                && Objects.equals(this.parseMode, that.parseMode)
                && Objects.equals(this.captionEntities, that.captionEntities)
                && Objects.equals(this.documentUrl, that.documentUrl)
                && Objects.equals(this.mimeType, that.mimeType)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent)
                && Objects.equals(this.thumbnailUrl, that.thumbnailUrl)
                && Objects.equals(this.thumbnailWidth, that.thumbnailWidth)
                && Objects.equals(this.thumbnailHeight, that.thumbnailHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.title, this.caption, this.parseMode, this.captionEntities, this.documentUrl, this.mimeType, this.description, this.replyMarkup, this.inputMessageContent, this.thumbnailUrl, this.thumbnailWidth, this.thumbnailHeight);
    }

    @Override
    public String toString() {
        return "InlineQueryResultDocument[type=" + this.type
                + ", id=" + this.id
                + ", title=" + this.title
                + ", caption=" + this.caption
                + ", parseMode=" + this.parseMode
                + ", captionEntities=" + this.captionEntities
                + ", documentUrl=" + this.documentUrl
                + ", mimeType=" + this.mimeType
                + ", description=" + this.description
                + ", replyMarkup=" + this.replyMarkup
                + ", inputMessageContent=" + this.inputMessageContent
                + ", thumbnailUrl=" + this.thumbnailUrl
                + ", thumbnailWidth=" + this.thumbnailWidth
                + ", thumbnailHeight=" + this.thumbnailHeight
                + "]";
    }
}
