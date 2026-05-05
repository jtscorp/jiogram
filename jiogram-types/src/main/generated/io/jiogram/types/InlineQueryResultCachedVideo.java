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

public class InlineQueryResultCachedVideo implements InlineQueryResult {
    @JsonProperty("type") private final InlineQueryResultType type;
    @JsonProperty("id") private final String id;
    @JsonProperty("video_file_id") private final String videoFileId;
    @JsonProperty("title") private final String title;
    @JsonProperty("description") @Nullable private final String description;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("show_caption_above_media") @Nullable private final Boolean showCaptionAboveMedia;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;
    @JsonProperty("input_message_content") @Nullable private final InputMessageContent inputMessageContent;

    @JsonCreator
    public InlineQueryResultCachedVideo(
            @JsonProperty("type") InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("video_file_id") String videoFileId,
            @JsonProperty("title") String title,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
    ) {
        this.type = type;
        this.id = id;
        this.videoFileId = videoFileId;
        this.title = title;
        this.description = description;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public InlineQueryResultType type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public String videoFileId() {
        return this.videoFileId;
    }

    public String title() {
        return this.title;
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

    public Boolean showCaptionAboveMedia() {
        return this.showCaptionAboveMedia;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    public InputMessageContent inputMessageContent() {
        return this.inputMessageContent;
    }
}
