package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InlineQueryResultVideo(
    @JsonProperty("type") String type,
    @JsonProperty("id") String id,
    @JsonProperty("video_url") String videoUrl,
    @JsonProperty("mime_type") String mimeType,
    @JsonProperty("thumbnail_url") String thumbnailUrl,
    @JsonProperty("title") String title,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable String parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("video_width") @Nullable Long videoWidth,
    @JsonProperty("video_height") @Nullable Long videoHeight,
    @JsonProperty("video_duration") @Nullable Long videoDuration,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {}
