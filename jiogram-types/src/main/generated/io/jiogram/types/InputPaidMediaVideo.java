package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InputPaidMediaType;
import org.jspecify.annotations.Nullable;

public class InputPaidMediaVideo implements InputPaidMedia {
    @JsonProperty("type") private final InputPaidMediaType type;
    @JsonProperty("media") private final String media;
    @JsonProperty("thumbnail") @Nullable private final String thumbnail;
    @JsonProperty("cover") @Nullable private final String cover;
    @JsonProperty("start_timestamp") @Nullable private final Long startTimestamp;
    @JsonProperty("width") @Nullable private final Long width;
    @JsonProperty("height") @Nullable private final Long height;
    @JsonProperty("duration") @Nullable private final Long duration;
    @JsonProperty("supports_streaming") @Nullable private final Boolean supportsStreaming;

    @JsonCreator
    public InputPaidMediaVideo(
            @JsonProperty("type") InputPaidMediaType type,
            @JsonProperty("media") String media,
            @JsonProperty("thumbnail") @Nullable String thumbnail,
            @JsonProperty("cover") @Nullable String cover,
            @JsonProperty("start_timestamp") @Nullable Long startTimestamp,
            @JsonProperty("width") @Nullable Long width,
            @JsonProperty("height") @Nullable Long height,
            @JsonProperty("duration") @Nullable Long duration,
            @JsonProperty("supports_streaming") @Nullable Boolean supportsStreaming
    ) {
        this.type = type;
        this.media = media;
        this.thumbnail = thumbnail;
        this.cover = cover;
        this.startTimestamp = startTimestamp;
        this.width = width;
        this.height = height;
        this.duration = duration;
        this.supportsStreaming = supportsStreaming;
    }

    public InputPaidMediaType type() {
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
}
