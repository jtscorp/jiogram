package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputMediaDocument implements InputMedia {
    @JsonProperty("type") private final String type;
    @JsonProperty("media") private final String media;
    @JsonProperty("thumbnail") @Nullable private final String thumbnail;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final String parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("disable_content_type_detection") @Nullable private final Boolean disableContentTypeDetection;

    @JsonCreator
    public InputMediaDocument(
            @JsonProperty("type") String type,
            @JsonProperty("media") String media,
            @JsonProperty("thumbnail") @Nullable String thumbnail,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable String parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("disable_content_type_detection") @Nullable Boolean disableContentTypeDetection
    ) {
        this.type = type;
        this.media = media;
        this.thumbnail = thumbnail;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.disableContentTypeDetection = disableContentTypeDetection;
    }

    public String type() {
        return this.type;
    }

    public String media() {
        return this.media;
    }

    public String thumbnail() {
        return this.thumbnail;
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

    public Boolean disableContentTypeDetection() {
        return this.disableContentTypeDetection;
    }
}
