package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record InputMediaDocument(
    @JsonProperty("type") String type,
    @JsonProperty("media") String media,
    @JsonProperty("thumbnail") @Nullable String thumbnail,
    @JsonProperty("caption") @Nullable String caption,
    @JsonProperty("parse_mode") @Nullable String parseMode,
    @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
    @JsonProperty("disable_content_type_detection") @Nullable Boolean disableContentTypeDetection
) implements InputMedia {}
