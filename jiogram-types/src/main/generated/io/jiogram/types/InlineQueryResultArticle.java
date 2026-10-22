package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

/**
 * Represents a link to an article or web page.
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
 * @see <a href="https://core.telegram.org/bots/api#inlinequeryresultarticle">InlineQueryResultArticle in the Bot API</a>
 */
public record InlineQueryResultArticle(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InlineQueryResultType type,
    @JsonProperty("id") String id,
    @JsonProperty("title") String title,
    @JsonProperty("input_message_content") InputMessageContent inputMessageContent,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("url") @Nullable String url,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl,
    @JsonProperty("thumbnail_width") @Nullable Long thumbnailWidth,
    @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight
) implements InlineQueryResult {

    public static InlineQueryResultArticle of(String id, String title, InputMessageContent inputMessageContent) {
        return new InlineQueryResultArticle(InlineQueryResultType.ARTICLE, id, title, inputMessageContent, null, null, null, null, null, null);
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
}
