package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.DocumentMimeType;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultDocument implements InlineQueryResult {
    @JsonProperty("type") private final InlineQueryResultType type;
    @JsonProperty("id") private final String id;
    @JsonProperty("title") private final String title;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("document_url") private final String documentUrl;
    @JsonProperty("mime_type") private final DocumentMimeType mimeType;
    @JsonProperty("description") @Nullable private final String description;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;
    @JsonProperty("input_message_content") @Nullable private final InputMessageContent inputMessageContent;
    @JsonProperty("thumbnail_url") @Nullable private final String thumbnailUrl;
    @JsonProperty("thumbnail_width") @Nullable private final Long thumbnailWidth;
    @JsonProperty("thumbnail_height") @Nullable private final Long thumbnailHeight;

    @JsonCreator
    public InlineQueryResultDocument(
            @JsonProperty("type") InlineQueryResultType type,
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
    ) {
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

    public InlineQueryResultType type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public String caption() {
        return this.caption;
    }

    public ParseMode parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> captionEntities() {
        return this.captionEntities;
    }

    public String documentUrl() {
        return this.documentUrl;
    }

    public DocumentMimeType mimeType() {
        return this.mimeType;
    }

    public String description() {
        return this.description;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    public InputMessageContent inputMessageContent() {
        return this.inputMessageContent;
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
