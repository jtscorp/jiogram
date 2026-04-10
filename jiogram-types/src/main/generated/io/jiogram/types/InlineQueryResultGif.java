package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultGif implements InlineQueryResult {
    @JsonProperty("type") private final String type;
    @JsonProperty("id") private final String id;
    @JsonProperty("gif_url") private final String gifUrl;
    @JsonProperty("gif_width") @Nullable private final Long gifWidth;
    @JsonProperty("gif_height") @Nullable private final Long gifHeight;
    @JsonProperty("gif_duration") @Nullable private final Long gifDuration;
    @JsonProperty("thumbnail_url") private final String thumbnailUrl;
    @JsonProperty("thumbnail_mime_type") @Nullable private final String thumbnailMimeType;
    @JsonProperty("title") @Nullable private final String title;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final String parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("show_caption_above_media") @Nullable private final Boolean showCaptionAboveMedia;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;
    @JsonProperty("input_message_content") @Nullable private final InputMessageContent inputMessageContent;

    @JsonCreator
    public InlineQueryResultGif(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("gif_url") String gifUrl,
            @JsonProperty("gif_width") @Nullable Long gifWidth,
            @JsonProperty("gif_height") @Nullable Long gifHeight,
            @JsonProperty("gif_duration") @Nullable Long gifDuration,
            @JsonProperty("thumbnail_url") String thumbnailUrl,
            @JsonProperty("thumbnail_mime_type") @Nullable String thumbnailMimeType,
            @JsonProperty("title") @Nullable String title,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable String parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
    ) {
        this.type = type;
        this.id = id;
        this.gifUrl = gifUrl;
        this.gifWidth = gifWidth;
        this.gifHeight = gifHeight;
        this.gifDuration = gifDuration;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailMimeType = thumbnailMimeType;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public String type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public String gifUrl() {
        return this.gifUrl;
    }

    public Long gifWidth() {
        return this.gifWidth;
    }

    public Long gifHeight() {
        return this.gifHeight;
    }

    public Long gifDuration() {
        return this.gifDuration;
    }

    public String thumbnailUrl() {
        return this.thumbnailUrl;
    }

    public String thumbnailMimeType() {
        return this.thumbnailMimeType;
    }

    public String title() {
        return this.title;
    }

    public String caption() {
        return this.caption;
    }

    public String parseMode() {
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
