package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InputMediaAudio(
    @JsonProperty("type") String type,
    @JsonProperty("media") String media,
    @JsonProperty("thumbnail") @Nullable String thumbnail,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable String parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("duration") @Nullable Long duration,
    @JsonProperty("performer") @Nullable String performer,
    @JsonProperty("title") @Nullable String title
) implements InputMedia {}
