package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import io.jiogram.types.VideoMimeType;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultVideo implements InlineQueryResult {
    @JsonProperty("type") private final InlineQueryResultType type;
    @JsonProperty("id") private final String id;
    @JsonProperty("video_url") private final String videoUrl;
    @JsonProperty("mime_type") private final VideoMimeType mimeType;
    @JsonProperty("thumbnail_url") private final String thumbnailUrl;
    @JsonProperty("title") private final String title;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("show_caption_above_media") @Nullable private final Boolean showCaptionAboveMedia;
    @JsonProperty("video_width") @Nullable private final Long videoWidth;
    @JsonProperty("video_height") @Nullable private final Long videoHeight;
    @JsonProperty("video_duration") @Nullable private final Long videoDuration;
    @JsonProperty("description") @Nullable private final String description;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;
    @JsonProperty("input_message_content") @Nullable private final InputMessageContent inputMessageContent;

    @JsonCreator
    public InlineQueryResultVideo(
            @JsonProperty("type") InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("video_url") String videoUrl,
            @JsonProperty("mime_type") VideoMimeType mimeType,
            @JsonProperty("thumbnail_url") String thumbnailUrl,
            @JsonProperty("title") String title,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("video_width") @Nullable Long videoWidth,
            @JsonProperty("video_height") @Nullable Long videoHeight,
            @JsonProperty("video_duration") @Nullable Long videoDuration,
            @JsonProperty("description") @Nullable String description,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
    ) {
        this.type = type;
        this.id = id;
        this.videoUrl = videoUrl;
        this.mimeType = mimeType;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.videoWidth = videoWidth;
        this.videoHeight = videoHeight;
        this.videoDuration = videoDuration;
        this.description = description;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
    }

    public InlineQueryResultType type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public String videoUrl() {
        return this.videoUrl;
    }

    public VideoMimeType mimeType() {
        return this.mimeType;
    }

    public String thumbnailUrl() {
        return this.thumbnailUrl;
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

    public Boolean showCaptionAboveMedia() {
        return this.showCaptionAboveMedia;
    }

    public Long videoWidth() {
        return this.videoWidth;
    }

    public Long videoHeight() {
        return this.videoHeight;
    }

    public Long videoDuration() {
        return this.videoDuration;
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
}
