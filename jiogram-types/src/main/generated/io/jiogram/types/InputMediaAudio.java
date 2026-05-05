package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputMediaType;
import io.jiogram.types.MessageEntity;
import io.jiogram.types.ParseMode;
import java.util.List;
import org.jspecify.annotations.Nullable;

public class InputMediaAudio implements InputMedia {
    @JsonProperty("type") private final InputMediaType type;
    @JsonProperty("media") private final String media;
    @JsonProperty("thumbnail") @Nullable private final String thumbnail;
    @JsonProperty("caption") @Nullable private final String caption;
    @JsonProperty("parse_mode") @Nullable private final ParseMode parseMode;
    @JsonProperty("caption_entities") @Nullable private final List<MessageEntity> captionEntities;
    @JsonProperty("duration") @Nullable private final Long duration;
    @JsonProperty("performer") @Nullable private final String performer;
    @JsonProperty("title") @Nullable private final String title;

    @JsonCreator
    public InputMediaAudio(
            @JsonProperty("type") InputMediaType type,
            @JsonProperty("media") String media,
            @JsonProperty("thumbnail") @Nullable String thumbnail,
            @JsonProperty("caption") @Nullable String caption,
            @JsonProperty("parse_mode") @Nullable ParseMode parseMode,
            @JsonProperty("caption_entities") @Nullable List<MessageEntity> captionEntities,
            @JsonProperty("duration") @Nullable Long duration,
            @JsonProperty("performer") @Nullable String performer,
            @JsonProperty("title") @Nullable String title
    ) {
        this.type = type;
        this.media = media;
        this.thumbnail = thumbnail;
        this.caption = caption;
        this.parseMode = parseMode;
        this.captionEntities = captionEntities;
        this.duration = duration;
        this.performer = performer;
        this.title = title;
    }

    public InputMediaType type() {
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

    public ParseMode parseMode() {
        return this.parseMode;
    }

    public List<MessageEntity> captionEntities() {
        return this.captionEntities;
    }

    public Long duration() {
        return this.duration;
    }

    public String performer() {
        return this.performer;
    }

    public String title() {
        return this.title;
    }
}
