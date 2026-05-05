package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultCachedDocument implements InlineQueryResult {
    @JsonProperty("type") private final InlineQueryResultType type;
    @JsonProperty("id") private final String id;
    @JsonProperty("title") private final String title;
    @JsonProperty("document_file_id") private final String documentFileId;
    @JsonProperty("description") @Nullable private final String description;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;
    @JsonProperty("input_message_content") @Nullable private final InputMessageContent inputMessageContent;

    @JsonCreator
    public InlineQueryResultCachedDocument(
            @JsonProperty("type") InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("title") String title,
            @JsonProperty("document_file_id") String documentFileId,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
    ) {
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

    public InlineQueryResultType type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public String documentFileId() {
        return this.documentFileId;
    }

    public String description() {
        return this.description;
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

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    public InputMessageContent inputMessageContent() {
        return this.inputMessageContent;
    }
}
