package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputMediaAnimation implements InputMedia {
    @JsonProperty("type") private final String type;
    @JsonProperty("media") private final String media;
    @JsonProperty("thumbnail") @Nullable private final String thumbnail;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final String parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("show_caption_above_media") @Nullable private final Boolean showCaptionAboveMedia;
    @JsonProperty("width") @Nullable private final Long width;
    @JsonProperty("height") @Nullable private final Long height;
    @JsonProperty("duration") @Nullable private final Long duration;
    @JsonProperty("has_spoiler") @Nullable private final Boolean hasSpoiler;

    @JsonCreator
    public InputMediaAnimation(
            @JsonProperty("type") String type,
            @JsonProperty("media") String media,
            @JsonProperty("thumbnail") @Nullable String thumbnail,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable String parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("duration") @Nullable Long duration,
            @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler
    ) {
        this.type = type;
        this.media = media;
        this.thumbnail = thumbnail;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.hasSpoiler = hasSpoiler;
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

    public Boolean showCaptionAboveMedia() {
        return this.showCaptionAboveMedia;
    }

    public Long width() {
        return this.width;
    }

    public Long height() {
        return this.height;
    }

    public Long duration() {
        return this.duration;
    }

    public Boolean hasSpoiler() {
        return this.hasSpoiler;
    }
}
