package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InputMessageContent;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InlineQueryResultCachedVideo(
    @JsonProperty("type") String type,
    @JsonProperty("id") String id,
    @JsonProperty("video_file_id") String videoFileId,
    @JsonProperty("title") String title,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable String parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
    @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent
) implements InlineQueryResult {}
