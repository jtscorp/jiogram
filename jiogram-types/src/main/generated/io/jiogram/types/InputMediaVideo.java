package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.MessageEntity;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputMediaVideo implements InputMedia {
    @JsonProperty("type") private final String type;
    @JsonProperty("media") private final String media;
    @JsonProperty("thumbnail") @Nullable private final String thumbnail;
    @JsonProperty("cover") @Nullable private final String cover;
    @JsonProperty("start_timestamp") @Nullable private final Long startTimestamp;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final String parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("show_caption_above_media") @Nullable private final Boolean showCaptionAboveMedia;
    @JsonProperty("width") @Nullable private final Long width;
    @JsonProperty("height") @Nullable private final Long height;
    @JsonProperty("duration") @Nullable private final Long duration;
    @JsonProperty("supports_streaming") @Nullable private final Boolean supportsStreaming;
    @JsonProperty("has_spoiler") @Nullable private final Boolean hasSpoiler;

    @JsonCreator
    public InputMediaVideo(
            @JsonProperty("type") String type,
            @JsonProperty("media") String media,
            @JsonProperty("thumbnail") @Nullable String thumbnail,
            @JsonProperty("cover") @Nullable String cover,
            @JsonProperty("start_timestamp") @Nullable Long startTimestamp,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable String parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("show_caption_above_media") @Nullable Boolean showCaptionAboveMedia,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("duration") @Nullable Long duration,
            @JsonProperty("supports_streaming") @Nullable Boolean supportsStreaming,
            @JsonProperty("has_spoiler") @Nullable Boolean hasSpoiler
    ) {
        this.type = type;
        this.media = media;
        this.thumbnail = thumbnail;
        this.cover = cover;
        this.startTimestamp = startTimestamp;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.showCaptionAboveMedia = showCaptionAboveMedia;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.supportsStreaming = supportsStreaming;
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

    public String cover() {
        return this.cover;
    }

    public Long startTimestamp() {
        return this.startTimestamp;
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

    public Boolean supportsStreaming() {
        return this.supportsStreaming;
    }

    public Boolean hasSpoiler() {
        return this.hasSpoiler;
    }
}
