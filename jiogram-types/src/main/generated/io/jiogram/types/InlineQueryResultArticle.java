package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to an article or web page.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultarticle">InlineQueryResultArticle in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQueryResultArticle implements InlineQueryResult {

    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private final InlineQueryResultType type;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("input_message_content")
    private final InputMessageContent inputMessageContent;

    @JsonProperty("reply_markup")
    private final @Nullable InlineKeyboardMarkup replyMarkup;

    @JsonProperty("url")
    private final @Nullable String url;

    @JsonProperty("description")
    private final @Nullable String description;

    @JsonProperty("thumbnail_url")
    private final @Nullable String thumbnailUrl;

    @JsonProperty("thumbnail_width")
    private final @Nullable Long thumbnailWidth;

    @JsonProperty("thumbnail_height")
    private final @Nullable Long thumbnailHeight;

    /**
     * Creates a new {@code InlineQueryResultArticle} instance.
     *
     * @param type Type of the result, must be article
     * @param id Unique identifier for this result, 1-64 Bytes
     * @param title Title of the result
     * @param inputMessageContent Content of the message to be sent
     * @param replyMarkup Inline keyboard attached to the message
     * @param url URL of the result
     * @param description Short description of the result
     * @param thumbnailUrl Url of the thumbnail for the result
     * @param thumbnailWidth Thumbnail width
     * @param thumbnailHeight Thumbnail height
     */
    @JsonCreator
    public InlineQueryResultArticle(
            @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("input_message_content") InputMessageContent inputMessageContent,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("url") @Nullable String url,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl,
            @JsonProperty("thumbnail_width") @Nullable Long thumbnailWidth,
            @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight) {
        this.type = type;
        this.id = id;
        this.title = title;
        this.inputMessageContent = inputMessageContent;
        this.replyMarkup = replyMarkup;
        this.url = url;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public static InlineQueryResultArticle of(String id, String title, InputMessageContent inputMessageContent) {
        return new InlineQueryResultArticle(InlineQueryResultType.ARTICLE, id, title, inputMessageContent, null, null, null, null, null, null);
    }

    /**
     * Type of the result, must be article
     */
    public InlineQueryResultType type() {
        return type;
    }

    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    public String id() {
        return id;
    }

    /**
     * Title of the result
     */
    public String title() {
        return title;
    }

    /**
     * Content of the message to be sent
     */
    public InputMessageContent inputMessageContent() {
        return inputMessageContent;
    }

    /**
     * Inline keyboard attached to the message
     */
    public @Nullable InlineKeyboardMarkup replyMarkup() {
        return replyMarkup;
    }

    /**
     * URL of the result
     */
    public @Nullable String url() {
        return url;
    }

    /**
     * Short description of the result
     */
    public @Nullable String description() {
        return description;
    }

    /**
     * Url of the thumbnail for the result
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

    public InlineQueryResultArticle withId(String id) {
        return new InlineQueryResultArticle(type, id, title, inputMessageContent, replyMarkup, url, description, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultArticle withTitle(String title) {
        return new InlineQueryResultArticle(type, id, title, inputMessageContent, replyMarkup, url, description, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultArticle withInputMessageContent(InputMessageContent inputMessageContent) {
        return new InlineQueryResultArticle(type, id, title, inputMessageContent, replyMarkup, url, description, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultArticle withReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        return new InlineQueryResultArticle(type, id, title, inputMessageContent, replyMarkup, url, description, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultArticle withUrl(@Nullable String url) {
        return new InlineQueryResultArticle(type, id, title, inputMessageContent, replyMarkup, url, description, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultArticle withDescription(@Nullable String description) {
        return new InlineQueryResultArticle(type, id, title, inputMessageContent, replyMarkup, url, description, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultArticle withThumbnailUrl(@Nullable String thumbnailUrl) {
        return new InlineQueryResultArticle(type, id, title, inputMessageContent, replyMarkup, url, description, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultArticle withThumbnailWidth(@Nullable Long thumbnailWidth) {
        return new InlineQueryResultArticle(type, id, title, inputMessageContent, replyMarkup, url, description, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    public InlineQueryResultArticle withThumbnailHeight(@Nullable Long thumbnailHeight) {
        return new InlineQueryResultArticle(type, id, title, inputMessageContent, replyMarkup, url, description, thumbnailUrl, thumbnailWidth, thumbnailHeight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQueryResultArticle)) {
            return false;
        }
        InlineQueryResultArticle that = (InlineQueryResultArticle) o;
        return Objects.equals(this.type, that.type)
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.inputMessageContent, that.inputMessageContent)
                && Objects.equals(this.replyMarkup, that.replyMarkup)
                && Objects.equals(this.url, that.url)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.thumbnailUrl, that.thumbnailUrl)
                && Objects.equals(this.thumbnailWidth, that.thumbnailWidth)
                && Objects.equals(this.thumbnailHeight, that.thumbnailHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.id, this.title, this.inputMessageContent, this.replyMarkup, this.url, this.description, this.thumbnailUrl, this.thumbnailWidth, this.thumbnailHeight);
    }

    @Override
    public String toString() {
        return "InlineQueryResultArticle[type=" + this.type
                + ", id=" + this.id
                + ", title=" + this.title
                + ", inputMessageContent=" + this.inputMessageContent
                + ", replyMarkup=" + this.replyMarkup
                + ", url=" + this.url
                + ", description=" + this.description
                + ", thumbnailUrl=" + this.thumbnailUrl
                + ", thumbnailWidth=" + this.thumbnailWidth
                + ", thumbnailHeight=" + this.thumbnailHeight
                + "]";
    }
}
