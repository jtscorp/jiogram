package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputMediaType;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InputMediaAnimation(
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY) InputMediaType type,
    @JsonProperty("media") InputFileOrString media,
    @JsonProperty("thumbnail") @Nullable InputFileOrString thumbnail,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
    @JsonProperty("width") @Nullable Long width,
    @JsonProperty("height") @Nullable Long height,
    @JsonProperty("duration") @Nullable Long duration,
    @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler
) implements InputMedia {}
