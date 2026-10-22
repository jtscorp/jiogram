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
) implements InlineQueryResult {}
