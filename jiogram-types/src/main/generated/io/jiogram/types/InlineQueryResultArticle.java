package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultArticle implements InlineQueryResult {
    @JsonProperty("type") private final String type;
    @JsonProperty("id") private final String id;
    @JsonProperty("title") private final String title;
    @JsonProperty("input_message_content") private final InputMessageContent inputMessageContent;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;
    @JsonProperty("url") @Nullable private final String url;
    @JsonProperty("description") @Nullable private final String description;
    @JsonProperty("thumbnail_url") @Nullable private final String thumbnailUrl;
    @JsonProperty("thumbnail_width") @Nullable private final Long thumbnailWidth;
    @JsonProperty("thumbnail_height") @Nullable private final Long thumbnailHeight;

    @JsonCreator
    public InlineQueryResultArticle(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("input_message_content") InputMessageContent inputMessageContent,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("url") @Nullable String url,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl,
            @JsonProperty("thumbnail_width") @Nullable Long thumbnailWidth,
            @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight
    ) {
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

    public String type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public InputMessageContent inputMessageContent() {
        return this.inputMessageContent;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    public String url() {
        return this.url;
    }

    public String description() {
        return this.description;
    }

    public String thumbnailUrl() {
        return this.thumbnailUrl;
    }

    public Long thumbnailWidth() {
        return this.thumbnailWidth;
    }

    public Long thumbnailHeight() {
        return this.thumbnailHeight;
    }
}
